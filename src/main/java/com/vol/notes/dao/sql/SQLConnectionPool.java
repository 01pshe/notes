package com.vol.notes.dao.sql;

import org.springframework.stereotype.Service;

@Service
public class SQLConnectionPool {

    private String jdbcDriver;
    private String jdbcURL;

    private String jdbcLogin;
    private String jdbcPassword;

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcURL() {
        return jdbcURL;
    }

    public void setJdbcURL(String jdbcURL) {
        this.jdbcURL = jdbcURL;
    }

    public String getJdbcLogin() {
        return jdbcLogin;
    }

    public void setJdbcLogin(String jdbcLogin) {
        this.jdbcLogin = jdbcLogin;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }
}
