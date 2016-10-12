/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.Client;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author admin
 */
public class User {

    private StringProperty name;
    private StringProperty username;
    private StringProperty mod1;
    private StringProperty mod2;
    private StringProperty mod3;
    private StringProperty mod4;
    private StringProperty mod5;
    private StringProperty mod6;
    private StringProperty mod7;
    private StringProperty mod8;
    private StringProperty mod9;
    private StringProperty mod10;
    private StringProperty mod11;
    private StringProperty mod12;
    private StringProperty mod13;
    private StringProperty mod14;

    //Default constructor
    public User(String name, String mod1, String mod2, String mod3, String mod4, String mod5, String mod6, String mod7, String mod8, String mod9, String mod10, String mod11, String mod12, String mod13, String mod14) {
        this.name = new SimpleStringProperty(name);
        this.mod1 = new SimpleStringProperty(mod1);
        this.mod2 = new SimpleStringProperty(mod2);
        this.mod3 = new SimpleStringProperty(mod3);
        this.mod4 = new SimpleStringProperty(mod4);
        this.mod5 = new SimpleStringProperty(mod5);
        this.mod6 = new SimpleStringProperty(mod6);
        this.mod7 = new SimpleStringProperty(mod7);
        this.mod8 = new SimpleStringProperty(mod8);
        this.mod9 = new SimpleStringProperty(mod9);
        this.mod10 = new SimpleStringProperty(mod10);
        this.mod11 = new SimpleStringProperty(mod11);
        this.mod12 = new SimpleStringProperty(mod12);
        this.mod13 = new SimpleStringProperty(mod13);
        this.mod14 = new SimpleStringProperty(mod14);
    }
    
    public User(String username) {
        this.username = new SimpleStringProperty(username);
    }

    //Getters
    public String getName() {
        return name.get();
    }
    
    public String getUsername() {
        return username.get();
    }

    public String getMod1() {
        return mod1.get();
    }

    public String getMod2() {
        return mod2.get();
    }

    public String getMod3() {
        return mod3.get();
    }

    public String getMod4() {
        return mod4.get();
    }

    public String getMod5() {
        return mod5.get();
    }

    public String getMod6() {
        return mod6.get();
    }

    public String getMod7() {
        return mod7.get();
    }

    public String getMod8() {
        return mod8.get();
    }

    public String getMod9() {
        return mod9.get();
    }

    public String getMod10() {
        return mod10.get();
    }

    public String getMod11() {
        return mod11.get();
    }

    public String getMod12() {
        return mod12.get();
    }

    public String getMod13() {
        return mod13.get();
    }

    public String getMod14() {
        return mod14.get();
    }

    //Setters
    public void setName(String value) {
        name.set(value);
    }

    public void setMod1(String value) {
        mod1.set(value);
    }

    public void setMod2(String value) {
        mod2.set(value);
    }

    public void setMod3(String value) {
        mod3.set(value);
    }

    public void setMod4(String value) {
        mod4.set(value);
    }

    public void setMod5(String value) {
        mod5.set(value);
    }

    public void setMod6(String value) {
        mod6.set(value);
    }

    public void setMod7(String value) {
        mod7.set(value);
    }

    public void setMod8(String value) {
        mod8.set(value);
    }

    public void setMod9(String value) {
        mod9.set(value);
    }

    public void setMod10(String value) {
        mod10.set(value);
    }

    public void setMod11(String value) {
        mod11.set(value);
    }

    public void setMod12(String value) {
        mod12.set(value);
    }

    public void setMod13(String value) {
        mod13.set(value);
    }

    public void setMod14(String value) {
        mod14.set(value);
    }
    
    //Property values
    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty mod1Property() {
        return mod1;
    }

    public StringProperty mod2Property() {
        return mod2;
    }

    public StringProperty mod3Property() {
        return mod3;
    }

    public StringProperty mod4Property() {
        return mod4;
    }

    public StringProperty mod5Property() {
        return mod5;
    }

    public StringProperty mod6Property() {
        return mod6;
    }

    public StringProperty mod7Property() {
        return mod7;
    }

    public StringProperty mod8Property() {
        return mod8;
    }

    public StringProperty mod9Property() {
        return mod9;
    }

    public StringProperty mod10Property() {
        return mod10;
    }

    public StringProperty mod11Property() {
        return mod11;
    }

    public StringProperty mod12Property() {
        return mod12;
    }

    public StringProperty mod13Property() {
        return mod13;
    }

    public StringProperty mod14Property() {
        return mod14;
    }
}