package meprogavançada;

import javax.swing.JOptionPane;

/**
*atividade realzada sob contexto do exercicio 2 porem ao inves de impressora é um banco
de segurança 0 mesmokkkkkkkkkk mas funciona 👍 
* Iterator usado para manipulação dos dados em vetor;
* Singleton para acesso ao banco por cada pessoa individualmente;
* Adapter para métodos de pagamento.
* 
 */
public class main {

    public static void main(String[] args) {
        //todas as pessoas devem ser registradas no banco antes de realizar transferências
        //sempre que for realizar uma ação em um objeto pessoa esta deve solicitar o banco individualmente (1 acesso por pessoa).

        
        //criar pessoas
        pessoa p1 = new pessoa("p1",1,1000);
        pessoa p2 = new pessoa ("p2",123321,2000);
        pessoa p3 = new pessoa ("p3",423890,3000);
        pessoa p4 = new pessoa ("p4",823,4000);
        
        //cadastrar as pessoas ao banco solicitando acesso a ele (proximo acesso não deve haver registros) 
        Banco cadastro = Banco.SolicitarBanco(p1);
        Banco cadastro1 = Banco.SolicitarBanco(p2);
        Banco cadastro3 = Banco.SolicitarBanco(p3);
        Banco cadastro4 = Banco.SolicitarBanco(p4);
        
        
        
        System.out.println("===============\nTestes com método 'Boleto'");
        //testes pessoa1 boleto
        Banco caixa1 = Banco.SolicitarBanco(p1); //basta alterar o parametro de entrada "p1" e colocar outra pessoa trocar o acesso... 
        caixa1.Pagar("Boleto",100);
        caixa1.Depósitar("Boleto",200.0);
        caixa1.Transferência("Boleto",p2, 200);
        caixa1.Sacar(200);
        caixa1.Depósitar("Pix", 100);
        caixa1.Pagar("Débito", 50);
        caixa1.encerrar();
        
        //testes pessoa3 Débito
        System.out.println("===============\nTestes com método 'Débito'.");
        Banco caixa2 = Banco.SolicitarBanco(p3);
        caixa2.Sacar(10);
        caixa2.Pagar("Débito",1000);
        caixa2.Transferência("Débito", p2, 100);
        caixa2.Depósitar("Débito", 100);
        caixa2.encerrar();
        
        //testes pessoa2 Pix
        System.out.println("===============\nTestes com método 'Pix'.");
        Banco caixa3 = Banco.SolicitarBanco(p2);
        caixa3.Pagar("pix", 0);
        caixa3.Transferência("Pix", p3, 10);
        caixa3.Sacar(2000); //ta rico pai 
        caixa3.encerrar();
        
        pessoa p5 = new pessoa ("p5",823,4000);
        
        Banco caixa4 = Banco.SolicitarBanco(p5);
       
        System.out.println("===============\nContas registradas:\n"+caixa4.getContas().getElementos());
        caixa3.getContas().print();
            
        }
        
        
        
        
        
 }
    

