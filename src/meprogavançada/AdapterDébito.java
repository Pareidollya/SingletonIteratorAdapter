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
    public class AdapterDébito implements AdapterPagamentos{
    PCartãoDébito CartãoDébito = new PCartãoDébito();
    
    @Override
    public void Pagar(vetor<pessoa> contas,pessoa conta,double valor){
        CartãoDébito.PagarBanco(contas, conta, valor);
    }
    
    @Override
    public void Trasnferência(vetor<pessoa> contas,pessoa conta1,pessoa conta2,double valor){
        CartãoDébito.Transferir(contas, conta1, conta2, 0);
    }
    
    @Override
    public void DepositoBancario(vetor<pessoa> contas,pessoa conta,double valor){
        CartãoDébito.Depositar(contas, conta, 0);
    }
}
    

