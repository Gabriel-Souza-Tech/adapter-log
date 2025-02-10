/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package main;
import adapter.CSVLogAdapter;
import adapter.JSONLogAdapter;
import interfaces.ILogAdapter;
import model.log;

/**
 *
 * @author Cauã
 */

public class Main {
    public static void main(String[] args) {
            ILogAdapter jsonLog = new JSONLogAdapter();
            ILogAdapter csvLog = new CSVLogAdapter();
            
            Exception excessaoTeste = new NullPointerException();

            log logSucesso = new log("Info", "Insercao", "classe referida insercao", "usuario");
            log logErro = new log("Warning", "Insercao", "classe referida insercao", "usuario");

            jsonLog.escreverMensagemLogCorreto(logSucesso);
            csvLog.escreverMensagemLogCorreto(logSucesso);
            
            jsonLog.escreverMensagemLogErro(logErro, excessaoTeste);
            csvLog.escreverMensagemLogErro(logErro, excessaoTeste);
    }
}