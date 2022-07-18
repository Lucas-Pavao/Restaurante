package br.recife.ifpe.restaurante.repository;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.recife.ifpe.restaurante.entities.Adm;


public final class AdmRep implements GenericRepository<Adm, String> {

	protected AdmRep() {}

	@Override
	public void create(Adm a) {

		String sql = "insert into tbl_adm(cpf,nome,telefone,email,senha) values(?,?,?,?,?)";

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);
			pstm.setString(1, a.getCpf());
			pstm.setString(2, a.getNome());
			pstm.setString(3, a.getTelefone());
			pstm.setString(4, a.getEmail());
			pstm.setString(5, a.getSenha());

			pstm.execute();

		} catch (SQLException ex) {
			Logger.getLogger(AdmRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(AdmRep.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public void update(Adm a) {

		String sql = "update tbl_adm set nome = ? , telefone = ?, email = ? , senha = ?" + "where cpf = ? ";

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			pstm.setString(1, a.getNome());
			pstm.setString(2, a.getTelefone());
			pstm.setString(3, a.getEmail());
			pstm.setString(4, a.getSenha());
			pstm.setString(5, a.getCpf());

			pstm.execute();

		} catch (SQLException ex) {
			Logger.getLogger(AdmRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(AdmRep.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public Adm read(String i) {
		String sql = "select * from tbl_adm where cpf=?";

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			pstm.setString(1, i);

			ResultSet result = pstm.executeQuery();

			if (result.next()) {
				Adm a = new Adm();
				a.setCpf(i);
				a.setNome(result.getString("nome"));
				a.setTelefone(result.getString("telefone"));
				a.setEmail(result.getString("email"));
				a.setSenha(result.getString("senha"));

				return a;
			}

		} catch (SQLException ex) {
			Logger.getLogger(AdmRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(AdmRep.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}

	@Override
	public void delete(String i) {
		String sql = "delete from tbl_adm where cpf = ?";

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);
			pstm.setString(1, i);
			pstm.execute();

		} catch (SQLException ex) {
			Logger.getLogger(AdmRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(AdmRep.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public List<Adm> readAll() {
		String sql = "select * from tbl_adm";

		List<Adm> adms = new ArrayList<>();

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			ResultSet result = pstm.executeQuery();

			while (result.next()) {
				Adm a = new Adm();
				a.setCpf(result.getString("cpf"));
				a.setNome(result.getString("nome"));
				a.setTelefone(result.getString("telefone"));
				a.setEmail(result.getString("email"));
				a.setSenha(result.getString("Senha"));

				adms.add(a);
			}

		} catch (SQLException ex) {
			Logger.getLogger(AdmRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(AdmRep.class.getName()).log(Level.SEVERE, null, ex);
		}

		return adms;
	}

	public static Adm Login(String email, String senha) {
		String sql = "select * from tbl_adm where email = ? and senha = ?";

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			pstm.setString(1, email);
			pstm.setString(2, senha);

			ResultSet result = pstm.executeQuery();

			if (result.next()) {
				Adm a = new Adm();
				a.setEmail(result.getString("email"));
				a.setSenha(result.getString("senha"));
				return a;

			}

		} catch (SQLException ex) {
			Logger.getLogger(ClienteRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteRep.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}

}
