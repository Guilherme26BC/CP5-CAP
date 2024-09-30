package model;

public class Cliente {
	String nome;
	String CPF;
	String whatsapp;
	double totalGasto;
	boolean aptoOferta;
	
	public Cliente(String nome, String cPF, String whatsapp, double totalGasto) {
		super();
		this.nome = nome;
		CPF = cPF;
		this.whatsapp = whatsapp;
		this.totalGasto = totalGasto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public double getTotalGasto() {
		return totalGasto;
	}

	public void setTotalGasto(double totalGasto) {
		this.totalGasto = totalGasto;
	}

	public boolean isAptoOferta() {
		return aptoOferta;
	}

	public void setAptoOferta(boolean aptoOferta) {
		this.aptoOferta = aptoOferta;
	}
}
