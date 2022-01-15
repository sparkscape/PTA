package com.wt.pta.classes;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

@Slf4j
public class datab {
    private static  datab INSTANCE;

    private DataSource dataSource;

    private datab(){
        dconfig conf = null;
        try {
            conf = dconfig.getInstance();
        } catch (IOException e) {
            log.error("can not connect to database");
        }
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(conf.getJdbu());
        dataSource.setUser(conf.getDu());
        dataSource.setPassword(conf.getDp());
        this.dataSource=dataSource;
    }
    public static synchronized datab getInstance(){
        if (INSTANCE == null){
            INSTANCE=new datab();
        }
        return INSTANCE;
    }
    @SneakyThrows
    public static Connection getconn(){return getInstance().dataSource.getConnection();}
}
