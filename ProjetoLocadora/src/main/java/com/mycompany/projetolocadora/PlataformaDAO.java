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
public class PlataformaDAO {

    public List<Plataforma> listar() {
        List<Plataforma> lista = new ArrayList<>();
        String sql = "SELECT * FROM plataforma ORDER BY nome_plataforma";
        try (Connection conn = Conexao.obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Plataforma(rs.getInt("id_plataforma"), rs.getString("nome_plataforma")));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar plataformas: " + e.getMessage());
        }
        return lista;
    }
}
