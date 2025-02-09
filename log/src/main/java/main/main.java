/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.log;

import models.log;
import modules.log.adapter.CSVLog;
import modules.log.adapter.JSONLog;

/**
 *
 * @author Gabriel
 */
public class main {

    public static void main(String[] args) {
        log log = new log("Insercao", "classe referida insercao", "Mikalateia");
        
        JSONLog jsonLog = new JSONLog();
        CSVLog csvLog = new CSVLog();
        
        csvLog.escreverMensagem(log);
        jsonLog.escreverMensagem(log);

    }
}
