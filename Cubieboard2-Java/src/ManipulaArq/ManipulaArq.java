/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManipulaArq;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Tiagop
 */
public class ManipulaArq {
    
    public void escreve(String texto, String caminhoArquivo) throws IOException{
        //caminho do arquivo
        File arquivo = new File(caminhoArquivo);
        //verificação do arquivo
        boolean exiteFile = arquivo.exists();
        ////cria um arquivo (vazio)
        //arquivo.createNewFile(); 
        ////cria um diretório
        //arquivo.mkdir();
        ////caso seja um diretório, é possível listar seus arquivos e diretórios
        //File [] arquivos = arquivo.listFiles();
        ////exclui o arquivo ou diretório
        //arquivo.delete();
        
        //usado para escrever diretamente no arquivo
        FileWriter fw = new FileWriter(arquivo);
        //FileWriter fw = new FileWriter( arquivo, true );
        fw.write(texto);
        fw.close();
        
    }
    
}
