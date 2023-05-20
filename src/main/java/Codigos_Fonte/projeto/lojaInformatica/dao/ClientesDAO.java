/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigos_Fonte.projeto.lojaInformatica.dao;

import Codigos_Fonte.projeto.lojaInformatica.jdbc.ConnectionFactory;
import Codigos_Fonte.projeto.lojaInformatica.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author wesleygomesmonteiro
 */
public class ClientesDAO {
    
    private Connection con;
    
    public ClientesDAO() throws SQLException, ClassNotFoundException{
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Método cadastrar cliente
    public void cadastrarCliente(Clientes obj){
        
        try {
            
            //1 Passo - Criar comando SQL
            String sql = "insert into tb_clientes(nome, sobrenome, sexo, rg, cpf, email, celular, "
                    + "celular2, cep, endereco, numero, complemento, bairro, cidade, estado) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            //2 Passo - Conectar ao banco de dados e organizar o comando SQL
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getSobrenome());
            stm.setString(3,obj.getSexo());
            stm.setString(4, obj.getRg());
            stm.setString(5, obj.getCpf());
            stm.setString(6, obj.getEmail());
            stm.setString(7, obj.getCelular());
            stm.setString(8, obj.getCelular2());
            stm.setString(9, obj.getCep());
            stm.setString(10, obj.getEndereco());
            stm.setInt(11, obj.getNumero());
            stm.setString(12, obj.getComplemento());
            stm.setString(13, obj.getBairro());
            stm.setString(14, obj.getCidade());
            stm.setString(15, obj.getEstado());
            
            //3 Passo - Executar o comando sql
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    //Método Alterar Cliente
    public void alterarCliente(Clientes obj){
        
    }
    
    //Método Excluir Cliente
    public void excluirCliente(){
        
    }
}
