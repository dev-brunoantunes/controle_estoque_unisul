package utilitario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe utilitária responsável por gerenciar a conexão com o banco de dados.
 *
 * @author Kauã
 */
public class Conexao {

    /** URL de conexão com o banco de dados. */
    private static final String URL =
            "jdbc:mysql://localhost:3306/controle_estoque?useSSL=false&serverTimezone=UTC";

    /** Usuário do banco de dados. */
    private static final String USUARIO = "root";

    /** Senha do banco de dados. Alterar conforme a senha do MySQL. */
    private static final String SENHA = "root";

    /**
     * Estabelece e retorna uma conexão com o banco de dados.
     *
     * @return {@link Connection} ativa se a conexão for bem-sucedida, ou {@code null} em caso de erro.
     */
    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(
                    URL,
                    USUARIO,
                    SENHA
            );
            System.out.println("Conectado com sucesso!");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro na conexão");
            e.printStackTrace();
            return null;
        }
    }
}