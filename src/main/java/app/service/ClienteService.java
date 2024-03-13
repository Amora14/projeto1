package app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.entity.Cliente;
import app.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public String save (Cliente cliente) {
		this.clienteRepository.save(cliente);
		return cliente.getNome()+ " salvo com sucesso";
	}
	
	public String update(Cliente cliente, Long id) {
		cliente.setId(id);
		this.clienteRepository.save(cliente);
		return cliente.getNome()+ " salvo com sucesso";
	}
	
	public String delete (long id) {
		this.clienteRepository.deleteById(id);
		return "Cliente deletado com sucesso";
	}
	
	public List<Cliente> listAll(){
		return this.clienteRepository.findAll();
	}
	
	public Cliente findById(long id) {
		Cliente cliente = this.clienteRepository.findById(id).get();
		return cliente;
	}
	
	public List<Cliente> findByNome(String nome){
		return this.clienteRepository.findByNome(nome);
	}
	
	public List<Cliente> findByCpf(String cpf){
		return this.clienteRepository.findByCpf(cpf);
	}
	
	public List<Cliente> buscarClientesAcimaIdade(int idade){
		return this.clienteRepository.buscarClientesAcimaIdade(idade);
	}
	
	
	
}
