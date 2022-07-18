package br.recife.ifpe.restaurante.repository;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.recife.ifpe.restaurante.entities.Cliente;

public final class ClienteRep implements GenericRepository<Cliente, String> {

	protected ClienteRep() {
	}

	@Override
	public void create(Cliente c) {

		String sql = "insert into tbl_cliente(cpf,nome,telefone,email,senha) values(?,?,?,?,?)";

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);
			pstm.setString(1, c.getCpf());
			pstm.setString(2, c.getNome());
			pstm.setString(3, c.getTelefone());
			pstm.setString(4, c.getEmail());
			pstm.setString(5, c.getSenha());

			pstm.execute();

		} catch (SQLException ex) {
			Logger.getLogger(ClienteRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteRep.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public void update(Cliente c) {

		String sql = "update tbl_cliente set nome = ? , telefone = ? , email = ? , senha = ?" + "where cpf = ? ";

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			pstm.setString(1, c.getNome());
			pstm.setString(2, c.getTelefone());
			pstm.setString(3, c.getEmail());
			pstm.setString(4, c.getSenha());
			pstm.setString(5, c.getCpf());

			pstm.execute();

		} catch (SQLException ex) {
			Logger.getLogger(ClienteRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteRep.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public Cliente read(String i) {
		String sql = "select * from tbl_cliente where cpf=?";

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			pstm.setString(1, i);

			ResultSet result = pstm.executeQuery();

			if (result.next()) {
				Cliente c = new Cliente();
				c.setCpf(i);
				c.setNome(result.getString("nome"));
				c.setTelefone(result.getString("telefone"));
				c.setEmail(result.getString("email"));
				c.setSenha(result.getString("senha"));

				return c;
			}

		} catch (SQLException ex) {
			Logger.getLogger(ClienteRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteRep.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}

	@Override
	public void delete(String i) {
		String sql = "delete from tbl_cliente where cpf = ?";

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);
			pstm.setString(1, i);
			pstm.execute();

		} catch (SQLException ex) {
			Logger.getLogger(ClienteRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteRep.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public List<Cliente> readAll() {
		String sql = "select * from tbl_cliente";

		List<Cliente> clientes = new ArrayList<>();

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			ResultSet result = pstm.executeQuery();

			while (result.next()) {
				Cliente c = new Cliente();
				c.setCpf(result.getString("cpf"));
				c.setNome(result.getString("nome"));
				c.setTelefone(result.getString("telefone"));
				c.setEmail(result.getString("email"));
				c.setSenha(result.getString("Senha"));

				clientes.add(c);
			}

		} catch (SQLException ex) {
			Logger.getLogger(ClienteRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteRep.class.getName()).log(Level.SEVERE, null, ex);
		}

		return clientes;

	}

	public static Cliente Login(String email, String senha) {
		String sql = "select * from tbl_cliente where email = ? and senha = ?";

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			pstm.setString(1, email);
			pstm.setString(2, senha);

			ResultSet result = pstm.executeQuery();

			if (result.next()) {
				Cliente c = new Cliente();
				c.setEmail(result.getString("email"));
				c.setSenha(result.getString("senha"));
				return c;

			}

		} catch (SQLException ex) {
			Logger.getLogger(ClienteRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteRep.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}

}
