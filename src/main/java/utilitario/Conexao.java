package utilitario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL =
            "jdbc:mysql://localhost:3306/controle_estoque?useSSL=false&serverTimezone=UTC";

    private static final String USUARIO =
            "root";

    //Alterar senha conforme senha do mysql
    private static final String SENHA =
            "root";

    
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