package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
		venda.setId(1L);
		venda.setValorTotal(300);
		venda.setEnderecoEntrega("rua");
		venda.setStatus("ok");
		venda.setData("2202255");
		
		Optional<Venda> vendaOp = Optional.of(venda);
		list.add(venda);
		
		VendaRepository moc = spy(VendaRepository.class);
		
		when(this.vendarepository.save(venda)).thenReturn(venda);
		when(this.vendarepository.findAll()).thenReturn(list);
		when(this.vendarepository.findById(1L)).thenReturn(vendaOp);
		when(this.vendarepository.findByData("2202255")).thenReturn(list);
		when(this.vendarepository.findByEnderecoEntrega("rua")).thenReturn(list);
		when(this.vendarepository.buscarVendasAcimaValor(300)).thenReturn(list);
		doNothing().when(moc).delete(venda);
		
		}
	
	@Test
	@DisplayName("SAVE")
	void savetest() {
		Venda venda = new Venda();
		venda.setId(1L);
		venda.setValorTotal(300);
		venda.setEnderecoEntrega("rua");
		venda.setStatus("ok");
		venda.setData("2202255");
		
		ResponseEntity<String> response = this.vendacontroller.save(venda);
		String msg = response.getBody();
		
		assertEquals("Venda salva com sucesso.", msg);
		
		
	}
	
	@Test
	@DisplayName("findALL")
		void findalltest() {
			ResponseEntity<List<Venda>> response = this.vendacontroller.listAll();
			List<Venda> lista = response.getBody();
			
			assertEquals(1, lista.size());
	}
		
	@Test
	@DisplayName("findById()")
	void findidteste() {
		ResponseEntity<Venda> response = this.vendacontroller.findById(1L);
		Venda obj = response.getBody();
		
		assertEquals(300, obj.getValorTotal());
	}
	
	
}
