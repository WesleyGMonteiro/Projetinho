/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigos_Fonte.projeto.lojaInformatica.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author wesleygomesmonteiro
 */
public class ConnectionFactory {
    
    public Connection getConnection() throws SQLException, ClassNotFoundException{
    try{
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas?useTimezone=true&serverTimezone=UTC&useSSL=false","USUARIOCURSO","123"); 
  }catch(RuntimeException e){
        throw new RuntimeException(e);     
  }
}
}
