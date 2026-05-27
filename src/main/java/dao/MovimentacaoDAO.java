package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Movimentacao;
import modelo.Produto;
import enums.TipoMovimentacao;
import utilitarios.Conexao;

public class MovimentacaoDAO {

    public void inserir(Movimentacao movimentacao) {

        String sql = """
            INSERT INTO movimentacao (produto_id, data_mov, quantidade, tipo)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, movimentacao.getProduto().getId());
            ps.setDate(2, java.sql.Date.valueOf(movimentacao.getData()));
            ps.setInt(3, movimentacao.getQuantidade());
            ps.setString(4, movimentacao.getTipo().name());

            ps.executeUpdate();

            System.out.println("Movimentação registrada!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Movimentacao movimentacao) {

        String sql = """
        UPDATE movimentacao
        SET produto_id = ?, data_mov = ?, quantidade = ?, tipo = ?
        WHERE id = ?
    """;

        try (java.sql.Connection conn = utilitarios.Conexao.conectar(); java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, movimentacao.getProduto().getId());
            ps.setDate(2, java.sql.Date.valueOf(movimentacao.getData()));
            ps.setInt(3, movimentacao.getQuantidade());
            ps.setString(4, movimentacao.getTipo().name());
            ps.setInt(5, movimentacao.getId());

            ps.executeUpdate();
            System.out.println("Movimentação atualizada!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remover(int id) {

        String sql = "DELETE FROM movimentacao WHERE id = ?";

        try (java.sql.Connection conn = utilitarios.Conexao.conectar(); java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Movimentação removida!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Movimentacao> listar() {

        List<Movimentacao> lista = new ArrayList<>();

        String sql = """
            SELECT m.id, m.data_mov, m.quantidade, m.tipo,
                   p.id AS prod_id, p.nome AS prod_nome
            FROM movimentacao m
            LEFT JOIN produto p ON m.produto_id = p.id
            ORDER BY m.data_mov DESC
        """;

        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Produto produto = new Produto();
                produto.setId(rs.getInt("prod_id"));
                produto.setNome(rs.getString("prod_nome"));

                Movimentacao mov = new Movimentacao();
                mov.setId(rs.getInt("id"));
                mov.setProduto(produto);
                mov.setData(rs.getDate("data_mov").toLocalDate());
                mov.setQuantidade(rs.getInt("quantidade"));
                mov.setTipo(TipoMovimentacao.valueOf(rs.getString("tipo")));

                lista.add(mov);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
