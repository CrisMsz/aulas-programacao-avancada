/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolocadora;

/**
 *
 * @author Home
 */
public class ValidadorCPF {

    public static boolean isValido(String cpf) {
        if (cpf == null) {
            return false;
        }

        String cpfLimpo = cpf.replaceAll("\\D", "");

        if (cpfLimpo.length() != 11 || cpfLimpo.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += (cpfLimpo.charAt(i) - '0') * (10 - i);
            }
            int digito1 = 11 - (soma % 11);
            if (digito1 >= 10) {
                digito1 = 0;
            }

            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += (cpfLimpo.charAt(i) - '0') * (11 - i);
            }
            int digito2 = 11 - (soma % 11);
            if (digito2 >= 10) {
                digito2 = 0;
            }

            return (digito1 == (cpfLimpo.charAt(9) - '0')) && (digito2 == (cpfLimpo.charAt(10) - '0'));
        } catch (Exception e) {
            return false;
        }
    }
}
