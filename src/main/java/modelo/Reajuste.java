package modelo;

public class Reajuste {

    private int id;
    private java.util.Date dataReajuste;
    private double valor;
    private enums.TipoReajuste tipo;
    private Categoria categoria;

    public Reajuste() {
    }

    public Reajuste(int id, java.util.Date dataReajuste,
            double valor,
            enums.TipoReajuste tipo,
            Categoria categoria) {

        this.id = id;
        this.dataReajuste = dataReajuste;
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.util.Date getDataReajuste() {
        return dataReajuste;
    }

    public void setDataReajuste(java.util.Date dataReajuste) {
        this.dataReajuste = dataReajuste;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public enums.TipoReajuste getTipo() {
        return tipo;
    }

    public void setTipo(enums.TipoReajuste tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
