package contrato;

import constante.TipoReajuste;

/**
 * Interface responsável por definir comportamento de reajuste de preços.
 *
 * Classes que implementam esta interface devem possuir lógica de alteração de
 * preços.
 *
 * @author Bruno Antunes
 */
public interface Reajustavel {

    /**
     * Realiza reajuste de preço.
     *
     * @param percentual percentual aplicado no reajuste
     * @param tipo tipo do reajuste
     */
    void reajustarPreco(double percentual, TipoReajuste tipo);

}
