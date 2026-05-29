package model.classes;

public class Espacos {

    private int codEspaco;
    private String nome;
    private String descricao;
    private int numero;

    public Espacos() {

    }

    public int getCodEspaco() {
        return codEspaco;
    }

    public void setCodEspaco(int codEspaco) {
        this.codEspaco = codEspaco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Espacos(int codEspaco, String nome, String descricao, int numero) {
        this.codEspaco = codEspaco;
        this.nome = nome;
        this.descricao = descricao;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Espacos{" + "codEspaco=" + codEspaco + ", nome=" + nome + ", descricao=" + descricao + ", numero=" + numero + '}';
    }

}
