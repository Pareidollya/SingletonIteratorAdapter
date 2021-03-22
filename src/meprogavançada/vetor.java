package meprogavançada;

/**
 *
 * @author jj
 */
public class vetor<T> {
    private int tamanho; 
    private  T[] vetor;
    private int elementos = 0;

    public vetor() {
    }

    public vetor(int tamanho) {
        this.tamanho = tamanho;
        vetor = (T[]) new Object[tamanho];
        
    }
    public void adiciona(T elemento,int pos){ 
        this.verificarPosição(pos);
        vetor[pos] = elemento;
        elementos++;
        
    }
    public T recupera(int pos){
        this.verificarPosição(pos);
        return vetor[pos];    
    }
    
    public void adicionaInicio(T elemento){
        this.redimencionar();//verificar se vetor
        Iterador Vit = new Iterador(vetor); 
        int count = 0;
        
        while (Vit.hasNext()){
            if(Vit.next() == null){
                vetor[count] = elemento;
                elementos++;
                System.out.println("Novo usuario adicionado ao banco!");
                break;
            }
            count++;
        }  
    }
    public void adicionaFim(T elemento){ 
        this.redimencionar(); //nao sei usar iterator 
        int count = tamanho - 1;
        while (count >= 0){
            if (vetor[count] == null){
               vetor[count] = elemento;
               elementos++;
               System.out.println("Elemento adicionado final!");
               break;
            }
            count--;
        }
    }
    
    public boolean existeDado(int pos){
        //tratar
        if (vetor[pos] != null){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public int encontrar(T dado){
        int i=0;
        Iterador vit = new Iterador(vetor);
        
        if (vit.next() != dado){
            i++;
        }
        else{
            return i;
        }
        return i;
    }
    
    public boolean possuiDado(T dado){
            Iterador vit = new Iterador(vetor);
            if(vit.next() != dado){
                return false;
            }
            else
                return true;
        }
    
    public boolean vazio(){
          Iterador vit = new Iterador(vetor);
          if (vit.next() != null){
              return false;    
          }
          else{
              return true;
          }
    }
    
   public void remove (int pos){
       this.verificarPosição(pos);
       
       if (this.existeDado(pos) == true && this.vazio() == false) {
           vetor[pos] = null;
           elementos--;
           System.out.println("removido");
           
       }
       else{
           System.out.println("O vetor ja esta vazio");
       }
       
   }
   
    public void RemoveInicio(){
        if(this.elementos == 0){
            System.out.println("Vetor ja esta vazio");
        }
        
        Iterador Vit = new Iterador(vetor); 
        int count = 0;
        
        while (Vit.hasNext()){
            if(Vit.next() != null){
                vetor[count] = null;
                elementos--;
                System.out.println("Elemento removido do inicio!");
                break;
            }
            count++;
        }
    }
    
     public int Tamanho(){
        return this.getElementos();
    }
     
     public void Limpa(){
        if (this.vazio()== true){
            System.out.println("Vetor ja esta vazio");
        }
        else{
        Iterador Vit = new Iterador(vetor); 
        int count = 0;
        
        while (Vit.hasNext()){
            if(Vit.next() != null){
                vetor[count] = null;
                elementos--;
                }
            count++;
            }
        }
        System.out.println("vetor limpo");
    }
     
     public void redimencionar(){ //tratar exceção quanto a posição ao tamanho do vetor (nao funciona em metodo static)
         if (this.elementos == this.getTamanho()){
             T[] vetor2 = (T[]) new Object[this.vetor.length * 2];
            for (int i = 0; i < this.vetor.length;i++){
             vetor2[i] = this.vetor[i];
         }
        System.out.println("Tamanho redimencionado!");
        this.vetor = vetor2;
        }
    }  
     
     public void verificarPosição(int pos){ //tratar exceção quanto a posição a se inserir
         if (pos>=tamanho){
            throw new IllegalArgumentException("Posição invalida! " + pos);
        }
       else if (pos < 0){
           throw new IllegalArgumentException("Posição invalida! "+ pos);
       }

     }
     
    public int getTamanho() {
        return vetor.length;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public T[] getVetor() {
        return vetor;
    }

    public void setVetor(T[] vetor) {
        this.vetor = vetor;
    }

    public int getElementos() {
        return elementos;
    }

    public void setElementos(int elementos) {
        this.elementos = elementos;
    }
    
    
}
