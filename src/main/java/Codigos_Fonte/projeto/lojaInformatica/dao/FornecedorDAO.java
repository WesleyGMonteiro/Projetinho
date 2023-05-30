/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigos_Fonte.projeto.lojaInformatica.dao;

import Codigos_Fonte.projeto.lojaInformatica.jdbc.ConnectionFactory;
import Codigos_Fonte.projeto.lojaInformatica.model.Fornecedor;
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
public class FornecedorDAO {
    
    // Método para conectar com banco de dados
    private Connection con;
    
    public FornecedorDAO(){
        try {
           this.con = new ConnectionFactory().getConnection(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    //Método cadastrar Fornecedores
    public void cadastrarFornecedor(Fornecedor obj){
        
        try {
            
            //1 Passo - Criar comando SQL
            String sql = "insert into tb_fornecedores(nome, cnpj, email, telefone, "
                    + "celular, cep, endereco, numero, complemento, bairro, cidade, estado) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            //2 Passo - Conectar ao banco de dados e organizar o comando SQL
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getCnpj());
            stm.setString(3, obj.getEmail());
            stm.setString(4, obj.getCelular());
            stm.setString(5, obj.getCelular2());
            stm.setString(6, obj.getCep());
            stm.setString(7, obj.getEndereco());
            stm.setInt(8,obj.getNumero());
            stm.setString(9, obj.getComplemento());
            stm.setString(10, obj.getBairro());
            stm.setString(11, obj.getCidade());
            stm.setString(12, obj.getEstado());
            
            //3 Passo - Executar o comando sql
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    // Método EXCLUIR Fornecedor
    public void excluirFornecedor(Fornecedor obj){
        
        try {
            
            //1 Passo - Criar comando SQL
            String sql = "delete from tb_fornecedores where id = ?";
            
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
    
    // Método ALTERAR Fornecedor
    public void alterarFornecedor(Fornecedor obj){
        
        try {
            
            //1 Passo - Criar comando SQL
            String sql = "update tb_fornecedores set nome=?, cnpj=?, email=?, telefone=?, "
                    + "celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";
            
            //2 Passo - Conectar ao banco de dados e organizar o comando SQL
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getCnpj());
            stm.setString(3, obj.getEmail());
            stm.setString(4, obj.getCelular());
            stm.setString(5, obj.getCelular2());
            stm.setString(6, obj.getCep());
            stm.setString(7, obj.getEndereco());
            stm.setInt(8,obj.getNumero());
            stm.setString(9, obj.getComplemento());
            stm.setString(10, obj.getBairro());
            stm.setString(11, obj.getCidade());
            stm.setString(12, obj.getEstado());
            
            stm.setInt(13, obj.getId());
            
            //3 Passo - Executar o comando sql
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    //Método Listar TODOS os Fornecedores
    public List<Fornecedor> ListarFornecedores(){
        
        try {
            
            //1Passo Criar a Lista
            List<Fornecedor> lista = new ArrayList<>();
            
            //2Passo Criar o comando sql, organizar e executar
            String sql = "select * from tb_fornecedores";
            
            PreparedStatement stm = con.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Fornecedor obj = new Fornecedor();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("telefone"));
                obj.setCelular2(rs.getString("celular"));
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
    
    // Método listar Fornecedores por nome
    public List<Fornecedor> pesquisaFornecedoresNome(String nome){
        
        try {
            
            //1Passo Criar a Lista
            List<Fornecedor> lista = new ArrayList<>();
            
            //2Passo Criar o comando sql, organizar e executar
            String sql = "select * from tb_fornecedores where nome like ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, nome);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Fornecedor obj = new Fornecedor();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("telefone"));
                obj.setCelular2(rs.getString("celular"));
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
    
    // Método para pesquisar Fornecedores pelo CNPJ
    public Fornecedor consultaPorCnpj(String cnpj){
        
        try {
            
            //1 Passo Criar o comando sql, organizar e executar
            String sql = "select * from tb_fornecedores where cnpj = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, cnpj);
            
            ResultSet rs = stm.executeQuery();
            
            Fornecedor obj = new Fornecedor();
            
            if(rs.next()){
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("telefone"));
                obj.setCelular2(rs.getString("celular"));
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
}
