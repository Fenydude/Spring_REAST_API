package com.bogurov.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SessionFactorySettings {
    @Value("${sessionFactory.packagesToScan}")
    private String packagesToScan;
    @Value("${sessionFactory.dialect}")
    private String dialect;
    @Value("${sessionFactory.dialectProperty}")
    private String dialectProperty;
    @Value("${sessionFactory.showSQL}")
    private String showSQL;
    @Value("${sessionFactory.showSQLProperty}")
    private String showSQLProperty;

    public String getPackagesToScan() {
        return packagesToScan;
    }

    public void setPackagesToScan(String packagesToScan) {
        this.packagesToScan = packagesToScan;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getDialectProperty() {
        return dialectProperty;
    }

    public void setDialectProperty(String dialectProperty) {
        this.dialectProperty = dialectProperty;
    }

    public String getShowSQL() {
        return showSQL;
    }

    public void setShowSQL(String showSQL) {
        this.showSQL = showSQL;
    }

    public String getShowSQLProperty() {
        return showSQLProperty;
    }

    public void setShowSQLProperty(String showSQLProperty) {
        this.showSQLProperty = showSQLProperty;
    }
}
