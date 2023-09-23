/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public int cadastrarProduto (ProdutosDTO produto){
        int status;
        conn = new conectaDAO().connectDB(); 
        try{
            
            
            prep = conn.prepareStatement ("INSERT INTO produtos VALUES (?,?,?,?)");
            
            prep.setInt(1, produto.getId());
            prep.setString(2, produto.getNome());
            prep.setInt(3, produto.getValor());
            prep.setString(4, produto.getStatus());
            
            status = prep.executeUpdate();
            return status;
        }
        catch(SQLException ex){
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
        
      
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        PreparedStatement st1;
        ResultSet rs1;
        try{
            ArrayList<ProdutosDTO> listaProdutos = new ArrayList<>();
            while(rs1.next()){
                ProdutosDTO produto = new ProdutosDTO();
                
                produto.setId(ResultSet.getInt("id"));
                produto.setNome(ResultSet.getString("nome"));
                produto.setValor(ResultSet.getInt("valor"));
                produto.setStatus(ResultSet.getString("status"));
                
                listaProdutos.add(produto);
            }
            return listaProdutos;
        }
        catch(Exception e){
            return null
        }

        
        //return listagem;
    }

    void venderProduto(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //acessa o banco de dados e muda o status pra "vendido"
    }
    
    void listarProdutosVendidos(int idProduto){
        
    }
    
    
    
        
}

