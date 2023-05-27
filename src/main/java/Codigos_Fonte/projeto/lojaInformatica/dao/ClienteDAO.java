/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigos_Fonte.projeto.lojaInformatica.dao;

import Codigos_Fonte.projeto.lojaInformatica.jdbc.ConnectionFactory;
import Codigos_Fonte.projeto.lojaInformatica.model.Cliente;
import Codigos_Fonte.projeto.lojaInformatica.model.WebServicesCep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author wesleygomesmonteiro
 */
public class ClienteDAO {
    
    private Connection con;
    
    public ClienteDAO(){
        try {
           this.con = new ConnectionFactory().getConnection(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    //Método cadastrar cliente
    public void cadastrarCliente(Cliente obj){
        
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
    public void alterarCliente(Cliente obj){
        
        try {
            
            //1 Passo - Criar comando SQL
            String sql = "update tb_clientes set nome=?, sobrenome=?, sexo=?, rg=?, cpf=?, email=?, celular=?, "
                    + "celular2=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";
            
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
            stm.setInt(16, obj.getId());
            
            //3 Passo - Executar o comando sql
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        
    }
    
    //Método Excluir Cliente
    public void excluirCliente(Cliente obj){
        
        try {
            
            //1 Passo - Criar comando SQL
            String sql = "delete from tb_clientes where id = ?";
            
            //2 Passo - Conectar ao banco de dados e organizar o comando SQL
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, obj.getId());
            
            //3 Passo - Executar o comando sql
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        
    }
    
    //Método Listar TODOS os clientes
    public List<Cliente> ListarCliente(){
        
        try {
            
            //1Passo Criar a Lista
            List<Cliente> lista = new ArrayList<>();
            
            //2Passo Criar o comando sql, organizar e executar
            String sql = "select * from tb_clientes";
            
            PreparedStatement stm = con.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Cliente obj = new Cliente();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setSobrenome(rs.getString("sobrenome"));
                obj.setSexo(rs.getString("sexo"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setCelular2(rs.getString("celular2"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
            return null;
        }
    }
    
    public List<Cliente> pesquisaClientesNome(String nome){
        
        try {
            
            //1Passo Criar a Lista
            List<Cliente> lista = new ArrayList<>();
            
            //2Passo Criar o comando sql, organizar e executar
            String sql = "select * from tb_clientes where nome like ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, nome);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Cliente obj = new Cliente();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setSobrenome(rs.getString("sobrenome"));
                obj.setSexo(rs.getString("sexo"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setCelular2(rs.getString("celular2"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
            return null;
        }
    }
    
    public Cliente consultaPorCpf(String cpf){
        
        try {
            
            //1 Passo Criar o comando sql, organizar e executar
            String sql = "select * from tb_clientes where cpf = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, cpf);
            
            ResultSet rs = stm.executeQuery();
            
            Cliente obj = new Cliente();
            
            if(rs.next()){
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setSobrenome(rs.getString("sobrenome"));
                obj.setSexo(rs.getString("sexo"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setCelular2(rs.getString("celular2"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
            }
            return obj;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            return null;
        }
    }
    
    //Busca por CEP
    
    public Cliente buscaCep(String cep) {
       
        WebServicesCep webServiceCep = WebServicesCep.searchCep(cep);
       

        Cliente obj = new Cliente();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setEstado(webServiceCep.getEstado());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "DescriÁ„o do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
}
