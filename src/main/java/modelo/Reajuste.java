package modelo;

/**
 * Classe responsável por representar reajustes de preços.
 *
 * Armazena histórico de alterações financeiras.
 *
 * @author Bruno Antunes
 */
public class Reajuste {

    /**
     * Identificador do reajuste.
     */
    private int id;

    /**
     * Data em que o reajuste foi realizado.
     */
    private java.util.Date dataReajuste;

    /**
     * Valor percentual do reajuste.
     */
    private double valor;

    /**
     * Tipo do reajuste.
     */
    private constante.TipoReajuste tipo;

    /**
     * Categoria relacionada ao reajuste.
     */
    private Categoria categoria;

    /**
     * Construtor padrão.
     */
    public Reajuste() {
    }

    /**
     * Construtor completo do reajuste.
     *
     * @param id identificador
     * @param dataReajuste data do reajuste
     * @param valor valor percentual
     * @param tipo tipo do reajuste
     * @param categoria categoria relacionada
     */
    public Reajuste(int id, java.util.Date dataReajuste,
            double valor,
            constante.TipoReajuste tipo,
            Categoria categoria) {

        this.id = id;
        this.dataReajuste = dataReajuste;
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    /**
     * Retorna o identificador.
     *
     * @return identificador
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador.
     *
     * @param id identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna a data do reajuste.
     *
     * @return data do reajuste
     */
    public java.util.Date getDataReajuste() {
        return dataReajuste;
    }

    /**
     * Define a data do reajuste.
     *
     * @param dataReajuste data do reajuste
     */
    public void setDataReajuste(java.util.Date dataReajuste) {
        this.dataReajuste = dataReajuste;
    }

    /**
     * Retorna o valor do reajuste.
     *
     * @return valor percentual
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define o valor do reajuste.
     *
     * @param valor valor percentual
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Retorna o tipo do reajuste.
     *
     * @return tipo do reajuste
     */
    public constante.TipoReajuste getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do reajuste.
     *
     * @param tipo tipo do reajuste
     */
    public void setTipo(constante.TipoReajuste tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna a categoria relacionada.
     *
     * @return categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Define a categoria relacionada.
     *
     * @param categoria categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
