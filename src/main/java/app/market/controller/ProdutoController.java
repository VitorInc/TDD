package app.market.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.market.dto.ProdutoDTO;
import app.market.service.ProdutoService;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long id){
		ProdutoDTO dto = produtoService.buscarProdutoPorId(id);
			return ResponseEntity.ok(dto);
		}
	
	@GetMapping()
	public ResponseEntity<List<ProdutoDTO>> buscarProdutos(){
		List<ProdutoDTO> dto = produtoService.buscarTodosOsProdutos();
			return ResponseEntity.ok(dto);
		}
	

}
