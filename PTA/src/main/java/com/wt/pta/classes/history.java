package com.wt.pta.classes;

import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class history {

    private static final String SELECT_ALL = "SELECT * FROM HISTORY;";


    public List<element> getelements(){
        try (
            Statement statement = datab.getconn().createStatement();
            ResultSet resultSet= statement.executeQuery(SELECT_ALL);
        ){
            List<element> elements = new ArrayList<>();
            while (resultSet.next()){
                String name = resultSet.getString("NAME");
                String url = resultSet.getString("URL");
                elements.add(new element(name,url));
            }
            log.info("got info from the database");
            return elements;
        } catch (SQLException throwables) {
            log.error("can not get info from the database");
            return null;
        }
    }
}
