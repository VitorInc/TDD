package app.market;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.market.dto.ProdutoDTO;
import app.market.entity.ProdutoEntity;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
 class ProdutoControllerTest extends AbstractControllerIT {
	private static final String PRODUTO = "/produto/";

	private static StringBuilder path = new StringBuilder(URL);
	
	@BeforeEach
	void inicializar() {
		path.append(PRODUTO);
	}

	@AfterEach
	void finalizar() {
		path = new StringBuilder(URL);
	}
	
	@Test
	@Order(1)
	void esperaEncontrarProduto() {
		
		ProdutoDTO dto = criarDTO();
		Optional<ProdutoEntity> entity = produtoRepository.findById(dto.getIdDTO());

		path.append("/");
		path.append(dto.getIdDTO());

		ParameterizedTypeReference<ProdutoDTO> responseType = new ParameterizedTypeReference<>() {
		};

		ResponseEntity<ProdutoDTO> response = this.restTemplate.exchange(path.toString(),
				HttpMethod.GET, null, responseType);

		assertEquals(entity.get().getId(), response.getBody().getIdDTO());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	
	}
	
	@Test
	@Order(2)
	void esperaEncontrarProdutos() {
		
		

		ParameterizedTypeReference<List<ProdutoDTO>> responseType = new ParameterizedTypeReference<>() {
		};

		ResponseEntity<List<ProdutoDTO>> response = this.restTemplate.exchange(path.toString(),
				HttpMethod.GET, null, responseType);
		
		List<ProdutoEntity> entity = produtoRepository.findAll();

		assertEquals(response.getBody().size(), entity.size());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	
	}
	
	public ProdutoDTO criarDTO() {
		
		ProdutoDTO dto = new ProdutoDTO();
		
		dto.setIdDTO(1L);
		dto.setDescontoMaximoDTO(0.1);
		dto.setNomeDoProdutoDTO("PRODUTO");
		dto.setQuantidadeDTO(100);
		dto.setValorDTO(100.0);
		
		return dto;
	}
}
