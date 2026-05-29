package modelo;

import constante.Unidade;
import contrato.Reajustavel;

/**
 * Classe responsável por representar produtos do sistema.
 *
 * Controla estoque, preço, categoria e reajustes.
 *
 * @author Bruno Antunes
 */
public class Produto extends Entidade implements Reajustavel {

    /**
     * Nome do produto.
     */
    private String nome;

    /**
     * Preço atual do produto.
     */
    private double preco;

    /**
     * Unidade de medida do produto.
     */
    private Unidade unidade;

    /**
     * Quantidade disponível em estoque.
     */
    private int quantidade;

    /**
     * Quantidade mínima permitida em estoque.
     */
    private int quantidadeMinima;

    /**
     * Quantidade máxima permitida em estoque.
     */
    private int quantidadeMaxima;

    /**
     * Categoria do produto.
     */
    private Categoria categoria;

    /**
     * Construtor padrão.
     */
    public Produto() {
    }

    /**
     * Construtor completo do produto.
     *
     * @param id identificador
     * @param nome nome do produto
     * @param preco preço do produto
     * @param unidade unidade de medida
     * @param quantidade quantidade em estoque
     * @param quantidadeMinima estoque mínimo
     * @param quantidadeMaxima estoque máximo
     * @param categoria categoria do produto
     */
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

    /**
     * Retorna o nome do produto.
     *
     * @return nome do produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     *
     * @param nome nome do produto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o preço do produto.
     *
     * @return preço atual
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do produto.
     *
     * @param preco novo preço
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Retorna a unidade do produto.
     *
     * @return unidade
     */
    public Unidade getUnidade() {
        return unidade;
    }

    /**
     * Define a unidade do produto.
     *
     * @param unidade unidade de medida
     */
    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    /**
     * Retorna a quantidade em estoque.
     *
     * @return quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade em estoque.
     *
     * @param quantidade quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna o estoque mínimo.
     *
     * @return estoque mínimo
     */
    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    /**
     * Define o estoque mínimo.
     *
     * @param quantidadeMinima estoque mínimo
     */
    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    /**
     * Retorna o estoque máximo.
     *
     * @return estoque máximo
     */
    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    /**
     * Define o estoque máximo.
     *
     * @param quantidadeMaxima estoque máximo
     */
    public void setQuantidadeMaxima(int quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    /**
     * Retorna a categoria do produto.
     *
     * @return categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Define a categoria do produto.
     *
     * @param categoria categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Realiza reajuste de preço do produto.
     *
     * @param percentual percentual aplicado
     * @param tipo tipo do reajuste
     */
    @Override
    public void reajustarPreco(double percentual, constante.TipoReajuste tipo) {

        if (tipo == constante.TipoReajuste.AUMENTO) {

            preco = preco + (preco * percentual / 100);

        } else {

            preco = preco - (preco * percentual / 100);

            if (preco < 0) {
                preco = 0;
            }
        }
    }

    /**
     * Adiciona produtos ao estoque.
     *
     * @param quantidadeEntrada quantidade adicionada
     */
    public void entradaEstoque(int quantidadeEntrada) {

        quantidade += quantidadeEntrada;

    }

    /**
     * Remove produtos do estoque.
     *
     * @param quantidadeSaida quantidade removida
     * @return true se a saída for realizada
     */
    public boolean saidaEstoque(int quantidadeSaida) {

        if (quantidadeSaida > quantidade) {

            return false;

        }

        quantidade -= quantidadeSaida;

        return true;

    }

    /**
     * Verifica se o estoque está abaixo do mínimo.
     *
     * @return true se estiver abaixo do mínimo
     */
    public boolean abaixoMinimo() {

        return quantidade < quantidadeMinima;

    }

    /**
     * Verifica se o estoque está acima do máximo.
     *
     * @return true se estiver acima do máximo
     */
    public boolean acimaMaximo() {

        return quantidade > quantidadeMaxima;

    }

    /**
     * Retorna representação textual do produto.
     *
     * @return dados do produto
     */
    @Override
    public String toString() {

        return "Produto{"
                + "id=" + getId()
                + ", nome='" + nome + '\\'
                + ", preco=" + preco
                + ", quantidade=" + quantidade
                + ", categoria=" + categoria.getNome()
                + '}';

    }

}
