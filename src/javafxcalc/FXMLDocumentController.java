/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxcalc;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author p231078t
 */
public class FXMLDocumentController implements Initializable {
    
    Calculator cal = new Calculator();
    
    @FXML
    private TextField accumlater;
    
    @FXML
    private void keyAction(ActionEvent event) {
        Button b = (Button)event.getSource();
        
        GetSetText gst = new GetSetText();
        
        gst.checkOpe(accumlater, cal);
        gst.getText1(accumlater);
        gst.setText1(accumlater, b, cal);
        gst.checkPoint(cal, b);
    }
    
    @FXML
    private void addAction(ActionEvent event) {

        Button b = (Button)event.getSource();
        try{
        cal.calc(accumlater);
        cal.setAfterCalc(accumlater, b);
        }catch(ArithmeticException e){
            cal.clear(accumlater);
            accumlater.setText("エラー");
        }
    }
    
    @FXML
    private void subAction(ActionEvent event) {

        Button b = (Button)event.getSource();
        try{
        cal.calc(accumlater);
        cal.setAfterCalc(accumlater, b);
        }catch(ArithmeticException e){
            cal.clear(accumlater);
            accumlater.setText("エラー");
        }
    }
    
    @FXML
    private void mulAction(ActionEvent event) {

        Button b = (Button)event.getSource();
        try{
        cal.calc2(accumlater);
        cal.setAfterCalc2(accumlater, b);
        }catch(ArithmeticException e){
            cal.clear(accumlater);
            accumlater.setText("エラー");
        }
    }
    
    @FXML
    private void devAction(ActionEvent event) {
        
        Button b = (Button)event.getSource();
        try{
        cal.calc2(accumlater);
        cal.setAfterCalc2(accumlater, b);
        }catch(ArithmeticException e){
            cal.clear(accumlater);
            accumlater.setText("エラー");
        }
    }
    
    @FXML
    private void eqAction(ActionEvent event) {
        try{
        cal.eqCalc(accumlater);
        }catch(ArithmeticException e){
            cal.clear(accumlater);
            accumlater.setText("エラー");
        }
    }
    
    @FXML
    private void sqrtAction(ActionEvent event){
        double data = Double.parseDouble(accumlater.getText());
        accumlater.setText(""+Math.sqrt(data));
    }
    
    @FXML
    private void logAction(ActionEvent event){
        double data = Double.parseDouble(accumlater.getText());  
        accumlater.setText(""+Math.log(data)); 
    }
    
    @FXML
    private void sinAction(ActionEvent event){
        double data = Double.parseDouble(accumlater.getText());
        accumlater.setText(""+Math.sin(data)); 
    }
    
    @FXML
    private void cosAction(ActionEvent event){
        double data = Double.parseDouble(accumlater.getText());
        accumlater.setText(""+Math.cos(data)); 
    }
    
    @FXML
    private void tanAction(ActionEvent event){
        double data = Double.parseDouble(accumlater.getText());
        accumlater.setText(""+Math.tan(data));
    }

    @FXML
    private void piAction(ActionEvent event){
        accumlater.setText(""+Math.PI);
    }
    
    @FXML
    private void eAction(ActionEvent event){
        accumlater.setText(""+Math.E);
    } 
    
    @FXML
    private void clearAction(ActionEvent event) {

        cal.clear(accumlater);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
