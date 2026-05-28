package principal;

import com.formdev.flatlaf.FlatDarkLaf;
import visao.FrmMain;

public class Principal {

    public static void main(String[] args) {

        try {
            javax.swing.UIManager.setLookAndFeel(
                new FlatDarkLaf()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        FrmMain tela = new FrmMain();

        tela.setVisible(true);

    }

}