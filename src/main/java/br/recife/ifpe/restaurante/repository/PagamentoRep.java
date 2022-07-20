package br.recife.ifpe.restaurante.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.recife.ifpe.restaurante.entities.Pagamento;

public final class PagamentoRep implements GenericRepository<Pagamento, Integer> {

	protected PagamentoRep() {

	}

	@Override
	public void create(Pagamento p) {
		String sql = "insert into tbl_pagamento(id_pagamento, descricao) values (?,?)";

		try {
			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			pstm.setInt(1, p.getId());
			pstm.setString(2, p.getDescricao());

			pstm.execute();

		} catch (SQLException ex) {
			Logger.getLogger(PagamentoRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PagamentoRep.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public void update(Pagamento p) {
		String sql = "update tbl_pagamento set descricao = ? where id_pagamento = ?";

		try {
			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			pstm.setString(1, p.getDescricao());
			pstm.setInt(2, p.getId());

			pstm.execute();

		} catch (SQLException ex) {
			Logger.getLogger(PagamentoRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PagamentoRep.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public Pagamento read(Integer i) {
		String sql = "select * from tbl_pagamento where id_pagamento = ?";

		try {
			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			pstm.setInt(1, i);

			ResultSet r = pstm.executeQuery();

			if (r.next()) {

				Pagamento p = new Pagamento();

				p.setId(r.getInt("id"));
				p.setDescricao(r.getString("descricao"));

				return p;

			}

		} catch (SQLException ex) {
			Logger.getLogger(PagamentoRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PagamentoRep.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@Override
	public void delete(Integer i) {
		String sql = "delete from tbl_pagamento where id_pagamento = ?";

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);
			pstm.setInt(1, i);
			pstm.execute();

		} catch (SQLException ex) {
			Logger.getLogger(PagamentoRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PagamentoRep.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public List<Pagamento> readAll() {
		String sql = "select * from tbl_pagamento";

		List<Pagamento> pagamentos = new ArrayList<>();

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			ResultSet r = pstm.executeQuery();

			while (r.next()) {

				Pagamento p = new Pagamento();

				p.setId(r.getInt("id"));
				p.setDescricao(r.getString("descricao"));

				pagamentos.add(p);
			}

		} catch (SQLException ex) {
			Logger.getLogger(PagamentoRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PagamentoRep.class.getName()).log(Level.SEVERE, null, ex);
		}

		return pagamentos;
	}

}
