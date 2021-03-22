package meprogavançada;

/**
*atividade realzada sob contexto do exercicio 2 porem ao inves de impressora é um banco
de segurança 0 mesmokkkkkkkkkk mas funciona 👍 
 */
public class main {

    public static void main(String[] args) {
        //todas as pessoas devem ser registradas no banco antes de usar
        //sempre que for realizar uma ação esta deve 
        
        //para cada uso deve-se instanciar um "caixa" que puxa o banco (faltou abstraçãokk)
        //
        
        pessoa p1 = new pessoa("p1",1293,1000);
        
        Banco caixa1 = Banco.SolicitarBanco(p1); 
        caixa1.Sacar(p1, 100);
        
        pessoa p2 = new pessoa("p2",321,1000);
        Banco banco2 = Banco.SolicitarBanco(p2);
        Banco banco3 = Banco.SolicitarBanco(p1);
        
        System.out.println(caixa1);
        //System.out.println(banco2); //verificar instancia em memoria 
        
        caixa1.Sacar(p1, 100);
        //banco2.Sacar(p2, 100);

        System.out.println(p1.getSaldo());
        System.out.println(p2.getSaldo());
        
    }
    
}
