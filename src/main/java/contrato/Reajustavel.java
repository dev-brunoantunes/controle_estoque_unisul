package contrato;

import constante.TipoReajuste;

public interface Reajustavel {
    void reajustarPreco(double percentual, TipoReajuste tipo);
}