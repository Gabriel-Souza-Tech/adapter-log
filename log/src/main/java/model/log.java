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

public class log {
    private final String operacao;
    private final String nome;
    private final String usuario;
    private final LocalDateTime data;
    
    public log (String operacao, String nome, String usuario){
        this.operacao = operacao;
        this.nome = nome;
        this.usuario = usuario;
        this.data = LocalDateTime.now();
    }

    public String getOperacao() {
        return operacao;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public LocalDateTime getData() {
        return data;
    }
    
}
