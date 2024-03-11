package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Produto;
import app.repository.ProdutoRepository;

public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public String save (Produto produto) {
		this.produtoRepository.save(produto);
		return produto.getNome()+ "salvo";
	}
	
	public String update( Produto produto, Long id) {
		produto.setId(id);
		this.produtoRepository.save(produto);
		return produto.getNome()+ " atualizado";
	}
	
    public String delete (long id) {
    	this.produtoRepository.deleteById(id);
		return "deletado";
    }

    public Produto findById(long id) {
    	Produto produto = this.produtoRepository.findById(id).get();
		return produto;
    }
    
	public List<Produto> listAll(){
		return this.produtoRepository.findAll();
	}
	
	public List<Produto> findByNome(String nome){
		return this.produtoRepository.findByNome(nome);
	}
	
	
	public List<Produto> buscarProdutoAcimaValor(int valor){
        return this.produtoRepository.buscarProdutoAcimaValor(valor);
    } 

}
