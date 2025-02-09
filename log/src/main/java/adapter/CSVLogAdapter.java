/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import models.log;
import modules.log.interfaces.ILogAdapter;

/**
 *
 * @author Cauã
 */
public class CSVLogAdapter implements ILogAdapter {

    @Override
    public void escreverMensagem(log log) {
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String FILE_PATH = "src/temp/logCsv/log.csv";
        
        File dir = new File("src/temp/logCsv");
            if (!dir.exists()) {
                dir.mkdirs();
        }  
        

        String csvMensagem = String.format(
            "%s; %s; %s; %s; %s\n",
            log.getOperacao().toUpperCase(),
            log.getNome().toUpperCase(),
            log.getData().format(dateFormatter),
            log.getData().format(timeFormatter),
            log.getUsuario().toUpperCase()
        );

        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(csvMensagem);
        } catch (IOException exception) {
            System.err.println("Ocorreu uma falha " + exception.getMessage() + " ao realizar a " + log.getOperacao() + " do contato " + log.getNome() + 
                            (log.getData().format(dateFormatter) + ", " + log.getData().format(timeFormatter) + " e " + log.getUsuario()));
        }
    }
}

