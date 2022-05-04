package app.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import app.market.repository.ProdutoRepository;

public abstract class AbstractControllerIT implements BaseControllerIT{
	
	@Autowired
	protected TestRestTemplate restTemplate;
	
	@Autowired
	public ProdutoRepository produtoRepository;

}
