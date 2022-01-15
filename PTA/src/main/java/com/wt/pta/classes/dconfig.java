package com.wt.pta.classes;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import lombok.Getter;

public class dconfig {
    private static dconfig INSTANCE;
    @Getter
    private String jdbu;
    @Getter
    private String du;
    @Getter
    private String dp;

    public dconfig() throws IOException {
        Properties prop = new Properties();
        try (InputStream inps = dconfig.class.getResourceAsStream("/d.properties")){
            prop.load(inps);
        }
        jdbu=prop.getProperty("databaseurl");
        du=prop.getProperty("databaseusername");
        dp=prop.getProperty("databasepassword");
    }
    public static synchronized dconfig getInstance() throws IOException {
        if (INSTANCE == null){
            INSTANCE = new dconfig();
        }
        return INSTANCE;
    }
}
