module com.wt.pta {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.h2database;
    requires java.naming;
    requires lombok;
    requires slf4j.api;

    opens com.wt.pta to javafx.fxml;
    exports com.wt.pta;
}