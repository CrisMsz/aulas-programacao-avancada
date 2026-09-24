/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolocadora;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Home
 */
public class JogoDAO {
    public void salvar(Jogo jogo) {
        String sql = "INSERT INTO jogo (nome, categoria, valor, disponivel) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getCon();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, jogo.getNome());
            stmt.setString(2, jogo.getCategoria());
            stmt.setDouble(3, jogo.getValor());
            stmt.setBoolean(4, jogo.isDisponivel());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao salvar jogo: " + e.getMessage());
        }
    }

    public List<Jogo> listar() {
        List<Jogo> lista = new ArrayList<>();
        String sql = "SELECT * FROM jogo ORDER BY id_jogo";
        
        try (Connection conn = Conexao.getCon();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Jogo jogo = new Jogo();
                jogo.setId(rs.getInt("id_jogo"));
                jogo.setNome(rs.getString("nome"));
                jogo.setCategoria(rs.getString("categoria"));
                jogo.setValor(rs.getDouble("valor"));
                jogo.setDisponivel(rs.getBoolean("disponivel"));
                lista.add(jogo);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar jogos: " + e.getMessage());
        }
        return lista;
    }

    public void excluir(int id) {
        String sql = "DELETE FROM jogo WHERE id_jogo = ?";
        try (Connection conn = Conexao.getCon();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao excluir jogo: " + e.getMessage());
        }
    }
}
