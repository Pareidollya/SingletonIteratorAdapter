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
public class AdapterBoleto implements AdapterPagamentos{
    PBoleto boleto = new PBoleto();
    
    @Override
    public void Pagar(vetor<pessoa> contas,pessoa conta,double valor){
        boleto.PagarBanco(contas, conta, valor);
        System.out.print(valor);
    }
    
    @Override
    public void Trasnferência(vetor<pessoa> contas,pessoa conta1,pessoa conta2,double valor){
        boleto.Transferir(contas, conta1, conta2, valor);
    }
    
    @Override
    public void DepositoBancario(vetor<pessoa> contas,pessoa conta,double valor){
        boleto.Depositar(contas, conta, valor);
    }
}
