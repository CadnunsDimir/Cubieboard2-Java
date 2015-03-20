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
     * Contante que guarda String que será usada para gerar comando RunTime(no caso, Leitura de dados em um pino gpio).
     * Deve ser usada ao inserir parametros "direction", nos metodos dessa classe
     */
    public static final String INPUT = "in";
    /**
     * 
     * Contante que guarda String que será usada para gerar comando RunTime(no caso, Escrita de dados em um pino gpio).
     * Deve ser usada ao inserir parametros "direction", nos metodos dessa classe
     */
    public static final String OUTPUT = "out";
    
    /**
     * Importando a classe que contém o mapeamento de pinos
     */
    Pins pinos = new Pins();
    /**
     * Usado para importar Pinos GPio na CB2, utilizando numero de referencia no Cubian OS
     * 
     * @param pin numero de referencia do pino a ser importado(relacionado as portas físicas no .fex file)
     * @param direction INPUT ou OUTPUT
     * @return 'false' se a operação não foi concluida com sucesso; 'true' se o pino foi importado corretamente
     */
    public boolean importPin(int pin, String direction){
        int index = 0;
        boolean isFound = false;
        while(index < pinos.pinsUSB.length && !isFound){
            System.out.println("pino "+pinos.pinsUSB[index][0]);
            if(String.valueOf(pin).equals(pinos.pinsUSB[index][0]))
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
    /**
     * Função não implementada
     * 
     * @param fisicalPin posição física do pino na CB2
     * @param direction idem ao Método importPin()
     * @return 'false'
     */
    public boolean importPinByFisical(int fisicalPin, String direction){
        
        System.out.println("NOT IMPLEMENTED");
        return false;
    }
    
    

    
}
