package modelo;

import enums.Unidade;
import interfaces.Reajustavel;

public class Produto extends Entidade implements Reajustavel {

    private String nome;
    private double preco;
    private Unidade unidade;

    private int quantidade;
    private int quantidadeMinima;
    private int quantidadeMaxima;

    private Categoria categoria;

    public Produto() {
    }

    public Produto(int id, String nome, double preco,
                   Unidade unidade, int quantidade,
                   int quantidadeMinima,
                   int quantidadeMaxima,
                   Categoria categoria) {

        super(id);

        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeMaxima = quantidadeMaxima;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(int quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public void reajustarPreco(double percentual) {

        preco = preco + (preco * percentual / 100);

    }

    // Entrada de estoque
    public void entradaEstoque(int quantidadeEntrada) {

        quantidade += quantidadeEntrada;

    }

    // Saída de estoque
    public boolean saidaEstoque(int quantidadeSaida) {

        if (quantidadeSaida > quantidade) {

            return false;

        }

        quantidade -= quantidadeSaida;

        return true;

    }

    // Verifica estoque mínimo
    public boolean abaixoMinimo() {

        return quantidade < quantidadeMinima;

    }

    // Verifica estoque máximo
    public boolean acimaMaximo() {

        return quantidade > quantidadeMaxima;

    }

    @Override
    public String toString() {

        return "Produto{" +
                "id=" + getId() +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", categoria=" + categoria.getNome() +
                '}';

    }

}