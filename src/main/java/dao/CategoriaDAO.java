package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import constante.Embalagem;
import constante.Tamanho;
import utilitario.Conexao;

/**
 * Classe responsável pelas operações de acesso a dados (DAO) da entidade
 * {@link Categoria}. Realiza operações de CRUD (Create, Read, Update, Delete)
 * na tabela {@code categoria} do banco de dados.
 *
 * @author Luigi
 */
public class CategoriaDAO {

    /**
     * Insere uma nova categoria no banco de dados.
     *
     * @param categoria objeto {@link Categoria} contendo os dados a serem
     * inseridos, incluindo nome, tamanho e embalagem.
     */
    public void inserir(Categoria categoria) {
        String sql = "INSERT INTO categoria (nome, tamanho, embalagem) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getTamanho().name());
            ps.setString(3, categoria.getEmbalagem().name());
            ps.executeUpdate();
            System.out.println("Categoria inserida!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna uma lista com todas as categorias cadastradas no banco de dados.
     *
     * @return {@link List} de objetos {@link Categoria} com todos os registros
     * encontrados. Retorna uma lista vazia caso não haja registros.
     */
    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT id, nome, tamanho, embalagem FROM categoria";
        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
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

    /**
     * Busca uma categoria no banco de dados pelo seu identificador único.
     *
     * @param id identificador único da categoria a ser buscada.
     * @return objeto {@link Categoria} correspondente ao {@code id} informado,
     * ou {@code null} caso nenhum registro seja encontrado.
     */
    public Categoria buscarPorId(int id) {
        String sql = "SELECT id, nome, tamanho, embalagem FROM categoria WHERE id = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
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

    /**
     * Atualiza os dados de uma categoria existente no banco de dados.
     *
     * @param categoria objeto {@link Categoria} contendo os novos dados a serem
     * atualizados. O campo {@code id} é utilizado para identificar o registro a
     * ser alterado.
     */
    public void atualizar(Categoria categoria) {
        String sql = "UPDATE categoria SET nome = ?, tamanho = ?, embalagem = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
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

    /**
     * Remove uma categoria do banco de dados pelo seu identificador único.
     *
     * @param id identificador único da categoria a ser removida.
     */
    public void remover(int id) {
        String sql = "DELETE FROM categoria WHERE id = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Categoria removida!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
