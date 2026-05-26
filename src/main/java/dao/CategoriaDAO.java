package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;
import model.Embalagem;
import model.Tamanho;
import util.Conexao;

public class CategoriaDAO {

    public void inserir(Categoria categoria) {

        String sql = "INSERT INTO categoria (nome, tamanho, embalagem) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getTamanho().name());
            ps.setString(3, categoria.getEmbalagem().name());

            ps.executeUpdate();

            System.out.println("Categoria inserida!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Categoria> listar() {

        List<Categoria> lista = new ArrayList<>();

        String sql = "SELECT id, nome, tamanho, embalagem FROM categoria";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Categoria categoria = new Categoria();

                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categoria.setTamanho(Tamanho.valueOf(rs.getString("tamanho")));
                categoria.setEmbalagem(Embalagem.valueOf(rs.getString("embalagem")));

                lista.add(categoria);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Categoria buscarPorId(int id) {

        String sql = "SELECT id, nome, tamanho, embalagem FROM categoria WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Categoria categoria = new Categoria();

                    categoria.setId(rs.getInt("id"));
                    categoria.setNome(rs.getString("nome"));
                    categoria.setTamanho(Tamanho.valueOf(rs.getString("tamanho")));
                    categoria.setEmbalagem(Embalagem.valueOf(rs.getString("embalagem")));

                    return categoria;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void atualizar(Categoria categoria) {

        String sql = "UPDATE categoria SET nome = ?, tamanho = ?, embalagem = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getTamanho().name());
            ps.setString(3, categoria.getEmbalagem().name());
            ps.setInt(4, categoria.getId());

            ps.executeUpdate();

            System.out.println("Categoria atualizada!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remover(int id) {

        String sql = "DELETE FROM categoria WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Categoria removida!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//testecommit
//testecommit