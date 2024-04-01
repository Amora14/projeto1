package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.entity.Produto;
import app.entity.Venda;

@SpringBootTest
public class VendaServiceTest {
	
	@Autowired
	VendaService vendaService;
	
	@Test
	@DisplayName("teste de unidade valor total")
	void calculartest() {
		List<Produto> lista = new ArrayList<>();
		 
		Produto produto= new Produto();
		produto.setNome("produto1");
		produto.setValor(100);
		
		lista.add(produto);
		
		produto.setNome("produto2");
		produto.setValor(100);
		
		lista.add(produto);
		
		
		double soma = this.vendaService.calcularvalor(lista);
		assertEquals(200, soma);
		
	}
	/*
	@Test
	@DisplayName("teste exception")	
	void exception() {
		assertThrows(Exception.class,
				()->{double soma= this.vendaService.calcularvalor(null);});
	}
	*/
	
	@Test
	@DisplayName("teste de cancelamento")
	void verificars() {
		Venda venda =new Venda();
		venda.setProdutos(null);
		venda.setValorTotal(0);
		venda.setStatus("CANCELADO");
		
	
		assertEquals(0, this.vendaService.calcularvalor(venda.getProdutos()));
	}
/*	
	@Test
	@DisplayName("teste exception")	
	void exception() {
		assertThrows(Exception.class,
				()->{string valid= this.vendaService.verificarstatus(null); });
	}
	*/
	
}
