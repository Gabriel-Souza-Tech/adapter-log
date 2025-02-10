/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package adapter;

import interfaces.ILogAdapter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import model.log;

/**
 *
 * @author Cauã
 */

public class JSONLogAdapter implements ILogAdapter {
    
    private static final String FILE_PATH = "src/temp/logJson/log.json";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void escreverMensagemLogCorreto(log log) {
        File dir = new File("src/temp/logJson");
        if (!dir.exists()) dir.mkdirs();

        String corretoMensagem = String.format(
            "   {\n" +
            "       \"nome_operacao\": \"%s\",\n" +
            "       \"nome\": \"%s\",\n" +
            "       \"data\": \"%s\",\n" +
            "       \"hora\": \"%s\",\n" +
            "       \"usuario\": \"%s\"\n" +
            "   }",
             log.getOperacao().toUpperCase(),
             log.getNome().toUpperCase(),
             log.getData().format(DATE_FORMATTER),
             log.getData().format(TIME_FORMATTER),
             log.getUsuario().toUpperCase()
        );

        escreverLog(FILE_PATH, corretoMensagem);
    }

    @Override
    public void escreverMensagemLogErro(log log, Exception e) {
        File dir = new File("src/temp/logJson");
        if (!dir.exists()) dir.mkdirs();
        
        String erroMensagem = String.format(
            "   {\n" +
            "       \"erro\": \"Ocorreu a falha: %s\",\n" +
            "       \"ao realizar a operacao\": \"%s\",\n" +
            "       \"data\": \"%s\",\n" +
            "       \"hora\": \"%s\",\n" +
            "       \"usuario\": \"%s\"\n" +
            "   }",
            e.getMessage(),    
            log.getOperacao().toUpperCase(),
            log.getData().format(DATE_FORMATTER),
            log.getData().format(TIME_FORMATTER),
            log.getUsuario().toUpperCase()
        );

        escreverLog(FILE_PATH, erroMensagem);
    }

    private void escreverLog(String filePath, String logMensagem) {
        try {
            File file = new File(filePath);
            StringBuilder content = new StringBuilder();

            if (file.exists() && file.length() > 0) {
                String existingContent = new String(Files.readAllBytes(Paths.get(filePath))).trim();
                if (existingContent.endsWith("]")) existingContent = existingContent.substring(0, existingContent.length() - 1).trim();
                content.append(existingContent);
                if (existingContent.length() > 1) content.append(",\n");
            } else {
                content.append("[\n");
            }

            content.append(logMensagem);
            content.append("\n]");

            try (FileWriter writer = new FileWriter(file, false)) {
                writer.write(content.toString());
            }

        } catch (IOException exception) {
            System.err.println("Ocorreu uma falha " + exception.getMessage());
        }
    }
}