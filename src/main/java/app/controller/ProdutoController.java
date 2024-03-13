package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Produto;
import app.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService prodservice;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Produto prod) {
	
		try {	
			
			String mensagem = this.prodservice.save(prod);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
			
		} catch (Exception e) {	
			
			return new ResponseEntity<String>("erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Produto produto, @PathVariable long id) {
		
		try {
			
			String mensagem = this.prodservice.update(produto, id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Produto>> listAll (){
		
		try {
			
			List<Produto> lista = this.prodservice.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		
		try {
			
			String mensagem = this.prodservice.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Produto> findById(@PathVariable long id){
		
		try {
			
			Produto produto = this.prodservice.findById(id);
			return new ResponseEntity<>(produto, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/findByNome")
	public ResponseEntity<List<Produto>> findByNome (@RequestParam String nome){
		
		try {
			
			List<Produto> lista = this.prodservice.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	@GetMapping("/buscarProdutosAcimaValor")
    public ResponseEntity<List<Produto>> buscarProdutoAcimaValor (@RequestParam int valor){

        try {

            List<Produto> lista = this.prodservice.buscarProdutoAcimaValor(valor);
            return new ResponseEntity<>(lista, HttpStatus.OK);
 
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }

    }
	
	@GetMapping("/findbycategoria")
	public ResponseEntity<List<Produto>> findByCategoria (@RequestParam String categoria){
		
		try {
			
			List<Produto> lista = this.prodservice.findByCategoria(categoria);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	

}
