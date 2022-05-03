package app.market.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import app.market.entity.ProdutoEntity;
import app.market.repository.ProdutoRepository;
import app.market.vo.ProdutoVO;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	private static final Logger log = LoggerFactory.getLogger(ProdutoService.class);
	
	public List<ProdutoVO> buscarProdutos(ProdutoVO vo ){
		List<ProdutoEntity> listaProduto =  produtoRepository.findAll();
		
		List<ProdutoVO> listaVO = listaProduto.stream().map(prod -> {
			ProdutoVO prodVO = new ProdutoVO();
			
			prodVO.setIdProdutoVO(prod.getId());
			prodVO.setDescontoMaximoVO(prod.getDescontoMaximo());
			prodVO.setNomeDoProdutoVO(prod.getNomeDoProduto());
			prodVO.setQuantidadeVO(prod.getQuantidade());
			prodVO.setValorVO(prod.getValor());
			
			return prodVO;
			
		}).collect(Collectors.toList());
	}
	
	public ProdutoVO buscarProdutoPorId(Long id) {
		
		validarId(id);
		
		ProdutoEntity entity = produtoRepository.findById(id);
		ProdutoVO vo = produtoEntitytoVO(entity, new ProdutoVO());

		return vo;
		
	}
	
	private void validarId(Long id) {
		
		log.info("VERIFICANDO SE O ID DE PRODUTO EXISTE");

		
		if(id == null) {
			log.error("NÃO FOI POSSÍVEL LOCALIZAR O PRODUTO INFORMADO COM O ID: " + id);
		}
		if(!produtoRepository.getProdutos().contains(id)){
			log.error("NÃO HÁ PRODUTO COM O ID: " + id);

		}
	}
	
	private Double calcularPreçoComDescontoPossível(Double desconto, ProdutoEntity produto) {
		
		log.info("VERIFICANDO DESCONTO POSSÍVEL");
		
		if(desconto > produto.getDescontoMaximo()) {
			return produto.getValor() * (1 - produto.getDescontoMaximo());
		} else {
			return produto.getValor() * (1 - desconto);
		}

	}
	
	private Integer encontrarQuantidadeDeProdutoDisponível(ProdutoEntity produto, Integer quantidadeEscolhida) {
		if(produto.getQuantidade() <  quantidadeEscolhida) {
			log.error("NÃO TEMOS DISPONIBILIDADE DA QUANTIDADE "+ quantidadeEscolhida);
		}
		return quantidadeEscolhida;
	}

	private ProdutoVO produtoEntitytoVO(ProdutoEntity entity, ProdutoVO vo) {
		
		vo.setDescontoMaximoVO(entity.getDescontoMaximo());
		vo.setIdProdutoVO(entity.getId());
		vo.setNomeDoProdutoVO(entity.getNomeDoProduto());
		vo.setQuantidadeVO(entity.getQuantidade());
		vo.setValorVO(entity.getValor());
		
		return vo;
	}
	
	private ProdutoEntity produtoVOtoEntity(ProdutoEntity entity, ProdutoVO vo) {
		
		entity.setDescontoMaximo(vo.getDescontoMaximoVO());
		entity.setId(vo.getIdProdutoVO());
		entity.setNomeDoProduto(vo.getNomeDoProdutoVO());
		entity.setQuantidade(vo.getQuantidadeVO());
		entity.setValor(vo.getValorVO());
		
		return entity;
	}
	
	

}
