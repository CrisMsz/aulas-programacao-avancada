/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolocadora;

/**
 *
 * @author Home
 */
public class Cliente {
    private Integer id;
    private String n;
    private String c;
    private String t;
    private String e;

    public Cliente() {}

    public Cliente(Integer id, String n, String c, String t, String e) {
        this.id = id;
        this.n = n;
        this.c = c;
        this.t = t;
        this.e = e;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getN() { return n; }
    public void setN(String n) { this.n = n; }

    public String getC() { return c; }
    public void setC(String c) { this.c = c; }

    public String getT() { return t; }
    public void setT(String t) { this.t = t; }

    public String getE() { return e; }
    public void setE(String e) { this.e = e; }
}

