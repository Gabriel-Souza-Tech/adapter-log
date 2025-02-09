/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules.log.adapter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import models.log;
import modules.log.interfaces.ILogAdapter;

/**
 *
 * @author Cauã
 */
public class JSONLog implements ILogAdapter{

    @Override
    public void escreverMensagem(log log) {
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String jsonMensagem = String.format(
            "   \"nome_operacao\": \"%s\",\n" +
            "   \"nome\": \"%s\",\n" +      
            "   \"data\": \"%s\",\n" +
            "   \"hora\": \"%s\",\n" +
            "   \"usuario\": \"%s\"\n",
             log.getOperacao().toUpperCase(), log.getNome().toUpperCase(), log.getData().format(dateFormatter), log.getData().format(timeFormatter), log.getUsuario().toUpperCase()
        );

        try (FileWriter writer = new FileWriter("src/temp/logJson/log.json", true)) {
            writer.write("{\n" + jsonMensagem + "}\n");
        } catch (IOException exception) {
            System.err.println("Ocorreu uma falha " + exception.getMessage() + "ao realizar a " + log.getOperacao() + "do contato" + log.getNome() + (log.getData().format(dateFormatter) + ", " + log.getData().format(timeFormatter) + "e " + log.getUsuario()));
        }
    }                 
}



