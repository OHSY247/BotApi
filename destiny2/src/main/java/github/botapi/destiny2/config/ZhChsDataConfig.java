package github.botapi.destiny2.config;

import github.botapi.destiny2.service.DataService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import static github.botapi.util.handler.DirHandler.getFiles;

/**
 * @author straycamel
 * @date 2021/5/29
 * 命运2简体中文数据源配置文件
 */

@Configuration //注册到springboot 容器中
@MapperScan(basePackages = "github.botapi.destiny2.dao.zh_chs",
        sqlSessionTemplateRef = "zh_chsSqlSessionTemplate")
public class ZhChsDataConfig {
    @Autowired
    private DataService dataService;

    public ZhChsDataConfig() {
        //dataService.checkManifest();
    }

    @Bean(name = "zh_chsDataSource")
    public DataSource testDataSource() {
        dataService.checkManifest();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        String datafile = getFiles("data/destiny2Manifest/zh-chs/").get(0);
        System.out.println("loading sqlite data source: " + String.format("jdbc:sqlite:%s", datafile));
        dataSource.setUrl(String.format("jdbc:sqlite:%s", datafile));
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean(name = "zh_chsSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory
            (@Qualifier("zh_chsDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "zh_chsTransactionManager")
    public DataSourceTransactionManager testTransactionManager
            (@Qualifier("zh_chsDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "zh_chsSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate
            (@Qualifier("zh_chsSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}


