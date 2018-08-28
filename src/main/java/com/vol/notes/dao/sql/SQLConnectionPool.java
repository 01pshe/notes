package com.vol.notes.dao.sql;

import org.springframework.stereotype.Service;

@Service
public class SQLConnectionPool {

    private String jdbcDriver;
    private String jdbcURL;

    private String jdbcLogin;
    private String jdbcPassword;
}
