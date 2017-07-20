/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxcalc;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author valai
 */
public class GetSetText {
    
    String data;
    
    void getText1(TextField acu){
        data = acu.getText();
    }
    
    void setText1(TextField accumlater, Button b, Calculator cal){
        if (data.equals("0") || data.equals("エラー")){
            if(b.getText().equals("."))
                accumlater.setText("0.");
            else if(b.getText().equals("0"));
            else
                accumlater.setText(b.getText());
        }else
            if(cal.point == false || !b.getText().equals("."))
                accumlater.setText(data + b.getText());
    }
    
    void checkOpe(TextField acu, Calculator cal){
        if (cal.ope == true) {
            acu.setText("0");
            cal.setFalse();
        }
    }
    
    void checkPoint(Calculator cal, Button b){
        if(b.getText().equals("."))
            cal.point = true;
    }
}
