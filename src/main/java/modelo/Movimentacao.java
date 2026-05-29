package modelo;

import constante.TipoMovimentacao;
import java.time.LocalDate;

/**
 * Classe responsável por registrar movimentações de estoque.
 *
 * Controla entradas e saídas de produtos.
 *
 * @author Bruno Antunes
 */
public class Movimentacao extends Entidade {

    /**
     * Produto movimentado.
     */
    private Produto produto;

    /**
     * Data da movimentação.
     */
    private LocalDate data;

    /**
     * Quantidade movimentada.
     */
    private int quantidade;

    /**
     * Tipo da movimentação.
     */
    private TipoMovimentacao tipo;

    /**
     * Construtor padrão.
     */
    public Movimentacao() {
    }

    /**
     * Construtor completo da movimentação.
     *
     * @param id identificador
     * @param produto produto movimentado
     * @param data data da movimentação
     * @param quantidade quantidade movimentada
     * @param tipo tipo da movimentação
     */
    public Movimentacao(int id, Produto produto, LocalDate data,
            int quantidade, TipoMovimentacao tipo) {

        super(id);

        this.produto = produto;
        this.data = data;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    /**
     * Retorna o produto movimentado.
     *
     * @return produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Define o produto movimentado.
     *
     * @param produto produto
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * Retorna a data da movimentação.
     *
     * @return data
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Define a data da movimentação.
     *
     * @param data data
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * Retorna a quantidade movimentada.
     *
     * @return quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade movimentada.
     *
     * @param quantidade quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna o tipo da movimentação.
     *
     * @return tipo da movimentação
     */
    public TipoMovimentacao getTipo() {
        return tipo;
    }

    /**
     * Define o tipo da movimentação.
     *
     * @param tipo tipo da movimentação
     */
    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna representação textual da movimentação.
     *
     * @return dados da movimentação
     */
    @Override
    public String toString() {

        return "Movimentacao{"
                + "produto=" + produto.getNome()
                + ", data=" + data
                + ", quantidade=" + quantidade
                + ", tipo=" + tipo
                + '}';

    }
}
