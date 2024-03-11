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

import app.entity.Funcionario;
import app.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funservice;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Funcionario fun) {
	
		try {	
			
			String mensagem = this.funservice.save(fun);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
			
		} catch (Exception e) {	
			
			return new ResponseEntity<String>("erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Funcionario fun, @PathVariable long id) {
		
		try {
			
			String mensagem = this.funservice.update(fun, id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Funcionario>> listAll (){
		
		try {
			
			List<Funcionario> lista = this.funservice.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		
		try {
			
			String mensagem = this.funservice.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable long id){
		
		try {
			
			Funcionario funcionario = this.funservice.findById(id);
			return new ResponseEntity<>(funcionario, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/findbymatricula")
	public ResponseEntity<List<Funcionario>> findByNome (@RequestParam int matricula){
		
		try {
			
			List<Funcionario> lista = this.funservice.findByMatricula(matricula);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/buscarFuncionarioAcimaIdade")
    public ResponseEntity<List<Funcionario>> buscarFuncionarioAcimaIdade (@RequestParam int idade){

        try {

            List<Funcionario> lista = this.funservice.buscarFuncionarioAcimaIdade(idade);
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }

    }
	

}
