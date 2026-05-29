package interfaces;

import enums.TipoReajuste;

public interface Reajustavel {
    void reajustarPreco(double percentual, TipoReajuste tipo);
}