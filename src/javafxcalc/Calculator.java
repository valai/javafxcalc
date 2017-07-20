/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxcalc;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_UP;

/**
 *
 * @author valai
 */
public class Calculator {
    BigDecimal data;
    public BigDecimal register, register2;
    public char op, op2, oppm;
    public boolean a, point, ope;
    
    Calculator(){
        data = ZERO;
        register = ZERO;
        register2 = ZERO;
        op = 'n';
        op2 = 'n';
        oppm = 'n';
        a = true;
        point = false;
        ope = false;
        
    }
    
    void calc(TextField accumlater){
        a = true;
        BigDecimal bd = new BigDecimal(accumlater.getText());
        if (register == ZERO)
            data = bd;
        else if (op == '-')
            data = register.subtract(bd);
        else if (op == '*')
            data = bd.multiply(register);
        else if (op == '/'){
            data = register.divide(bd, 10, HALF_UP);
            data = data.stripTrailingZeros();
        }else
            data = bd.add(register);

    }
    
    void calc2(TextField accumlater){
        BigDecimal bd = new BigDecimal(accumlater.getText());
        if (register == ZERO)
            data = bd;
        else if (op == '+'){
            register2 = bd;
            a = false;
        }else if (op == '-'){
            register2 = bd;
            a = false;
        }else if (op == '/'){
            a = true;
            if(register2 == ZERO){
                data = register.divide(bd, 10, HALF_UP);
                data = data.stripTrailingZeros();
            }else{
                register2 = register2.divide(bd, 10, HALF_UP);
                register2 = register2.stripTrailingZeros();
            }
        }else{
            a = true;
            if(register2 == ZERO)
                data = bd.multiply(register);
            else{
                a = false;
                register2 = bd.multiply(register2);
                accumlater.setText(""+register2);
            }
        }

    } 
    
    void eqCalc(TextField accumlater){
        BigDecimal bd = new BigDecimal(accumlater.getText());
        switch (op){
            case '+':
                data = bd.add(register);
                break;
            case '-':
                data = register.subtract(bd);
                break;
            case '*':
                if(a)
                    data = bd.multiply(register);
                else{
                    data = bd.multiply(register2);
                        if(oppm == '+')
                            data = data.add(register);
                        if(oppm == '-')
                            data = register.subtract(data);
                }
                break;
            case '/':
                if(a){
                    data = register.divide(bd, 10, HALF_UP);
                }else{
                    data = register2.divide(bd, 10, HALF_UP);
                        if(oppm == '+')
                            data = data.add(register);
                        if(oppm == '-')
                            data = register.subtract(data);
                }
                break;
            default:
                break;
        }
        data = data.stripTrailingZeros();
        accumlater.setText(""+data.toPlainString());
        register = ZERO;
        op = 'n';
        a = true;
        register2 = ZERO;
        op2 = 'n';
        oppm = 'n';
        ope = true;
        point = false;

    }
    
    void setAfterCalc(TextField accumlater, Button b){
        
        accumlater.setText(""+data.toPlainString());
        register = data;
        ope = true;
        point = false;
        
        if(b.getText().equals("+")){
            op = '+';
            oppm = '+';
        }if(b.getText().equals("-")){
            op = '-';
            oppm = '-';
        }
    }
    
    void setAfterCalc2(TextField accumlater, Button b){
        if(a){
            accumlater.setText(""+data.toPlainString());
            register = data;
        }
        
        op2 = op;
        ope = true;
        point = false;
        
        if(b.getText().equals("×"))
            op = '*';
        if(b.getText().equals("÷"))
            op = '/';
    }
    
    void clear(TextField accumlater){
        register = ZERO;
        accumlater.setText("0");
        op = 'n';
        ope = false;
        a = true;
        register2 = ZERO;
        op2 = 'n';
        oppm = 'n';
        point = false;
    }
    
    void setFalse(){
        ope = false;
    }
    
    void setTrue(){
        point = true;
    }
}
