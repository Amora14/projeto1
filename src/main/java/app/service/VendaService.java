package app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Venda;
import app.repository.VendaRepository;
import app.entity.Produto;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	public String save (Venda venda) {
		double valorsoma = this.calcularvalor(venda.getProdutos());
		venda.setValorTotal(valorsoma);		
		
		this.vendaRepository.save(venda);
		return venda.getId()+ " salvo com sucesso";
	}
	
	public double calcularvalor(List<Produto> produto) {
		double soma =0;
		if(produto != null )
			for (int i=0; i<produto.size(); i ++) {
				soma += produto.get(i).getValor(); 
			}
		return soma;
	}
	
	public String update(Venda venda, long id) {
		venda.setId(id);double valorTotal = this.calcularvalor(venda.getProdutos());
		venda.setValorTotal(valorTotal);
				
		this.vendaRepository.save(venda);
		return venda.getId()+ " salvo com sucesso";
	}
	
	public String delete (long id) {
		this.vendaRepository.deleteById(id);
		return "Venda deletada com sucesso";
	}
	
	public List<Venda> listAll(){
		return this.vendaRepository.findAll();
	}
	
	public Venda findById(long id) {
		Venda venda = this.vendaRepository.findById(id).get();
		return venda;
	}
	
	public List<Venda> findByEnderecoEntrega(String enderecoEntrega){
		return this.vendaRepository.findByEnderecoEntrega(enderecoEntrega);
	}
	
	public List<Venda> findByData(String data){
		return this.vendaRepository.findByData(data);
	}
	
	public List<Venda> buscarVendasAcimaValor(int valor){
		return this.vendaRepository.buscarVendasAcimaValor(valor);
	}
	
	public Venda verificarstatus(Venda venda) {
		if(venda.getStatus().equals("CANCELADO")) {
			venda.setValorTotal(0);
			venda.setProdutos(null);
		}
		return venda;
	}
	
}
