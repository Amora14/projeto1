package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Funcionario;
import app.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	
	public List<Venda> findByData(String data);
	
	public List<Venda> findByEnderecoEntrega(String enderecoEntrega);
	
	@Query("FROM Venda c WHERE c.valorTotal > :valor")
	public List<Venda> buscarVendasAcimaValor(int valor);
}
