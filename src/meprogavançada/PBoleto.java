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
public class PBoleto {
    public PBoleto(){
    }
    
    public void PagarBanco(vetor<pessoa> contas,pessoa conta, double valor){ //recebe vetor como parâmetro e valor a ser descontado no saldo 
        contas.recupera(contas.encontrar(conta)).setSaldo(conta.getSaldo()-valor);
        System.out.println(contas.recupera(contas.encontrar(conta)).getId() + "valor: " + valor + "pago, saldo atual "+ contas.recupera(contas.encontrar(conta)).getSaldo());
    }
    
    public void Transferir(vetor<pessoa> contas,pessoa conta1,pessoa conta2,double valor){ //conta 1 transfere p conta 2 
        
        contas.recupera(contas.encontrar(conta1)).setSaldo(conta1.getSaldo()-valor);
        contas.recupera(contas.encontrar(conta2)).setSaldo(conta2.getSaldo()+valor);
        System.out.println("Transferencia de: "+valor +" "+contas.recupera(contas.encontrar(conta1)).getId()+
                " para "+ contas.recupera(contas.encontrar(conta2)).getId());
    }
}
