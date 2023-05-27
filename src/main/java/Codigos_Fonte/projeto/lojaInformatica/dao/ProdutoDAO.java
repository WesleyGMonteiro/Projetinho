/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigos_Fonte.projeto.lojaInformatica.dao;

import Codigos_Fonte.projeto.lojaInformatica.jdbc.ConnectionFactory;
import Codigos_Fonte.projeto.lojaInformatica.model.Fornecedor;
import Codigos_Fonte.projeto.lojaInformatica.model.Produto;
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
public class ProdutoDAO {
    
     private Connection con;
    
    public ProdutoDAO(){
        try {
           this.con = new ConnectionFactory().getConnection(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    // Método para CADASTRAR Produtos
    public void cadastrar(Produto obj){
        
        try {
            String sql = "insert into tb_produtos(descricao, preco, qtd_estoque, for_id) values (?, ?, ?, ?)";
            
            // 2 Passo - Conectar ao banco de dados e organizar o comando sql
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, obj.getDescricao());
            stm.setDouble(2, obj.getPreco());
            stm.setInt(3, obj.getQtd_estoque());
            stm.setInt(4, obj.getFornecedor().getId());
            
            // 3 Passo Executar comando
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }
    }
    
    public List<Produto> listarProdutos(){
        
        try {
            
            // 1 Passo criar Lista
            List<Produto> lista = new ArrayList<>();
            
            // 2 Passo - Criar o sql, organizar e executar
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on(p.for_id = f.id)";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Produto obj = new Produto();
                Fornecedor f = new Fornecedor();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }    
    }
    
    public void alterar(Produto obj){
        
        try {
            String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=?, for_id=? where id=?";
            
            // 2 Passo - Conectar ao banco de dados e organizar o comando sql
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, obj.getDescricao());
            stm.setDouble(2, obj.getPreco());
            stm.setInt(3, obj.getQtd_estoque());
            
            stm.setInt(4, obj.getFornecedor().getId());
            
            stm.setInt(5, obj.getId());
            
            // 3 Passo Executar comando
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }
    }
    
    public void excluir(Produto obj){
        
        try {
            String sql = "delete from tb_produtos where id=?";
            
            // 2 Passo - Conectar ao banco de dados e organizar o comando sql
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, obj.getId());
            
            // 3 Passo Executar comando
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }
    }
    
    public List<Produto> buscaProdutosPorNome(String nome){
        
        try {
            
            // 1 Passo criar Lista
            List<Produto> lista = new ArrayList<>();
            
            // 2 Passo - Criar o sql, organizar e executar
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on(p.for_id = f.id) where p.descricao like ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, nome);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Produto obj = new Produto();
                Fornecedor f = new Fornecedor();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }    
    }
}
