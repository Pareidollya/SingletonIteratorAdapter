package meprogavançada;

/**
*atividade realzada sob contexto do exercicio 2 porem ao inves de impressora é um banco
de segurança 0 mesmokkkkkkkkkk mas funciona 👍 
 */
public class main {

    public static void main(String[] args) {
        //todas as pessoas devem ser registradas no banco antes de realizar transferências
        //sempre que for realizar uma ação esta deve 
        
        //para cada uso deve-se instanciar um "caixa" que puxa o banco (faltou abstraçãokk)
        
        //cria pessoas
        pessoa p1 = new pessoa("p1",1293,1000);
        pessoa p2 = new pessoa ("p2",123321,2000);
        pessoa p3 = new pessoa ("p3",423890,3000);
        pessoa p4 = new pessoa ("p4",823,4000);
        
        //cadastra as pessoa 
        Banco cadastro = Banco.SolicitarBanco(p1);
        Banco cadastro1 = Banco.SolicitarBanco(p2);
        Banco cadastro3 = Banco.SolicitarBanco(p3);
        Banco cadastro4 = Banco.SolicitarBanco(p4);
        
        //pessoa 1 quer usar o banco
        Banco caixa1 = Banco.SolicitarBanco(p1);
        caixa1.Pagar("Boleto",100);
        caixa1.Depósitar("Boleto",200.0);
        caixa1.Transferência("Pix",p2, 900);
        caixa1.Sacar(200);
        
        //Banco caixa2 = Banco.SolicitarBanco(p2);
        //caixa2.Depósitar("Boleto",0);
        
        pessoa p5 = new pessoa ("p5",823,4000);
        Banco caixa3 = Banco.SolicitarBanco(p5);
        
        
        
        
        System.out.println("\nContas registradas:\n"+caixa3.getContas().getElementos());
        caixa3.getContas().print();
        
    }
    
}
