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
public class ExemplarDAO {

    public void salvar(Exemplar exemplar) {
        if (exemplar.getId() == null) {
            inserir(exemplar);
        } else {
            atualizar(exemplar);
        }
    }

    private void inserir(Exemplar exemplar) {
        String sql = "INSERT INTO exemplar (id_jogo, codigo_serie, status_conservacao, disponivel) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, exemplar.getIdJogo());
            stmt.setString(2, exemplar.getCodigoSerie());
            stmt.setString(3, exemplar.getStatusConservacao());
            stmt.setBoolean(4, exemplar.isDisponivel()); // Gravando o estado do JCheckBox

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir exemplar: " + e.getMessage());
        }
    }

    private void atualizar(Exemplar exemplar) {
        String sql = "UPDATE exemplar SET id_jogo = ?, codigo_serie = ?, status_conservacao = ?, disponivel = ? WHERE id_exemplar = ?";

        try (Connection conn = Conexao.obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, exemplar.getIdJogo());
            stmt.setString(2, exemplar.getCodigoSerie());
            stmt.setString(3, exemplar.getStatusConservacao());
            stmt.setBoolean(4, exemplar.isDisponivel());
            stmt.setInt(5, exemplar.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar exemplar: " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM exemplar WHERE id_exemplar = ?";

        try (Connection conn = Conexao.obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir exemplar: " + e.getMessage());
        }
    }

    public List<Exemplar> listar() {
        List<Exemplar> lista = new ArrayList<>();
        String sql = "SELECT * FROM exemplar ORDER BY id_exemplar";

        try (Connection conn = Conexao.obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Exemplar ex = new Exemplar(
                        rs.getInt("id_exemplar"),
                        rs.getInt("id_jogo"),
                        rs.getString("codigo_serie"),
                        rs.getString("status_conservacao"),
                        rs.getBoolean("disponivel")
                );
                lista.add(ex);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar exemplares: " + e.getMessage());
        }

        return lista;
    }
}
