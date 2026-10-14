/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolocadora;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Home
 */
public class LocacaoDAO {

    public boolean salvarLocacaoTransacional(Locacao locacao) {
        String sqlLocacao = "INSERT INTO locacao (id_cliente, data_locacao, data_prevista_devolucao, status_locacao) VALUES (?, CURRENT_DATE, ?, ?) RETURNING id_locacao";
        String sqlItem = "INSERT INTO item_locacao (id_locacao, id_exemplar, valor_pago_diaria) VALUES (?, ?, ?)";
        String sqlAtualizarExemplar = "UPDATE exemplar SET disponivel = FALSE WHERE id_exemplar = ?";

        Connection conn = null;

        try {
            conn = Conexao.obterConexao();
            conn.setAutoCommit(false);

            int idLocacaoGerado = 0;

            try (PreparedStatement stmtLoc = conn.prepareStatement(sqlLocacao)) {
                stmtLoc.setInt(1, locacao.getIdCliente());
                stmtLoc.setDate(2, Date.valueOf(locacao.getDataPrevistaDevolucao()));
                stmtLoc.setString(3, locacao.getStatusLocacao());

                try (ResultSet rs = stmtLoc.executeQuery()) {
                    if (rs.next()) {
                        idLocacaoGerado = rs.getInt(1);
                    } else {
                        conn.rollback();
                        return false;
                    }
                }
            }

            try (PreparedStatement stmtItem = conn.prepareStatement(sqlItem); PreparedStatement stmtExemplar = conn.prepareStatement(sqlAtualizarExemplar)) {

                for (ItemLocacao item : locacao.getItens()) {
                    stmtItem.setInt(1, idLocacaoGerado);
                    stmtItem.setInt(2, item.getIdExemplar());
                    stmtItem.setDouble(3, item.getValorPagoDiaria());
                    stmtItem.executeUpdate();

                    stmtExemplar.setInt(1, item.getIdExemplar());
                    stmtExemplar.executeUpdate();
                }
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro na transação de locação: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.err.println("Erro ao efetuar rollback: " + ex.getMessage());
                }
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }

    public List<Exemplar> listarExemplaresDisponiveis() {
        List<Exemplar> lista = new ArrayList<>();
        String sql = "SELECT * FROM exemplar WHERE disponivel = TRUE ORDER BY id_exemplar";

        try (Connection conn = Conexao.obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Exemplar(
                        rs.getInt("id_exemplar"),
                        rs.getInt("id_jogo"),
                        rs.getString("codigo_serie"),
                        rs.getString("status_conservacao"),
                        rs.getBoolean("disponivel")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar exemplares disponíveis: " + e.getMessage());
        }

        return lista;
    }
}
