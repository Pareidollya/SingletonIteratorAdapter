//
package meprogavançada;

/**
 *
 * @author jj
 */
public class pessoa {
    private String nome;
    private int id;
    private double saldo;
    private Banco banco;
    
    

    public pessoa(String nome, int id, double saldo) {
        this.nome = nome;
        this.id = id;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    }
    
  
