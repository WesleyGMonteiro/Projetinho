/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigos_Fonte.projeto.lojaInformatica.dao;

import Codigos_Fonte.projeto.lojaInformatica.jdbc.ConnectionFactory;
import Codigos_Fonte.projeto.lojaInformatica.model.Cliente;
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
public class VendaDAO {
    
     private Connection con;
    
    public VendaDAO(){
        try {
           this.con = new ConnectionFactory().getConnection(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // Cadastrar Venda
    public void cadastrarVenda(Venda obj){
        
        try {
            
            //1 Passo - Criar comando SQL
            String sql = "insert into tb_vendas(cliente_id, data_venda, total_venda, observacoes) values (?, ?, ?, ?)";
            
            //2 Passo - Conectar ao banco de dados e organizar o comando SQL
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, obj.getCliente().getId());
            stm.setString(2, obj.getData_venda());
            stm.setDouble(3, obj.getTotal_venda());
            stm.setString(4, obj.getObs());
            
            
            //3 Passo - Executar o comando sql
            stm.execute();
            stm.close();
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            System.out.println("Erro: " + e);
        }
    }
    
    
    
    // Retorna a última Venda
    public int retornaUltimaVenda(){
        try {
            int idVenda = 0;
            
            String sql = "select max(id) id from tb_vendas"; // Traz o maior id, no caso a última venda feita
            PreparedStatement stm = con.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                Venda p = new Venda();
                
                p.setId(rs.getInt("id"));
                
                idVenda = p.getId();
            }
            return idVenda;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    // Método que filtra vendas por datas
    public List<Venda> ListarVendasPorPeriodo(LocalDate data_inicio, LocalDate data_fim){
        
        try {
            
            // 1 Passo criar Lista
            List<Venda> lista = new ArrayList<>();
            
            // 2 Passo - Criar o sql, organizar e executar
            String sql = "select v.id, date_format(v.data_venda, '%d/%m/%Y') as data_formatada, c.nome, v.total_venda, v.observacoes from tb_vendas as v "
                    + " inner join tb_clientes as c on(v.cliente_id = c.id) where v.data_venda BETWEEN ? AND ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, data_inicio.toString());
            stm.setString(2, data_fim.toString());
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Venda obj = new Venda();
                Cliente c = new Cliente();
                
                obj.setId(rs.getInt("v.id"));
                obj.setData_venda(rs.getString("data_formatada"));
                c.setNome(rs.getString("c.nome"));
                obj.setTotal_venda(rs.getDouble("v.total_venda"));
                obj.setObs(rs.getString("v.observacoes"));
                
                obj.setCliente(c);
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }    
    }
    
    //Método que calcula total de venda por data
    public double retornTotalVendaPorData(LocalDate data_venda){
        
        try {
            
            double totalVenda = 0;
            
            String sql = "select sum(total_venda) as total from tb_vendas where data_venda = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, data_venda.toString());
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                totalVenda = rs.getDouble("total");
            }
            return totalVenda;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
