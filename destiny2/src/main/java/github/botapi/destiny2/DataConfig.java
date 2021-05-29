/*
package github.botapi.destiny2;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

*/
/**
 * @author straycamel
 * @date 2021/5/28
 *//*

@Configuration //注册到springboot 容器中
@MapperScan(basePackages = "github.botapi",
            sqlSessionTemplateRef  = "D2SqlSessionTemplate")
public class DataConfig {
    @Bean(name = "D2DataSource")
    @Primary
    public DataSource testDataSource() {
        */
/**
         * 配置数据源
         *//*

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:./demo.db");
        dataSource.setUsername("");
        dataSource.setPassword("");
    return dataSource;
    }
    @Primary
    @Bean(name = "D2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory
        (@Qualifier("D2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }
    @Bean(name = "D2TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager
        (@Qualifier("D2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name = "D2SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate
        (@Qualifier("D2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

*/
