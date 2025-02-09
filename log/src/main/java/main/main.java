/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import model.Log;
import adapter.CSVLogAdapter;
import adapter.JSONLogAdapter;

/**
 *
 * @author Gabriel
 */
public class main {

    public static void main(String[] args) {
        Log log = new Log("Insercao", "classe referida insercao", "Usuario");
        
        JSONLogAdapter jsonLog = new JSONLogAdapter();
        CSVLogAdapter csvLog = new CSVLogAdapter();
        
        csvLog.escreverMensagem(log);
        jsonLog.escreverMensagem(log);

    }
}
