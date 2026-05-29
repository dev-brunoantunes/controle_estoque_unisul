package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Produto;
import constante.Unidade;
import constante.Tamanho;
import constante.Embalagem;
import utilitario.Conexao;

/**
 * Classe responsável pelas operações de acesso a dados (DAO) da entidade
 * {@link Produto}. Realiza operações de CRUD (Create, Read, Update, Delete) na
 * tabela {@code produto} do banco de dados, com suporte a JOIN com a tabela
 * {@code categoria} para recuperação de dados relacionados.
 *
 * @author Luigi
 */
public class ProdutoDAO {

    /**
     * Insere um novo produto no banco de dados.
     *
     * @param produto objeto {@link Produto} contendo os dados a serem
     * inseridos, incluindo nome, preço, unidade, quantidade, quantidade mínima,
     * quantidade máxima e categoria associada.
     */
    public void cadastrar(Produto produto) {

        String sql = """
            INSERT INTO produto
            (nome, preco, unidade, quantidade,
             qtd_min, qtd_max, categoria_id)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setString(3, produto.getUnidade().name());
            ps.setInt(4, produto.getQuantidade());
            ps.setInt(5, produto.getQuantidadeMinima());
            ps.setInt(6, produto.getQuantidadeMaxima());
            ps.setInt(7, produto.getCategoria().getId());

            ps.executeUpdate();

            System.out.println("Produto cadastrado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna uma lista com todos os produtos cadastrados no banco de dados.
     * Realiza um LEFT JOIN com a tabela {@code categoria} para recuperar os
     * dados completos da categoria associada a cada produto.
     *
     * @return {@link List} de objetos {@link Produto} com todos os registros
     * encontrados. Retorna uma lista vazia caso não haja registros.
     */
    public List<Produto> listar() {

        List<Produto> lista = new ArrayList<>();

        String sql = """
            SELECT p.id, p.nome, p.preco, p.unidade,
                   p.quantidade, p.qtd_min, p.qtd_max,
                   c.id AS cat_id, c.nome AS cat_nome,
                   c.tamanho, c.embalagem
            FROM produto p
            LEFT JOIN categoria c ON p.categoria_id = c.id
        """;

        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Categoria categoria = new Categoria();

                categoria.setId(rs.getInt("cat_id"));
                categoria.setNome(rs.getString("cat_nome"));
                categoria.setTamanho(Tamanho.valueOf(rs.getString("tamanho")));
                categoria.setEmbalagem(Embalagem.valueOf(rs.getString("embalagem")));

                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        Unidade.valueOf(rs.getString("unidade")),
                        rs.getInt("quantidade"),
                        rs.getInt("qtd_min"),
                        rs.getInt("qtd_max"),
                        categoria
                );

                lista.add(produto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    /**
     * Busca um produto no banco de dados pelo seu identificador único. Realiza
     * um LEFT JOIN com a tabela {@code categoria} para recuperar os dados
     * completos da categoria associada ao produto.
     *
     * @param id identificador único do produto a ser buscado.
     * @return objeto {@link Produto} correspondente ao {@code id} informado, ou
     * {@code null} caso nenhum registro seja encontrado.
     */
    public Produto buscarPorId(int id) {

        String sql = """
            SELECT p.id, p.nome, p.preco, p.unidade,
                   p.quantidade, p.qtd_min, p.qtd_max,
                   c.id AS cat_id, c.nome AS cat_nome,
                   c.tamanho, c.embalagem
            FROM produto p
            LEFT JOIN categoria c ON p.categoria_id = c.id
            WHERE p.id = ?
        """;

        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Categoria categoria = new Categoria();

                    categoria.setId(rs.getInt("cat_id"));
                    categoria.setNome(rs.getString("cat_nome"));
                    categoria.setTamanho(Tamanho.valueOf(rs.getString("tamanho")));
                    categoria.setEmbalagem(Embalagem.valueOf(rs.getString("embalagem")));

                    return new Produto(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getDouble("preco"),
                            Unidade.valueOf(rs.getString("unidade")),
                            rs.getInt("quantidade"),
                            rs.getInt("qtd_min"),
                            rs.getInt("qtd_max"),
                            categoria
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Atualiza os dados de um produto existente no banco de dados.
     *
     * @param produto objeto {@link Produto} contendo os novos dados a serem
     * atualizados. O campo {@code id} é utilizado para identificar o registro a
     * ser alterado.
     */
    public void atualizar(Produto produto) {

        String sql = """
            UPDATE produto
            SET nome = ?, preco = ?, unidade = ?,
                quantidade = ?, qtd_min = ?, qtd_max = ?,
                categoria_id = ?
            WHERE id = ?
        """;

        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setString(3, produto.getUnidade().name());
            ps.setInt(4, produto.getQuantidade());
            ps.setInt(5, produto.getQuantidadeMinima());
            ps.setInt(6, produto.getQuantidadeMaxima());
            ps.setInt(7, produto.getCategoria().getId());
            ps.setInt(8, produto.getId());

            ps.executeUpdate();

            System.out.println("Produto atualizado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Remove um produto do banco de dados pelo seu identificador único.
     *
     * @param id identificador único do produto a ser removido.
     */
    public void remover(int id) {

        String sql = "DELETE FROM produto WHERE id = ?";

        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Produto removido!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
