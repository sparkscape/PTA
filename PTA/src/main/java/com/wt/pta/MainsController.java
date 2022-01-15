package com.wt.pta;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lombok.SneakyThrows;

import java.io.*;
import java.util.Properties;


public class MainsController  {

    @FXML
    private Label mainapp;

    @FXML
    ListView<String> list = new ListView();


    @SneakyThrows
    @FXML
    private void ret(ActionEvent event){
        Parent m = FXMLLoader.load(getClass().getResource("Wt-view.fxml"));
        Scene ms = new Scene(m);
        Stage sc = (Stage)((Node)event.getSource()).getScene().getWindow();
        sc.setScene(ms);
        sc.show();
    }


    @FXML
    ImageView imag = new ImageView();

    @FXML
    TextArea ta = new TextArea();


    public MainsController()  {
    }

    public void initialize() throws IOException {


        Properties loc = new Properties();
        try (InputStream inp = MainsController.class.getResourceAsStream("/loc.properties")){
            loc.load(inp);
        }

        File inp3 = new File(loc.getProperty("location"));
        File[] listf = inp3.listFiles();

        FileInputStream inp2 = new FileInputStream(loc.getProperty("location")+"/43-432403_4k-future-cyberpunk-city.jpg");
        Image i1 = new Image(inp2);

        FileInputStream inp1 = new FileInputStream(loc.getProperty("location")+"/text1.txt");

        for (int i=0;i<listf.length;i++){
            list.getItems().add(listf[i].getName());
        }
        imag.setImage(i1);
        BufferedReader bf = new BufferedReader(new InputStreamReader(inp1));
        String str= "";
        while ( (str = bf.readLine()) != null){
                ta.appendText(str+"\n");
            }
    }

    @FXML
    public void opene() throws IOException {
        Properties loc = new Properties();
        try (InputStream inp = MainsController.class.getResourceAsStream("/loc.properties")){
            loc.load(inp);
        }
        File inp3 = new File(loc.getProperty("location"));
        if(String.valueOf(list.getSelectionModel().getSelectedItems()).endsWith(".txt]")) {
            ta.clear();
            FileInputStream tempinp = new FileInputStream(inp3+"/"+String.valueOf(list.getSelectionModel().getSelectedItems()).substring(1,String.valueOf(list.getSelectionModel().getSelectedItems()).length()-1));
            String str = "";
            BufferedReader buf = new BufferedReader(new InputStreamReader(tempinp));
            if (inp3 != null) {
                while ((str = buf.readLine()) != null) {
                    ta.appendText(str + "\n");
                }
            }
        }
        if (String.valueOf(list.getSelectionModel().getSelectedItems()).endsWith(".png]") || String.valueOf(list.getSelectionModel().getSelectedItems()).endsWith(".jpg]")){
            FileInputStream tempim = new FileInputStream(inp3+"/"+String.valueOf(list.getSelectionModel().getSelectedItems()).substring(1,String.valueOf(list.getSelectionModel().getSelectedItems()).length()-1));
           Image ima = new Image(tempim);
            imag.setImage(ima);
          }
        }
}
