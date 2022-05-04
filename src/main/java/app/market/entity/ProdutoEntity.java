package app.market.entity;

import java.io.Serializable;
import java.util.Objects;

public class ProdutoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nomeDoProduto;
	private Double valor;
	private Double descontoMaximo;
	private Integer quantidade;

	@Override
	public int hashCode() {
		return Objects.hash(descontoMaximo, id, nomeDoProduto, quantidade, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoEntity other = (ProdutoEntity) obj;
		return Objects.equals(descontoMaximo, other.descontoMaximo) && Objects.equals(id, other.id)
				&& Objects.equals(nomeDoProduto, other.nomeDoProduto) && Objects.equals(quantidade, other.quantidade)
				&& Objects.equals(valor, other.valor);
	}
	
	public ProdutoEntity() {}

	public ProdutoEntity(Long id, String nomeDoProduto, Double valor, Double descontoMaximo, Integer quantidade) {
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

	@Override
	public String toString() {
		return "Produto [descontoMaximo=" + descontoMaximo + ", id=" + id + ", nomeDoProduto=" + nomeDoProduto
				+ ", valor=" + valor + ", quantidade=" + quantidade + "]";
	}

}
