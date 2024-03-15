package app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Venda;
import app.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	public String save (Venda venda) {
		this.vendaRepository.save(venda);
		return venda.getId()+ " salvo com sucesso";
	}
	
	public String update(Venda venda, long id) {
		venda.setId(id);
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
	
}
