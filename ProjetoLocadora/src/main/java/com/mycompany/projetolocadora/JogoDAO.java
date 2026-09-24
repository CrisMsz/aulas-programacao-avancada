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
    public void add(Jogo j) {
        try {
            Connection c = Conexao.getCon();
            String sql = "INSERT INTO jogo (nome, categoria, valor, disponivel) VALUES ('" 
                    + j.getN() + "', '" + j.getCat() + "', " + j.getV() + ", " + j.isD() + ")";
            PreparedStatement st = c.prepareStatement(sql);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro add: " + e.getMessage());
        }
    }

    public List<Jogo> get() {
        List<Jogo> lista = new ArrayList<>();
        try {
            Connection c = Conexao.getCon();
            PreparedStatement st = c.prepareStatement("SELECT * FROM jogo ORDER BY id_jogo");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Jogo aux = new Jogo();
                aux.setI(rs.getInt("id_jogo"));
                aux.setN(rs.getString("nome"));
                aux.setCat(rs.getString("categoria"));
                aux.setV(rs.getDouble("valor"));
                aux.setD(rs.getBoolean("disponivel"));
                lista.add(aux);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public void rem(int id) {
        try {
            Connection c = Conexao.getCon();
            PreparedStatement st = c.prepareStatement("DELETE FROM jogo WHERE id_jogo = " + id);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
