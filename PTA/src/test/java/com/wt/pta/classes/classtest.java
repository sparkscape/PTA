package com.wt.pta.classes;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class classtest {

    start start = new start();
    history history = new history();
    element element = new element("ptatest","C:/Users/beqam/Desktop/java/ptatest");
    dconfig dconfig= new dconfig();

    public classtest() throws IOException {
    }

    @BeforeAll
    void starttest(){
        try {
            start.getu("C:/Users/beqam/Desktop/java/ptatest");
        } catch (IOException e) {
            log.error("starttest error",e);
        }
    }

    @Test
    void historytest(){
        assertEquals (element,history.getelements());
    }

    @Test
    void dbconfigtest(){
        assertEquals("jdbc:h2:file:~/Desktop/java/PTA/DB",dconfig.getJdbu());
        assertEquals("sa",dconfig.getDu());
        assertEquals("",dconfig.getDp());
    }
}
