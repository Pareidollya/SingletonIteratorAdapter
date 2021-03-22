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
public class PCartãoDébito {
    
     public void Depositar(vetor<pessoa> contas,pessoa conta,double valor){
        System.out.println("\nDeposito de R$ "+ valor+" Via Débito para self: " + contas.recupera(contas.encontrar(conta)).getNome());
        contas.recupera(contas.encontrar(conta)).setSaldo(conta.getSaldo()+valor);
        this.DadosAtuais(contas, conta);   
    }
    public void PagarBanco(vetor<pessoa> contas,pessoa conta, double valor){ //imagina que em conta seria ID
        contas.recupera(contas.encontrar(conta)).setSaldo(conta.getSaldo()-valor);
        System.out.println("\nPagamento via Débito de R$"+ valor + " realizado.");
        this.DadosAtuais(contas, conta);
    }
     public void Transferir(vetor<pessoa> contas,pessoa conta1,pessoa conta2,double valor){ //conta 1 transfere p conta 2 
        
        contas.recupera(contas.encontrar(conta1)).setSaldo(conta1.getSaldo()-valor);
        contas.recupera(contas.encontrar(conta2)).setSaldo(conta2.getSaldo()+valor);
        System.out.println("\nTransferência via Débito de: R$ "+valor +" "+contas.recupera(contas.encontrar(conta1)).getNome()+
                " para "+ contas.recupera(contas.encontrar(conta2)).getNome());
        this.DadosAtuais(contas, conta1);
        System.out.println("");
        this.DadosAtuais(contas, conta2);
    }
    
    private void DadosAtuais(vetor<pessoa> contas,pessoa conta){
        System.out.println(contas.recupera(contas.encontrar(conta)).getNome()+" dados atuais, Id: "+
                contas.recupera(contas.encontrar(conta)).getId()+", Saldo: R$ "+ contas.recupera(contas.encontrar(conta)).getSaldo()+"\n");
    }
}
