/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Cauã
 */
public class Log {
    private final String operacao;
    private final String classeOrigem;
    private final String usuario;
    private final LocalDateTime data;
    
    public Log (String operacao, String nome, String usuario){
        this.operacao = operacao;
        this.classeOrigem = nome;
        this.usuario = usuario;
        this.data = LocalDateTime.now();
    }

    public String getOperacao() {
        return operacao;
    }

    public String getNome() {
        return classeOrigem;
    }

    public String getUsuario() {
        return usuario;
    }

    public LocalDateTime getData() {
        return data;
    }
    
}
