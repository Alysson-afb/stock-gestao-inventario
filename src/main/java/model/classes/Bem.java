package model.classes;

import java.time.LocalDate;

public class Bem {

    private int codBem;
    private String categoria;
    private String nome;
    private String descricao;
    private float valor;
    private LocalDate dataAquisicao;
    private int estadoConservacao;
    private Espacos espaco;

    public Bem() {
        
    }

    public int getCodBem() {
        return codBem;
    }

    public void setCodBem(int codBem) {
        this.codBem = codBem;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public int getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(int estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    public Bem(int codBem, String categoria, String nome, String descricao, float valor, LocalDate dataAquisicao, int estadoConservacao, Espacos espaco) {
        this.codBem = codBem;
        this.categoria = categoria;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.dataAquisicao = dataAquisicao;
        this.estadoConservacao = estadoConservacao;
        this.espaco = espaco;
    }

    public Espacos getEspaco() {
        return espaco;
    }

    public void setEspaco(Espacos espaco) {
        this.espaco = espaco;
    }

    @Override
    public String toString() {
        return "Bem{" + "codBem=" + codBem + ", categoria=" + categoria + ", nome=" + nome + ", descricao=" + descricao + ", valor=" + valor + ", dataAquisicao=" + dataAquisicao + ", estadoConservacao=" + estadoConservacao + '}';
    }

}
