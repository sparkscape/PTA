package com.wt.pta.classes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class element {
    private StringProperty name = new SimpleStringProperty();
    private StringProperty url = new SimpleStringProperty();

    public element(String name,String url){
        setname(name);
        seturl(url);
    }

    public void setname(String name){nameproperty().set(name); }
    public void seturl(String url){urlproperty().set(url); }
    public String getname(){return name.get();}
    public String geturl(){return url.get();}

    public StringProperty nameproperty(){
        if (name == null){
            name = new SimpleStringProperty(this,"name");
        }
        return name;
    }
    public StringProperty urlproperty(){
        if (url == null){
            url = new SimpleStringProperty(this,"url");
        }
        return url;
    }
}
