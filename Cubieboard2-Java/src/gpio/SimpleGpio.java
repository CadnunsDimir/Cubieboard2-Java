/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpio;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Logger;

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
    public boolean importPin(int pin, String direction) throws IOException{
        int index = 0;
        boolean isFound = false;
        int port = 0;//se 1 pinsUSB, se 2 pinsSATA
        while(index < pinos.pinsUSB.length && !isFound){
            System.out.println("pino "+pinos.pinsUSB[index][0]);
            if(String.valueOf(pin).equals(pinos.pinsUSB[index][0])){
                isFound = true;
                port = 1;
            }
            else
                ++index;
        }
        
        if(!isFound)
            index = 0;
        
        while(index < pinos.pinsSATA.length && !isFound){
            System.out.println("pino "+pinos.pinsSATA[index][0]);
            if(String.valueOf(pin).equals(pinos.pinsSATA[index][0])){
                isFound = true;
                port = 2;
            }
            else
                ++index;
        }
        
        
        if(isFound){
            switch(port){
                case 1: 
                    importPinSh(pinos.pinsUSB[index][0]);
                    setDirectionSh(pinos.pinsUSB[index][0], pinos.pinsUSB[index][1], direction);
                    return true;
                case 2:                    
                    importPinSh(pinos.pinsSATA[index][0]);
                    setDirectionSh(pinos.pinsSATA[index][0], pinos.pinsSATA[index][1], direction);
                    return true;
                default:
                    System.out.println("Erro ao acessar o pino "+index+" do PORT "+port+" : "+pinos.port[port]);
                    return false;
            }            
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
    
    private void importPinSh(String pin) throws IOException{
        String comando = "echo "+pin+" > /sys/class/gpio/export";
        executeCommand(comando);
        
    }
    
    private void setDirectionSh(String pin, String pinName,String direction)throws IOException {
        String comando = "echo "+direction+" >  /sys/class/gpio/gpio"+pin+"_"+pinName+"/direction";
        executeCommand(comando);             
    }
    
    private static final Logger log = Logger.getLogger(SimpleGpio.class.getName());  
    public void executeCommand(final String command) throws IOException {
        final ArrayList<String> commands = new ArrayList<String>();
        commands.add("/bin/bash");
        commands.add("-c");
        commands.add(command);
        BufferedReader br = null;
        try {
            final ProcessBuilder p = new ProcessBuilder(commands);
            final Process process = p.start();
            final InputStream is = process.getInputStream();
            final InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Retorno do comando = [" + line + "]");
            }
        } catch (IOException ioe) {
            log.severe("Erro ao executar comando shell" + ioe.getMessage());
            throw ioe;
        } finally {
            secureClose(br);
        }
    }
    
    private void secureClose(final Closeable resource) {
        try {
            if (resource != null) {
                resource.close();
            }
        } catch (IOException ex) {
            log.severe("Erro = " + ex.getMessage());
        }
    }


    

}
