package app.market.dto;

import java.io.Serializable;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idDTO;
	private String nomeDoProdutoDTO;
	private Double valorDTO;
	private Double descontoMaximoDTO;
	private Integer quantidadeDTO;

	
	public Long getIdDTO() {
		return idDTO;
	}

	public void setIdDTO(Long idDTO) {
		this.idDTO = idDTO;
	}

	public String getNomeDoProdutoDTO() {
		return nomeDoProdutoDTO;
	}

	public void setNomeDoProdutoDTO(String nomeDoProdutoDTO) {
		this.nomeDoProdutoDTO = nomeDoProdutoDTO;
	}

	public Double getValorDTO() {
		return valorDTO;
	}

	public void setValorDTO(Double valorDTO) {
		this.valorDTO = valorDTO;
	}

	public Double getDescontoMaximoDTO() {
		return descontoMaximoDTO;
	}

	public void setDescontoMaximoDTO(Double descontoMaximoDTO) {
		this.descontoMaximoDTO = descontoMaximoDTO;
	}

	public Integer getQuantidadeDTO() {
		return quantidadeDTO;
	}

	public void setQuantidadeDTO(Integer quantidadeDTO) {
		this.quantidadeDTO = quantidadeDTO;
	}

}
