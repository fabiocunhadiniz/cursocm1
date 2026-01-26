package com.fabiodc.cursocm.domain;

import java.util.Date;

import com.fabiodc.cursocm.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;

@Entity
public class PagamentoComBoleto extends Pagamento{
    
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy" )
	private Date dataVencimento;
	
	@JsonFormat(pattern = "dd/MM/yyyy" )
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
