package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

		 
	 public List<Produto> findByNome(String nome);
	 
		public List<Produto> findByCategoria(String categoria);
		
		@Query("FROM Produto p WHERE p.valor > :valor")
	    public List<Produto> buscarProdutoAcimaValor(int valor);
	
}
