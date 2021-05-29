/*
package github.botapi.demo;

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
            sqlSessionTemplateRef  = "test2SqlSessionTemplate")
public class Test2Config {
    @Bean(name = "test2DataSource")
    @Primary
    //@ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource testDataSource() {
        //return DataSourceBuilder.create().build();
        */
/**
         * 配置数据源
         *//*

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:./demo2.db");
        dataSource.setUsername("");
        dataSource.setPassword("");
    return dataSource;
    }
    @Primary
    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory
        (@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }
    @Bean(name = "test2TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager
        (@Qualifier("test2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name = "test2SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate
        (@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

*/
