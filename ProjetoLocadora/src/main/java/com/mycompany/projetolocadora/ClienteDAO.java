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
public class ClienteDAO {
    public void proc(Cliente c) {
        try {
            Connection conn = Conexao.getCon();
            String sql = "INSERT INTO cliente (nome, cpf, telefone, email) VALUES (?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, c.getN());
            st.setString(2, c.getC());
            st.setString(3, c.getT());
            st.setString(4, c.getE());
            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
        }
    }

    public List<Cliente> buscar() {
        List<Cliente> l = new ArrayList<>();
        try {
            Connection conn = Conexao.getCon();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cliente aux = new Cliente();
                aux.setId(rs.getInt("id_cliente"));
                aux.setN(rs.getString("nome"));
                aux.setC(rs.getString("cpf"));
                aux.setT(rs.getString("telefone"));
                aux.setE(rs.getString("email"));
                l.add(aux);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return l;
    }

    public void del(int id) {
        try {
            Connection conn = Conexao.getCon();
            PreparedStatement st = conn.prepareStatement("DELETE FROM cliente WHERE id_cliente = " + id);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
