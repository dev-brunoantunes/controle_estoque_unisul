package modelo;

import constante.TipoMovimentacao;
import java.time.LocalDate;

public class Movimentacao extends Entidade {

    private Produto produto;
    private LocalDate data;
    private int quantidade;
    private TipoMovimentacao tipo;

    public Movimentacao() {
    }

    public Movimentacao(int id, Produto produto, LocalDate data,
                        int quantidade, TipoMovimentacao tipo) {

        super(id);

        this.produto = produto;
        this.data = data;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {

        return "Movimentacao{" +
                "produto=" + produto.getNome() +
                ", data=" + data +
                ", quantidade=" + quantidade +
                ", tipo=" + tipo +
                '}';

    }
}