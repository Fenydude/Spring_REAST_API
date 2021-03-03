package com.bogurov.config;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.fasterxml.jackson.databind.Module;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@PropertySource(value= {"classpath:application.properties"})
@ComponentScan(basePackages = "com.bogurov")
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class Config {

    @Autowired
    private DataSourseSettings dataSourseSettings;
    @Autowired
    private SessionFactorySettings sessionFactorySettings;


    @Bean
    public Module datatypeHibernateModule() {
        return new Hibernate5Module();
    }

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(dataSourseSettings.getDriverClass());
            dataSource.setJdbcUrl(dataSourseSettings.getUrl());
            dataSource.setUser(dataSourseSettings.getUsername());
            dataSource.setPassword(dataSourseSettings.getPassword());
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(sessionFactorySettings.getPackagesToScan());

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(sessionFactorySettings.getDialect(),
                sessionFactorySettings.getDialectProperty());
        hibernateProperties.setProperty(sessionFactorySettings.getShowSQL(),
                sessionFactorySettings.getShowSQLProperty());

        sessionFactoryBean.setHibernateProperties(hibernateProperties);
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();

        transactionManager.setSessionFactory(sessionFactoryBean().getObject());

        return transactionManager;
    }
}

