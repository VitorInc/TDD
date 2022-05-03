package app.market.entity;

import java.io.Serializable;

public class ProdutoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nomeDoProduto;
	private Double valor;
	private Double descontoMaximo;
	private Integer quantidade;
	

	

	public ProdutoEntity(Long id, String nomeDoProduto, Double valor, Double descontoMaximo, Integer quantidade) {
		super();
		this.id = id;
		this.nomeDoProduto = nomeDoProduto;
		this.valor = valor;
		this.descontoMaximo = descontoMaximo;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getDescontoMaximo() {
		return descontoMaximo;
	}

	public void setDescontoMaximo(Double descontoMaximo) {
		this.descontoMaximo = descontoMaximo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
