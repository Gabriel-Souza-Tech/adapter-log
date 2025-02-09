package adapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import models.log;
import modules.log.interfaces.ILogAdapter;

public class JSONLogAdapter implements ILogAdapter {

    @Override
    public void escreverMensagem(log log) {
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String FILE_PATH = "src/temp/logJson/log.json";
        
        File dir = new File("src/temp/logJson");
        if (!dir.exists()) dir.mkdirs();

        String jsonMensagem = String.format(
            "   {\n" +
            "       \"nome_operacao\": \"%s\",\n" +
            "       \"nome\": \"%s\",\n" +
            "       \"data\": \"%s\",\n" +
            "       \"hora\": \"%s\",\n" +
            "       \"usuario\": \"%s\"\n" +
            "   }",
             log.getOperacao().toUpperCase(),
             log.getNome().toUpperCase(),
             log.getData().format(dateFormatter),
             log.getData().format(timeFormatter),
             log.getUsuario().toUpperCase()
        );

        try {
            File file = new File(FILE_PATH);
            StringBuilder content = new StringBuilder();

            if (file.exists() && file.length() > 0) {
                String existingContent = new String(Files.readAllBytes(Paths.get(FILE_PATH))).trim();
                if (existingContent.endsWith("]")) existingContent = existingContent.substring(0, existingContent.length() - 1).trim();
                content.append(existingContent);
                if (existingContent.length() > 1) content.append(",\n");
            } else {
                content.append("[\n");
            }

            content.append(jsonMensagem);
            content.append("\n]");

            try (FileWriter writer = new FileWriter(file, false)) {
                writer.write(content.toString());
            }

        } catch (IOException exception) {
            System.err.println("Ocorreu uma falha " + exception.getMessage() + " ao realizar a " + log.getOperacao() + " do contato " + log.getNome() + 
                (log.getData().format(dateFormatter) + ", " + log.getData().format(timeFormatter) + " e " + log.getUsuario()));
        }
    }
}