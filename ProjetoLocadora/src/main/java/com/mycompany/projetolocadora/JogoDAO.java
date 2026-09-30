/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolocadora;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Home
 */
public class JogoDAO {
   public void salvar(Jogo jogo) {
        if (jogo.getId() == null) {
            inserir(jogo);
        } else {
            atualizar(jogo);
        }
    }

    private void inserir(Jogo jogo) {
        String sql = "INSERT INTO jogo (id_plataforma, titulo, genero, valor_diaria) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, jogo.getIdPlataforma());
            stmt.setString(2, jogo.getTitulo());
            stmt.setString(3, jogo.getGenero());
            stmt.setDouble(4, jogo.getValorDiaria());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir jogo: " + e.getMessage());
        }
    }

    private void atualizar(Jogo jogo) {
        String sql = "UPDATE jogo SET id_plataforma = ?, titulo = ?, genero = ?, valor_diaria = ? WHERE id_jogo = ?";

        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, jogo.getIdPlataforma());
            stmt.setString(2, jogo.getTitulo());
            stmt.setString(3, jogo.getGenero());
            stmt.setDouble(4, jogo.getValorDiaria());
            stmt.setInt(5, jogo.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar jogo: " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM jogo WHERE id_jogo = ?";

        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir jogo: " + e.getMessage());
        }
    }

    public List<Jogo> listar() {
        List<Jogo> lista = new ArrayList<>();
        String sql = "SELECT * FROM jogo ORDER BY id_jogo";

        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Jogo j = new Jogo(
                    rs.getInt("id_jogo"),
                    rs.getInt("id_plataforma"),
                    rs.getString("titulo"),
                    rs.getString("genero"),
                    rs.getDouble("valor_diaria")
                );
                lista.add(j);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar jogos: " + e.getMessage());
        }

        return lista;
    }
}
