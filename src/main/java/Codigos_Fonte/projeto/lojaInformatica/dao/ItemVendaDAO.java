/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigos_Fonte.projeto.lojaInformatica.dao;

import Codigos_Fonte.projeto.lojaInformatica.jdbc.ConnectionFactory;
import Codigos_Fonte.projeto.lojaInformatica.model.Cliente;
import Codigos_Fonte.projeto.lojaInformatica.model.ItemVenda;
import Codigos_Fonte.projeto.lojaInformatica.model.Produto;
import Codigos_Fonte.projeto.lojaInformatica.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author wesleygomesmonteiro
 */
public class ItemVendaDAO {
    
    private Connection con;
    
    public ItemVendaDAO(){
        try {
           this.con = new ConnectionFactory().getConnection(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void cadastrarVenda(ItemVenda obj){
        
        try {
            
            //1 Passo - Criar comando SQL
            String sql = "insert into tb_itensvendas(venda_id, produto_id, qtd, subtotal) values (?, ?, ?, ?)";
            
            //2 Passo - Conectar ao banco de dados e organizar o comando SQL
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, obj.getVenda().getId());
            stm.setInt(2, obj.getProduto().getId());
            stm.setInt(3, obj.getQtd());
            stm.setDouble(4, obj.getSubtotal());
            
            
            //3 Passo - Executar o comando sql
            stm.execute();
            stm.close();
            
            System.out.println("Foi Deu BOM");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    // Método que lista itens de uma venda por id
    public List<ItemVenda> ListarItensPorVenda(int venda_id){
        
        try {
            
            // 1 Passo criar Lista
            List<ItemVenda> lista = new ArrayList<>();
            
            // 2 Passo - Criar o sql, organizar e executar
            String sql = "select i.id, p.descricao, i.qtd, p.preco, i.subtotal from tb_itensvendas as i "
                    + " inner join tb_produtos as p on(i.produto_id = p.id) where i.venda_id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, venda_id);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                ItemVenda item = new ItemVenda();
                Produto prod = new Produto();
                
                item.setId(rs.getInt("i.id"));
                prod.setDescricao(rs.getString("p.descricao"));
                item.setQtd(rs.getInt("i.qtd"));
                prod.setPreco(rs.getDouble("p.preco"));
                item.setSubtotal(rs.getDouble("i.subtotal"));
                
                item.setProduto(prod);
                
                lista.add(item);
            }
            
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }    
    }
}
