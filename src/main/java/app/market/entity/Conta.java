package app.market.entity;

public class Conta {

	private ProdutoEntity mercadoria;
	private int quantidade;
	private double descontoTotal;

	public ProdutoEntity getMercadoria() {
		return mercadoria;
	}

	public void setMercadoria(ProdutoEntity mercadoria) {
		this.mercadoria = mercadoria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getDescontoTotal() {
		return descontoTotal;
	}

	public void setDescontoTotal(double descontoTotal) {
		this.descontoTotal = descontoTotal;
	}

	public Conta(ProdutoEntity mercadoria, int quantidade, double descontoTotal) {
		super();
		this.mercadoria = mercadoria;
		this.quantidade = quantidade;
		this.descontoTotal = descontoTotal;
	}

}
