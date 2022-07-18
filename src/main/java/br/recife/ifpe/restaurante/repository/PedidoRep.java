package br.recife.ifpe.restaurante.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.recife.ifpe.restaurante.entities.Cliente;
import br.recife.ifpe.restaurante.entities.Pagamento;
import br.recife.ifpe.restaurante.entities.Pedido;
import br.recife.ifpe.restaurante.entities.Prato;

public final class PedidoRep implements GenericRepository<Pedido, Integer> {

	protected PedidoRep() {

	}

	@Override
	public void create(Pedido p) {
		String sql = "insert into tbl_pedido(datahora, preco, observacao,"
				+ "id_cliente, id_prato, id_pagamento) values (?,?,?,?,?,?)";

		try {
			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			pstm.setLong(1, p.getDatahora());
			pstm.setDouble(2, p.getPreco());
			pstm.setString(3, p.getObservacao());
			pstm.setString(4, p.getCliente().getCpf());
			pstm.setInt(5, p.getPrato().getId());
			pstm.setInt(6, p.getPagamento().getId());

			pstm.execute();

		} catch (SQLException ex) {
			Logger.getLogger(PedidoRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PedidoRep.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public void update(Pedido p) {
		String sql = "update tbl_pedido set datahora = ?, preco = ?, " + "observacao = ? where id = ? ";

		try {
			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			pstm.setLong(1, p.getDatahora());
			pstm.setDouble(2, p.getPreco());
			pstm.setString(3, p.getObservacao());

			pstm.setInt(4, p.getId());

			pstm.execute();

		} catch (SQLException ex) {
			Logger.getLogger(PedidoRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PedidoRep.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public Pedido read(Integer i) {

		String sql = "select * from tbl_pedido as v join cliente as c join prato as m join pagamento as p"
				+ "on (v.cpf_cliente = c.cpf and v.id_prato = m.id and v.id_pagamento = p.id) where v.id = ?";

		try {
			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			pstm.setInt(1, i);

			ResultSet r = pstm.executeQuery();

			if (r.next()) {

				Cliente c = new Cliente();
				c.setCpf(r.getString("id"));
				c.setNome(r.getString("nome"));
				c.setTelefone(r.getString("telefone"));
				c.setEmail(r.getString("email"));
				c.setSenha(r.getString("senha"));

				Prato pr = new Prato();
				pr.setId(r.getInt("id"));
				pr.setNome(r.getString("nome"));
				pr.setDescricao(r.getString("descricao"));
				pr.setPreco(r.getDouble("preco"));

				Pagamento pa = new Pagamento();
				pa.setId(r.getInt("id"));
				pa.setDescricao(r.getString("descricao"));

				Pedido pe = new Pedido();

				pe.setId(r.getInt("id"));
				pe.setDatahora(r.getLong("datahora"));
				pe.setPreco(r.getDouble("preco"));
				pe.setObservacao(r.getString("observacao"));

				pe.setCliente(c);
				pe.setPrato(pr);
				pe.setPagamento(pa);

				return pe;

			}

		} catch (SQLException ex) {
			Logger.getLogger(PedidoRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PedidoRep.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}

	@Override
	public void delete(Integer i) {
		String sql = "delete from tbl_pedido where id = ?";

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);
			pstm.setInt(1, i);

			pstm.execute();

		} catch (SQLException ex) {
			Logger.getLogger(PedidoRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PedidoRep.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public List<Pedido> readAll() {

		String sql = "select * from tbl_pedido";

		List<Pedido> pedidos = new ArrayList<>();

		try {

			PreparedStatement pstm = br.recife.ifpe.restaurante.dao.ConnectionManager.getCurrentConnection()
					.prepareStatement(sql);

			ResultSet r = pstm.executeQuery();

			while (r.next()) {

				Pedido p = new Pedido();

				p.setId(r.getInt("id"));
				p.setDatahora(r.getLong("datahora"));
				p.setPreco(r.getDouble("preco"));
				p.setObservacao(r.getString("observacao"));

				ClienteRep cliente = new ClienteRep();
				Cliente c = cliente.read(r.getString("cpf_cliente"));
				p.setCliente(c);

				PratoRep prato = new PratoRep();
				Prato m = prato.read(r.getInt("id_prato"));
				p.setPrato(m);

				PagamentoRep pagamento = new PagamentoRep();
				Pagamento pa = pagamento.read(r.getInt("id_pagamento"));
				p.setPagamento(pa);

				pedidos.add(p);

			}

		} catch (SQLException ex) {
			Logger.getLogger(PedidoRep.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PedidoRep.class.getName()).log(Level.SEVERE, null, ex);
		}

		return pedidos;
	}

}
