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
    private static vetor<pessoa> contas = new vetor(10);
    private PBoleto pagamentoBoleto = new PBoleto();
    private static pessoa user; 
    
    private static Banco construtor = null;

    private Banco(String nomeBanco, String unidade) {
        this.nomeBanco = nomeBanco;
        this.unidade = unidade;
    }
    
    public static Banco SolicitarBanco(pessoa conta){//construtor singleton (solicitar se tiver conta)
        if (construtor == null){
            construtor = new Banco("Banco","U01");  
            System.out.println("Banco instanciado");
            System.out.println("\nNovo acesso de "+ conta.getNome() +" Ainda não cadastrado, realizando novo cadastro..");
            user = conta;
            contas.adicionaInicio(conta);
        }
        else{
            if (contas.existeDado(contas.encontrar(conta))==false){
                System.out.println("\nNovo acesso de "+ conta.getNome() +"Ainda não cadastrado, realizando novo cadastro..");        
                contas.adicionaInicio(conta); //na segunda chamada registra o novo usuario no banco sem criar novas instancias
                user = conta;
            }
            else{
                System.out.println("\nAcesso de "+ conta.getNome() +" ja cadastrado");
                user = conta;
            }          
        }
        return construtor;
    }
    
    public void Sacar(pessoa conta,double valor){ 
        if (valor > conta.getSaldo()){
            System.out.println("Saldo insificiente!\nId: "+conta.getNome()+", "+conta.getId()+", Saldo: "+conta.getSaldo()+"\n");
        }
        else{
            System.out.println("\nSaque de: R$"+valor);
            contas.recupera(contas.encontrar(conta)).setSaldo(conta.getSaldo()-valor);
            System.out.println(contas.recupera(contas.encontrar(conta)).getNome()+", dados atuais, Id: "+
                contas.recupera(contas.encontrar(conta)).getId()+", Saldo: R$ "+ contas.recupera(contas.encontrar(conta)).getSaldo()+"\n");
        }      
    }
    
    public void Cadastrar(pessoa conta){ //cadastrar a pessoa no banco ne 
        this.contas.adicionaInicio(conta);
        System.out.println(conta.getNome() + " cadastrado" + this.contas.recupera(this.contas.encontrar(conta)));
    }
  
    public void Pagar(String TipoPagamento,pessoa conta,double valor){
        if (TipoPagamento == "Boleto"){
            AdapterPagamentos pagamento = new AdapterBoleto();
            pagamento.Pagar(this.contas, conta, valor);
        }
        else if(TipoPagamento == "Débito"){
            AdapterPagamentos pagamento = new AdapterDébito();
            pagamento.Pagar(this.contas, conta, valor);
        }
        else if(TipoPagamento == "Pix"){
            AdapterPagamentos pagamento = new AdapterPix();
            pagamento.Pagar(this.contas, conta, valor);
        }
    }
    
    public void Transferência(String TipoTrasnferência,pessoa conta,pessoa conta2, double valor){ //conta 2 = quem recebe
        if(TipoTrasnferência == "Boleto"){
            AdapterPagamentos trasnferencia = new AdapterBoleto();
            trasnferencia.Trasnferência(this.contas, conta, conta2, valor);     
        }
        else if(TipoTrasnferência == "Débito"){
            AdapterPagamentos trasnferencia = new AdapterDébito();
            trasnferencia.Trasnferência(this.contas, conta, conta2, valor);     
        }
        else if(TipoTrasnferência == "Pix"){
            AdapterPagamentos trasnferencia = new AdapterPix();
            trasnferencia.Trasnferência(this.contas, conta, conta2, valor);     
        }    
    }
    
    public void Depósitar(String TipoDepósito,pessoa conta,double valor){
        if(TipoDepósito == "Boleto"){
           AdapterPagamentos deposito = new AdapterBoleto();
           deposito.DepositoBancario(this.contas, conta, valor);
        }
        else if(TipoDepósito == "Débito"){
           AdapterPagamentos deposito = new AdapterDébito();
           deposito.DepositoBancario(this.contas, conta, valor);
        }
        else if(TipoDepósito == "Débito"){
           AdapterPagamentos deposito = new AdapterDébito();
           deposito.DepositoBancario(this.contas, conta, valor);
        }    
    }

    public vetor<pessoa> getContas() {
        return contas;
    }   
}


