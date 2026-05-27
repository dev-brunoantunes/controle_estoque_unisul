package teste;

import utilitarios.Conexao;
import java.sql.Connection;

public class teste {

    public static void main(String[] args) {

        Connection conn = Conexao.conectar();

        if (conn != null) {
            System.out.println("Banco conectado!");
        }
    }
}