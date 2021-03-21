package meprogavançada;

/**
 *
 * @author jj
 */
public class main {

    //pra usar semrpe deve possuir uma conta no banco 
    public static void main(String[] args) {
        pessoa p1 = new pessoa("p1",1293,1000);//cria pessoas 
        pessoa p2 = new pessoa("p2",321,1000);
        vetor contas = new vetor(10);
        contas.adicionaInicio(p1);//cria vetor pra registra-las no banco
        contas.adicionaInicio(p2);
        
        Banco banco = Banco.SolicitarBanco(contas); //instancia banco com as contas 
        
        System.out.println(banco.getContas().getElementos());
        banco.PagarBoleto(p1);
        banco.PagarBoleto(p2);

        
        p1.getSaldo();
        p2.getSaldo();
        
        banco.TransferirBoleto(p1, p2, 200);
        System.out.println(p1.getSaldo());
        System.out.println(p2.getSaldo());
        
    }
    
}
