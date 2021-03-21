/*
banco usa singleton pois pode ser solicitado de qualquer caixa em qq lugar mas o banco sempre deve ser o mesmo 
iterator é utilizado pra percorrer o vetor onde se armazena as CONTAS 
adapter para o pagamento é realizado atravez do caixa que solicita a forma de pagamento e desconta no saldo presente na conta do banco
 */
package meprogavançada;

/**
 *
 * @author jj
 */
public class Banco {
    private String nomeBanco, unidade;
    private vetor<pessoa> contas;
    private PBoleto pagamentoBoleto = new PBoleto();
    private pessoa conta; 
    
    private static Banco construtor = null;

    private Banco(String nomeBanco, String unidade,vetor<pessoa> contas) {
        this.nomeBanco = nomeBanco;
        this.unidade = unidade;
        this.contas = contas;
    }
    public static Banco SolicitarBanco(vetor<pessoa> contas){//construtor singleton (solicitar se tiver conta)
        if (construtor == null){
            construtor = new Banco("Banco","U01",contas);  
            System.out.println("Banco instanciado");
        }
        
        return construtor;
    }
    
    public void Cadastrar(pessoa conta){ //cadastrar a pessoa no banco ne 
        this.contas.adicionaInicio(conta);
        System.out.println(conta + " cadastrado" + this.contas.recupera(this.contas.encontrar(conta)));
    }
  
    public void PagarBoleto(pessoa conta){
        pagamentoBoleto.PagarBanco(this.contas, conta, 10);
    }
    public void TransferirBoleto(pessoa conta1,pessoa conta2,double valor){
        pagamentoBoleto.Transferir(this.contas, conta1, conta2, valor);
        
    }

    public vetor<pessoa> getContas() {
        return contas;
    }
    
    
}


