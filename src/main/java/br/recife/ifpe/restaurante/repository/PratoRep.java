package br.recife.ifpe.restaurante.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.recife.ifpe.restaurante.entities.Prato;

public final class PratoRep implements GenericRepository<Prato, Integer>{
	
	protected PratoRep() {
		
	}

	@Override
	public void create(Prato p) {
		String sql = "insert into tbl_prato(id, nome, descricao, preco) values (?,?,?,?)";
        
        try {
            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
            
            pstm.setInt(1, p.getId());
            pstm.setString(2, p.getNome());
            pstm.setString(3, p.getDescricao());
            pstm.setDouble(4, p.getPreco());
            
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(PratoRep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PratoRep.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	@Override
	public void update(Prato p) {
String sql = "update tbl_prato set nome = ?, descricao = ?, preco = ? where id = ?";
        
        try {
            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
            
            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getDescricao());
            pstm.setDouble(3, p.getPreco());
            pstm.setInt(4, p.getId());
            
            pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(PratoRep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PratoRep.class.getName()).log(Level.SEVERE, null, ex);
        }	
		
	}

	@Override
	public Prato read(Integer i) {
		String sql = "select * from tbl_prato where id = ?";
        
        try {
            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
                    .prepareStatement(sql);
            
            pstm.setInt(1, i);
            
            ResultSet r = pstm.executeQuery();
            
            if(r.next()){
           	                
                Prato p = new Prato();
                
                p.setId(r.getInt("id"));
                p.setNome(r.getString("nome"));
                p.setDescricao(r.getString("descricao"));
                p.setPreco(r.getDouble("preco"));
                               
                return p;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PratoRep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PratoRep.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public void delete(Integer i) {
		 String sql = "delete from tbl_prato where id = ?";
	        
	        try {
	            
	            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
	            pstm.setInt(1, i);      
	            pstm.execute();
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(PratoRep.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(PratoRep.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}

	@Override
	public List<Prato> readAll() {
		 String sql = "select * from tbl_prato";
	        
	        List<Prato> pratos = new ArrayList<>();
	        
	        try {
	            
	            PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
	                    .prepareStatement(sql);
	            
	            ResultSet r = pstm.executeQuery();
	            
	            while(r.next()){
	                
	                Prato p = new Prato();

	                p.setId(r.getInt("id"));
	                p.setNome(r.getString("nome"));
	                p.setDescricao(r.getString("descricao"));
	                p.setPreco(r.getDouble("preco"));
	                
	                pratos.add(p);	                
	            }
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(PratoRep.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(PratoRep.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        
	        return pratos;
	}

}
