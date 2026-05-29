package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;
import javax.swing.JOptionPane;
import modelo.Reajuste;
import utilitarios.Conexao;

public class ReajusteDAO {

    public void inserir(Reajuste r) {

        String sql = """
            INSERT INTO reajuste
            (data_reajuste, valor, tipo, categoria_id)
            VALUES (?, ?, ?, ?)
        """;

        try {

            Conexao con = new Conexao();

            Connection conn = con.conectar();

            PreparedStatement stmt
                    = conn.prepareStatement(sql);

            stmt.setDate(
                    1,
                    new java.sql.Date(
                            r.getDataReajuste().getTime()
                    )
            );

            stmt.setDouble(2, r.getValor());

            stmt.setString(3, r.getTipo().toString());

            if (r.getCategoria() != null) {

                stmt.setInt(
                        4,
                        r.getCategoria().getId()
                );

            } else {

                stmt.setNull(
                        4,
                        Types.INTEGER
                );
            }

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao salvar reajuste: "
                    + e.getMessage()
            );
        }
    }
}
