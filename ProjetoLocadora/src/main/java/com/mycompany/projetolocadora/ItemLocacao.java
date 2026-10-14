/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolocadora;

import java.time.LocalDate;

/**
 *
 * @author Home
 */
public class ItemLocacao {

    private Integer id;
    private Integer idLocacao;
    private Integer idExemplar;
    private LocalDate dataDevolucaoReal;
    private double valorPagoDiaria;
    private double multaAtraso;

    public ItemLocacao() {
    }

    public ItemLocacao(Integer idExemplar, double valorPagoDiaria) {
        this.idExemplar = idExemplar;
        this.valorPagoDiaria = valorPagoDiaria;
    }

    public ItemLocacao(Integer id, Integer idLocacao, Integer idExemplar, LocalDate dataDevolucaoReal, double valorPagoDiaria, double multaAtraso) {
        this.id = id;
        this.idLocacao = idLocacao;
        this.idExemplar = idExemplar;
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.valorPagoDiaria = valorPagoDiaria;
        this.multaAtraso = multaAtraso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(Integer idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Integer getIdExemplar() {
        return idExemplar;
    }

    public void setIdExemplar(Integer idExemplar) {
        this.idExemplar = idExemplar;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public double getValorPagoDiaria() {
        return valorPagoDiaria;
    }

    public void setValorPagoDiaria(double valorPagoDiaria) {
        this.valorPagoDiaria = valorPagoDiaria;
    }

    public double getMultaAtraso() {
        return multaAtraso;
    }

    public void setMultaAtraso(double multaAtraso) {
        this.multaAtraso = multaAtraso;
    }

}
