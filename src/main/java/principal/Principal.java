package principal;

import com.formdev.flatlaf.FlatDarkLaf;
import visao.FrmPrincipal;

public class Principal {

    public static void main(String[] args) {

        try {
            javax.swing.UIManager.setLookAndFeel(
                new FlatDarkLaf()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        FrmPrincipal tela = new FrmPrincipal();

        tela.setVisible(true);

    }

}