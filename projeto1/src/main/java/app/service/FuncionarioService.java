package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import app.entity.Funcionario;
import app.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	
	public String save (Funcionario funcionario) {
		this.funcionarioRepository.save(funcionario);
		return funcionario.getNome()+ "salvo";
	}
	
	public String update( Funcionario funcionario, long id) {
		funcionario.setId(id);
		this.funcionarioRepository.save(funcionario);
		return funcionario.getNome()+ " atualizado";
	}
	
    public String delete (long id) {
    	this.funcionarioRepository.deleteById(id);
		return "deletado";
    }

    public Funcionario findById(long id) {
    	Funcionario funcionario = this.funcionarioRepository.findById(id).get();
		return funcionario;
    }
    
	public List<Funcionario> listAll(){
		return this.funcionarioRepository.findAll();
	}
	
	public List<Funcionario> findByNome(String nome){
		return this.funcionarioRepository.findByNome(nome);
	}
	
	public List<Funcionario> findByMatricula(int matricula){
		return this.funcionarioRepository.findByMatricula(matricula);
	}
	
	public List<Funcionario> buscarFuncionarioAcimaIdade(int idade){
        return this.funcionarioRepository.buscarFuncionarioAcimaIdade(idade);
    } 

	
}
