package com.wt.pta;

import com.wt.pta.classes.element;
import com.wt.pta.classes.history;
import com.wt.pta.classes.start;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class WtController {
    @FXML
    private Label Wt;
    @FXML
    private TextField tf;

    start a = new start();


    @FXML
    private TableView tableView = new TableView();
    @FXML
    private TableColumn column1;
    @FXML
    private TableColumn column2;

    public void getdata(){
        history history = new history();
        ObservableList<element> data = FXCollections.observableArrayList(history.getelements());
        column1.setCellValueFactory(new PropertyValueFactory<element,String>(data.get(0).nameproperty().getName()));
        column2.setCellValueFactory(new PropertyValueFactory<element,String>(data.get(0).urlproperty().getName()));
        tableView.setItems(data);
    }
    public void initialize(){
        getdata();
    }

    @FXML
    public void onstartclick(ActionEvent event) throws IOException {

        a.getu(tf.getText());

        Parent m = FXMLLoader.load(getClass().getResource("mains.fxml"));
        Scene ms = new Scene(m);
        Stage sc = (Stage)((Node)event.getSource()).getScene().getWindow();
        sc.setScene(ms);
        sc.show();
    }

}