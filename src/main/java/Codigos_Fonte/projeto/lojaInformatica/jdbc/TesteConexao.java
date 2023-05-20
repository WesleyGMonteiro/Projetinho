/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigos_Fonte.projeto.lojaInformatica.jdbc;


import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author wesleygomesmonteiro
 */
public class TesteConexao {
    
    public static void main(String[] args) throws SQLException {
        
        try {
            
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com SUICO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
}
