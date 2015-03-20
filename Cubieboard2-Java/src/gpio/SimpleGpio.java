/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpio;

/**
 *
 * @author Tiagop
 */
public class SimpleGpio {
    /**
     * 
     * array contendo informaçoes sobre os pinos
     */
    public static final String INPUT = "in";
    public static final String OUTPUT = "out";
    
    String pinsHDMI[][]= {
        {null,"VCC-5V"},
        {"11","ph15"},
        {null,"CSI1"},
        {"10","ph15"},
        {"9" ,"pb19"},
        {"9" ,"pb19"},
    };
    
    public boolean importPin(int pin, String direction){
        int index = 0;
        boolean isFound = false;
        while(index < pinsHDMI.length && !isFound){
            System.out.println("pino "+pinsHDMI[index][0]);
            if(String.valueOf(pin).equals(pinsHDMI[index][0]))
                isFound = true;
            else
                ++index;
        }
        
        
        if(isFound){            
            return true;
        }
        else
        return false;
    }
    
    

    
}
