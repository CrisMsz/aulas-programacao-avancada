/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetolocadora;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Home
 */
public class ProjetoLocadora {

    public static void main(String[] args) {
       try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Erro LookAndFeel: " + e.getMessage());
        }

        
        SwingUtilities.invokeLater(() -> {
            MainFrame menu = new MainFrame();
            menu.setVisible(true);
        });
    }
}
