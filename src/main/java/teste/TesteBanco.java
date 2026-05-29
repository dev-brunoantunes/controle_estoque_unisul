package teste;

import utilitario.Conexao;
import java.sql.Connection;

/**
 * Classe de teste para verificar a conexão com o banco de dados.
 *
 * @author Kauã
 */
public class TesteBanco {

    /**
     * Método principal que testa a conexão com o banco de dados.
     *
     * @param args argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Connection conn = Conexao.conectar();
        if (conn != null) {
            System.out.println("Banco conectado!");
        }
    }
}
