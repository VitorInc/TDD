package app.market.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import app.market.entity.ProdutoEntity;

@Repository
public class ProdutoRepository {

	public List<ProdutoEntity> produtos = new ArrayList<>();
	
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
				new ProdutoEntity(6l, "Produto6", 100.0, 0.1, 100)				
		);	
	}

	public List<ProdutoEntity> findAll() {

		for (ProdutoEntity listar: produtos) {
			System.out.println(listar);
		}
		
		return produtos;
	}
	

	public Optional<ProdutoEntity> findById(Long id) {
		return Optional.of(this.produtos.stream().filter(produto -> produtos.get(0).getId().equals(id)).findFirst().orElse(null));
	}
	

}
