package com.fabiodc.cursocm.domain;

import java.util.Date;

import com.fabiodc.cursocm.domain.enums.EstadoPagamento;

import jakarta.persistence.Entity;

@Entity
public class PagamentoComBoleto extends Pagamento{
    
	private static final long serialVersionUID = 1L;

	
	private Date dataVencimento;
	private Date dataPagamento;
	public PagamentoComBoleto() {
		
	}
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagmento) {
		super(id, estado, pedido);
	    this.dataPagamento = dataPagmento;
	    this.dataVencimento =dataVencimento;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
}
