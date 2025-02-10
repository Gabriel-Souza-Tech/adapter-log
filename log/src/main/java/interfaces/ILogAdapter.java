/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package interfaces;

import model.log;

/**
 *
 * @author Cauã
 */

public interface ILogAdapter {
    void escreverMensagemLogCorreto(log log);
    void escreverMensagemLogErro(log log, Exception e);
}
