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
    private Integer i;
    private String n;
    private String cat;
    private double v;
    private boolean d;

    public Jogo() {}

    public Jogo(Integer i, String n, String cat, double v, boolean d) {
        this.i = i;
        this.n = n;
        this.cat = cat;
        this.v = v;
        this.d = d;
    }

    public Integer getI() { return i; }
    public void setI(Integer i) { this.i = i; }

    public String getN() { return n; }
    public void setN(String n) { this.n = n; }

    public String getCat() { return cat; }
    public void setCat(String cat) { this.cat = cat; }

    public double getV() { return v; }
    public void setV(double v) { this.v = v; }

    public boolean isD() { return d; }
    public void setD(boolean d) { this.d = d; }
}
