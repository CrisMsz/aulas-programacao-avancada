/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolocadora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Home
 */
public class Conexao {
   private static final String URL = "jdbc:postgresql://localhost:5432/locadora_jogos";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres"; 

    public static Connection obterConexao() throws SQLException {
        try {
            
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("O arquivo JAR do PostgreSQL nao foi adicionado ao classpath do Maven.", e);
        }
    }
}

