/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolocadora;

/**
 *
 * @author Home
 */
public class Jogo {
    private Integer id;
    private Integer idPlataforma;
    private String titulo;
    private String genero;
    private double valorDiaria;

    public Jogo() {}

    public Jogo(Integer id, Integer idPlataforma, String titulo, String genero, double valorDiaria) {
        this.id = id;
        this.idPlataforma = idPlataforma;
        this.titulo = titulo;
        this.genero = genero;
        this.valorDiaria = valorDiaria;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getIdPlataforma() { return idPlataforma; }
    public void setIdPlataforma(Integer idPlataforma) { this.idPlataforma = idPlataforma; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public double getValorDiaria() { return valorDiaria; }
    public void setValorDiaria(double valorDiaria) { this.valorDiaria = valorDiaria; }
}
