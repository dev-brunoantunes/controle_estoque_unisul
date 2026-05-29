package modelo;

/**
 * Classe abstrata base para todas as entidades do sistema.
 *
 * Centraliza o identificador único das entidades.
 *
 * @author Bruno Antunes
 */
public abstract class Entidade {

    /**
     * Identificador da entidade.
     */
    private int id;

    /**
     * Construtor padrão.
     */
    public Entidade() {
    }

    /**
     * Construtor com identificador.
     *
     * @param id identificador da entidade
     */
    public Entidade(int id) {
        this.id = id;
    }

    /**
     * Retorna o identificador da entidade.
     *
     * @return identificador
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador da entidade.
     *
     * @param id identificador da entidade
     */
    public void setId(int id) {
        this.id = id;
    }
}
