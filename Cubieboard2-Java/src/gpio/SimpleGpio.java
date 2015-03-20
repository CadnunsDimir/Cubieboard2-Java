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
    
    Pins pinos = new Pins();
    
    public boolean importPin(int pin, String direction){
        int index = 0;
        boolean isFound = false;
        while(index < pinos.pinsHDMI.length && !isFound){
            System.out.println("pino "+pinos.pinsHDMI[index][0]);
            if(String.valueOf(pin).equals(pinos.pinsHDMI[index][0]))
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
