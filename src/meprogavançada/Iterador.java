package meprogavançada;
import java.util.Iterator;
/**
 *
 * @author jj
 */
public class Iterador<T> implements Iterator {

    T[] itens;
    int posicao = 0;
    int posiçãoF;
    
    public Iterador(T[] itens) {
        this.itens = itens;
    }

    public boolean hasNext() {
        if (posicao < 0 || posicao >= itens.length) {
            return false;
        } else {
            return true;
        }
    }

    public Object next() {
        Object item = itens[posicao];
        posicao++;
        return item;
    }
    
    public Object getAtual(){
        Object item = itens[posicao];
        return item;
    }
 
}   
    

