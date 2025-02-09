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
public class JSONLogAdapter implements ILogAdapter {

    @Override
    public void escreverMensagem(Log log) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String directoryPath = "src/temp/logJson";
        String filePath = directoryPath + "/log.json";

        String jsonMensagem = String.format(
            "   {\n" +
            "       \"nome_operacao\": \"%s\",\n" +
            "       \"nome\": \"%s\",\n" +
            "       \"data\": \"%s\",\n" +
            "       \"hora\": \"%s\",\n" +
            "       \"usuario\": \"%s\"\n" +
            "   }",
            log.getOperacao().toUpperCase(), log.getNome().toUpperCase(), 
            log.getData().format(dateFormatter), log.getData().format(timeFormatter), 
            log.getUsuario().toUpperCase()
        );

        try {
            Files.createDirectories(Paths.get(directoryPath));

            String conteudoAntigo = "";
            if (Files.exists(Paths.get(filePath))) {
                conteudoAntigo = new String(Files.readAllBytes(Paths.get(filePath))).trim();
                if (!conteudoAntigo.isEmpty() && conteudoAntigo.endsWith("]")) {
                    conteudoAntigo = conteudoAntigo.substring(0, conteudoAntigo.length() - 1) + ",\n";
                } else {
                    conteudoAntigo = "[\n";
                }
            } else {
                conteudoAntigo = "[\n";
            }

            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(conteudoAntigo + jsonMensagem + "\n]");
            }

        } catch (IOException exception) {
            System.err.println("Erro ao registrar log: " + exception.getMessage());
        }
    }
}