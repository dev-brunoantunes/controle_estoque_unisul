package modelo;

import constante.Tamanho;
import constante.Embalagem;

/**
 * Representa uma categoria de produtos.
 *
 * A categoria define características como tamanho e embalagem.
 *
 * @author Bruno Antunes
 */
public class Categoria extends Entidade {

    /**
     * Nome da categoria.
     */
    private String nome;

    /**
     * Tamanho associado à categoria.
     */
    private Tamanho tamanho;

    /**
     * Tipo de embalagem da categoria.
     */
    private Embalagem embalagem;

    /**
     * Construtor padrão.
     */
    public Categoria() {
    }

    /**
     * Retorna o nome da categoria.
     *
     * @return nome da categoria
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da categoria.
     *
     * @param nome nome da categoria
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o tamanho da categoria.
     *
     * @return tamanho
     */
    public Tamanho getTamanho() {
        return tamanho;
    }

    /**
     * Define o tamanho da categoria.
     *
     * @param tamanho tamanho
     */
    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Retorna a embalagem da categoria.
     *
     * @return embalagem
     */
    public Embalagem getEmbalagem() {
        return embalagem;
    }

    /**
     * Define a embalagem da categoria.
     *
     * @param embalagem embalagem
     */
    public void setEmbalagem(Embalagem embalagem) {
        this.embalagem = embalagem;
    }

    /**
     * Retorna representação textual da categoria.
     *
     * @return nome da categoria
     */
    @Override
    public String toString() {

        return nome;

    }
}
