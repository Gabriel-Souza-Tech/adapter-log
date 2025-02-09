/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import model.Log;
import interfaces.ILogAdapter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Cauã
 */

public class CSVLogAdapter implements ILogAdapter {

    @Override
    public void escreverMensagem(Log log) {
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String directoryPath = "src/temp/logCsv";
        String filePath = directoryPath + "/log.csv";

        String csvMensagem = String.format(
            "%s; %s; %s; %s; %s\n",
            log.getOperacao().toUpperCase(),
            log.getNome().toUpperCase(),
            log.getData().format(dateFormatter),
            log.getData().format(timeFormatter),
            log.getUsuario().toUpperCase()
        );

        try {
            Files.createDirectories(Paths.get(directoryPath));

            try (FileWriter writer = new FileWriter(filePath, true)) {
                writer.write(csvMensagem);
            }

        } catch (IOException exception) {
            System.err.println("Ocorreu uma falha " + exception.getMessage() + "ao realizar a " + log.getOperacao() + "do contato" + log.getNome() + (log.getData().format(dateFormatter) + ", " + log.getData().format(timeFormatter) + "e " + log.getUsuario()));
        }
    }
}

