/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meprogavançada;

/**
 *
 * @author jj
 */
public interface AdapterPagamentos {
    void Pagar(vetor<pessoa> contas,pessoa conta,double valor);
    void Trasnferência(vetor<pessoa> contas,pessoa conta1,pessoa conta2,double valor); 
    void DepositoBancario(vetor<pessoa> contas,pessoa conta,double valor);
}
