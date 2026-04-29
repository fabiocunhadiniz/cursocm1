package com.fabiodc.cursocm.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiodc.cursocm.domain.ItemPedido;
import com.fabiodc.cursocm.domain.PagamentoComBoleto;
import com.fabiodc.cursocm.domain.Pedido;
import com.fabiodc.cursocm.domain.enums.EstadoPagamento;
import com.fabiodc.cursocm.repositories.ItemPedidoRepository;
import com.fabiodc.cursocm.repositories.PagamentoRepository;
import com.fabiodc.cursocm.repositories.PedidoRepository;
import com.fabiodc.cursocm.repositories.ProdutoRepository;
import com.fabiodc.cursocm.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService{

    private final ProdutoRepository produtoRepository_1;
	@Autowired
    private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
    PedidoService(ProdutoRepository produtoRepository_1) {
        this.produtoRepository_1 = produtoRepository_1;
    }
	
	
	
	public Pedido find(Integer id){
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> 
	    new ObjectNotFoundException(
	        "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()
	    )
	);
	}
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());

		for(ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(
					produtoRepository
					.findById(ip.getProduto().getId())
					.orElseThrow(() -> new RuntimeException("Produto não encontrado"))
					.getPreco()
					);
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}
}
