package teste;

import utilitario.Conexao;
import java.sql.Connection;

public class TesteBanco {

    public static void main(String[] args) {

        Connection conn = Conexao.conectar();

        if (conn != null) {
            System.out.println("Banco conectado!");
        }
    }
}