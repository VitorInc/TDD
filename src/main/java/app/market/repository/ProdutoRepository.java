package app.market.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import app.market.entity.ProdutoEntity;

@Repository
public class ProdutoRepository {
	
	private List<ProdutoEntity> produtos;
	
	public List<ProdutoEntity> getProdutos() {
		return produtos;
	}

	public ProdutoRepository() {
		this.produtos = Arrays.asList(
				new ProdutoEntity(1l, "Produto1", 100.0, 0.1, 100),
				new ProdutoEntity(2l, "Produto2", 100.0, 0.1, 100), 
				new ProdutoEntity(3l, "Produto3", 100.0, 0.1, 100),
				new ProdutoEntity(4l, "Produto4", 100.0, 0.1, 100), 
				new ProdutoEntity(5l, "Produto5", 100.0, 0.1, 100),
				new ProdutoEntity(6l, "Produto6", 100.0, 0.1, 100));
	}

	public List<ProdutoEntity> findAll() {
		List<ProdutoEntity> lista = new ArrayList<ProdutoEntity>();
		
		for (ProdutoEntity listar : produtos) {
			System.out.println(listar);
			lista.add(listar);
		}
		
		return lista;
		
	}

	public ProdutoEntity findById(Long id) {
		return this.produtos.stream().filter(produto -> produtos.get(0).getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Não tem esse id my consagrated"));
	}

}
