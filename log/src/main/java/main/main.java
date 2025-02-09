package main;
import adapter.CSVLogAdapter;
import adapter.JSONLogAdapter;
import models.log;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


/**
 *
 * @author Gabriel
 */
public class Main {

    public static void main(String[] args) {
        log log = new log("Insercao", "classe referida insercao", "usuario");
        
        JSONLogAdapter jsonLog = new JSONLogAdapter();
        CSVLogAdapter csvLog = new CSVLogAdapter();
        
        csvLog.escreverMensagem(log);
        jsonLog.escreverMensagem(log);

    }
}
