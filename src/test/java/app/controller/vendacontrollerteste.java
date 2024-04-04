package app.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import app.entity.Produto;
import app.entity.Venda;
import app.repository.VendaRepository;

@SpringBootTest
public class vendacontrollerteste {

	@Autowired
	VendaController vendacontroller;
	
	@MockBean
	VendaRepository vendarepository;
	
	@BeforeEach
	void config() {
		List<Venda> list = new ArrayList<Venda>();
		List<Produto> listProd = new ArrayList<>();
		
		Venda venda = new Venda();
		venda.setId(1);
		venda.setValorTotal(300);
		venda.setEnderecoEntrega("rua");
		venda.setStatus("ok");
		venda.setData("2202255");
		
		when(this.vendarepository.save(venda)).thenReturn(venda);
		
		
		}
	
	void savetest() {
		Venda venda = new Venda();
		ResponseEntity<String> response = this.vendacontroller.save(venda);
		String msg = response.getBody();
		
		assertEquals("Venda salva com sucesso.", msg);
		
		
	}
	
}
