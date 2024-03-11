package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Funcionario;
import app.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	 public Produto findById(long id);
	 
	 public List<Produto> findByNome(String nome);
	 
		@Query("FROM Produto p WHERE p.valor > :valor")
	    public List<Produto> buscarProdutoAcimaValor(int valor);
	
}
