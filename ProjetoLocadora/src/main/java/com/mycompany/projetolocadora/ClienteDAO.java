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
public class ClienteDAO {
    public void salvar(Cliente cliente) {
        if (cliente.getId() == null) {
            inserir(cliente);
        } else {
            atualizar(cliente);
        }
    }

    private void inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, cpf, telefone, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    private void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, email = ? WHERE id_cliente = ?";

        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setInt(5, cliente.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";

        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir cliente: " + e.getMessage());
        }
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente ORDER BY id_cliente";

        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes: " + e.getMessage());
        }

        return lista;
    }
}
