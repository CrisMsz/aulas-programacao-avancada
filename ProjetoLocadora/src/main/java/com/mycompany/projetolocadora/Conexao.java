/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolocadora;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Home
 */
public class Conexao {
    public static Connection getCon() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/locadora_jogos", "postgres", "postgres");
        } catch (Exception e) {
            System.out.println("Erro conexao: " + e.getMessage());
            return null;
        }
    }
}

