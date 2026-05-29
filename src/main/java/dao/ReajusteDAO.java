package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;
import javax.swing.JOptionPane;

import modelo.Reajuste;
import utilitario.Conexao;

/**
 * Classe responsável pelas operações de acesso a dados (DAO) da entidade
 * {@link Reajuste}. Realiza a operação de inserção na tabela {@code reajuste}
 * do banco de dados.
 *
 * @author Luigi
 */
public class ReajusteDAO {

    /**
     * Insere um novo reajuste no banco de dados. Caso o reajuste não esteja
     * associado a nenhuma categoria, o campo {@code categoria_id} será gravado
     * como {@code NULL}.
     *
     * @param r objeto {@link Reajuste} contendo os dados a serem inseridos,
     * incluindo data do reajuste, valor, tipo e categoria associada (opcional).
     */
    public void inserir(Reajuste r) {
        String sql = """
            INSERT INTO reajuste
            (data_reajuste, valor, tipo, categoria_id)
            VALUES (?, ?, ?, ?)
        """;
        try {
            Conexao con = new Conexao();
            Connection conn = con.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setDate(
                    1,
                    new java.sql.Date(
                            r.getDataReajuste().getTime()
                    )
            );
            stmt.setDouble(2, r.getValor());
            stmt.setString(3, r.getTipo().toString());

            if (r.getCategoria() != null) {
                stmt.setInt(4, r.getCategoria().getId());
            } else {
                stmt.setNull(4, Types.INTEGER);
            }

            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao salvar reajuste: " + e.getMessage()
            );
        }
    }
}
