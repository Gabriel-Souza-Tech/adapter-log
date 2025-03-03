/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package adapter;

import interfaces.ILogAdapter;
import java.io.*;
import java.time.format.DateTimeFormatter;
import model.log;

/**
 *
 * @author Cauã
 */

public class CSVLogAdapter implements ILogAdapter {

    private static final String FILE_PATH = "src/temp/logCsv/log.csv";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void escreverMensagemLogCorreto(log log) {
        File dir = new File("src/temp/logCsv");
        if (!dir.exists()) dir.mkdirs();

        String corretoMensagem = String.format(
            "%s; %s; %s; %s; %s; %s\n",
             log.getTipoLog().toUpperCase(),
             log.getOperacao().toUpperCase(),
             log.getNome().toUpperCase(),
             log.getData().format(DATE_FORMAT),
             log.getData().format(TIME_FORMAT),
             log.getUsuario().toUpperCase()
        );


        escreverLog(FILE_PATH, corretoMensagem);
    }

    @Override
    public void escreverMensagemLogErro(log log, Exception e) {
        File dir = new File("src/temp/logCsv");
        if (!dir.exists()) dir.mkdirs();
        
        String erroMensagem = String.format(
            "\"%s\"; Ocorreu a falha \"%s\" ao realizar a \"%s\"; do contato \"%s\"; %s; %s; %s\n",
            log.getTipoLog().toUpperCase(),
            e.getMessage(),
            log.getOperacao().toUpperCase(),
            log.getNome().toUpperCase(),
            log.getData().format(DATE_FORMAT),
            log.getData().format(TIME_FORMAT),
            log.getUsuario().toUpperCase()
        );

        escreverLog(FILE_PATH, erroMensagem);
    }

    private void escreverLog(String filePath, String logMensagem) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(logMensagem);
        } catch (IOException exception) {
            System.err.println("Ocorreu uma falha ao escrever no log: " + exception.getMessage());
        }
    }
}