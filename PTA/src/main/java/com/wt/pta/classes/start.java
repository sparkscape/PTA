package com.wt.pta.classes;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@Slf4j
public class start {

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS HISTORY (ID INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR NOT NULL, URL VARCHAR NOT NULL);";
    private static final String INSERT = "INSERT INTO HISTORY(NAME, URL) ";


    public void getu(String a) throws IOException {
        Properties loc = new Properties();
        try (InputStream inp = start.class.getResourceAsStream("/loc.properties")){
            loc.load(inp);
        }
        catch (Exception e){
            log.error("could not ger resource",e);
        }
        log.info("got resource");
        loc.setProperty("location",a);
        String b = a.substring(a.lastIndexOf("/")+1);
        try (
                Statement statement = datab.getconn().createStatement();

        ){
            statement.execute(CREATE_TABLE);
            statement.execute(INSERT+"VALUES("+"'"+b+"'"+", "+"'"+a+"'"+")");
        } catch (SQLException throwables) {
            log.error("could not run sql command");
        }
    }
}
