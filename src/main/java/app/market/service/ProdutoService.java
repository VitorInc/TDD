package app.market.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.market.Exception.ParametroInvalidoException;
import app.market.dto.ProdutoDTO;
import app.market.entity.ProdutoEntity;
import app.market.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	private static final Logger log = LoggerFactory.getLogger(ProdutoService.class);

	public List<ProdutoDTO> buscarTodosOsProdutos() {
		List<ProdutoEntity> produtos = produtoRepository.findAll();

		List<ProdutoDTO> dto = produtos.stream().map(produto -> {

			ProdutoDTO pdto = new ProdutoDTO();

			pdto.setDescontoMaximoDTO(produto.getDescontoMaximo());
			pdto.setIdDTO(produto.getId());
			pdto.setNomeDoProdutoDTO(produto.getNomeDoProduto());
			pdto.setQuantidadeDTO(produto.getQuantidade());
			pdto.setValorDTO(produto.getValor());

			return pdto;

		}).collect(Collectors.toList());

		return dto;
	}

	public ProdutoDTO buscarProdutoPorId(Long id) {

		ProdutoEntity produto = produtoRepository.findById(id).orElseThrow(() -> new ParametroInvalidoException(null));
		return converterProdutoParaDTO(produto);
	}

	public ProdutoEntity validarId(ProdutoDTO dto) {
		if (dto.getIdDTO() == null) {
			log.error("NÃO FOI POSSÍVEL LOCALIZAR O PRODUTO INFORMADO COM O ID: " + dto.getIdDTO());
			throw new ParametroInvalidoException(
					"NÃO FOI POSSÍVEL LOCALIZAR O PRODUTO INFORMADO COM ID: " + dto.getIdDTO());
		}

		return produtoRepository.findById(dto.getIdDTO()).orElseThrow(
				() -> new ParametroInvalidoException("NÃO ENCONTRAMOS NENHUM PRODUTO COM O ID: " + dto.getIdDTO()));

	}

	public Double calcularPreçoComDescontoPossível(Double desconto, ProdutoEntity produto) {
		if (desconto > produto.getDescontoMaximo()) {
			return produto.getValor() * (1 - produto.getDescontoMaximo());
		} else {
			return produto.getValor() * (1 - desconto);
		}
	}

	public Integer encontrarQuantidadeDeProdutoDisponível(ProdutoEntity produto, Integer quantidadeEscolhida) {
		if (produto.getQuantidade() < quantidadeEscolhida) {
			log.error("NÃO TEMOS DISPONIBILIDADE DA QUANTIDADE " + quantidadeEscolhida);
		}
		return quantidadeEscolhida;
	}

	public ProdutoDTO converterProdutoParaDTO(ProdutoEntity entity) {

		ProdutoDTO dto = new ProdutoDTO();
		
		dto.setIdDTO(entity.getId());
		dto.setDescontoMaximoDTO(entity.getDescontoMaximo());
		dto.setNomeDoProdutoDTO(entity.getNomeDoProduto());
		dto.setQuantidadeDTO(entity.getQuantidade());
		dto.setValorDTO(entity.getValor());

		return dto;

	}

	public ProdutoEntity converterDtoParaEntity(ProdutoDTO dto) {
		
		ProdutoEntity entity = new ProdutoEntity();

		entity.setId(dto.getIdDTO());
		entity.setNomeDoProduto(dto.getNomeDoProdutoDTO());
		entity.setDescontoMaximo(dto.getDescontoMaximoDTO());
		entity.setQuantidade(dto.getQuantidadeDTO());
		entity.setValor(dto.getValorDTO());

		return entity;
	}

}
