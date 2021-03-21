package meprogavançada;

/**
 *
 * @author jj
 */
public class main {

    //pra usar semrpe deve possuir uma conta no banco 
    public static void main(String[] args) {
        pessoa p1 = new pessoa("p1",1293,1000);//cria pessoas 
        Banco banco = Banco.SolicitarBanco(p1); 
        
        pessoa p2 = new pessoa("p2",321,1000);
        Banco banco2 = Banco.SolicitarBanco(p2);
        
        System.out.println(banco);
        System.out.println(banco2); //verificar instancia em memoria 
       
        banco.PagarBoleto(p1);
        banco.PagarBoleto(p2);

        
        p1.getSaldo();
        p2.getSaldo();
        
        banco.TransferirBoleto(p1, p2, 200);
        System.out.println(p1.getSaldo());
        System.out.println(p2.getSaldo());
        
    }
    
}
