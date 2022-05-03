package app.market.vo;

import java.io.Serializable;

public class ProdutoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idProdutoVO;

	private String nomeDoProdutoVO;
	private Double valorVO;
	private Double descontoMaximoVO;
	private Integer quantidadeVO;

	public Long getIdProdutoVO() {
		return idProdutoVO;
	}

	public void setIdProdutoVO(Long idProdutoVO) {
		this.idProdutoVO = idProdutoVO;
	}

	public String getNomeDoProdutoVO() {
		return nomeDoProdutoVO;
	}

	public void setNomeDoProdutoVO(String nomeDoProdutoVO) {
		this.nomeDoProdutoVO = nomeDoProdutoVO;
	}

	public Double getValorVO() {
		return valorVO;
	}

	public void setValorVO(Double valorVO) {
		this.valorVO = valorVO;
	}

	public Double getDescontoMaximoVO() {
		return descontoMaximoVO;
	}

	public void setDescontoMaximoVO(Double descontoMaximoVO) {
		this.descontoMaximoVO = descontoMaximoVO;
	}

	public Integer getQuantidadeVO() {
		return quantidadeVO;
	}

	public void setQuantidadeVO(Integer quantidadeVO) {
		this.quantidadeVO = quantidadeVO;
	}

}
