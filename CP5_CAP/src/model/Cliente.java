package model;

public class Cliente {
	private String nome;
	private String CPF;
	private String whatsapp;
	private double totalGasto;
	private boolean aptoOferta;
	private boolean aceitaOferta;
	
	

	public Cliente(String nome, String cPF, String whatsapp, double totalGasto) {
		super();
		this.nome = nome;
		CPF = cPF;
		this.whatsapp = whatsapp;
		this.totalGasto = totalGasto;
	}
	
	public void show() {
		System.out.println("****Cliente: ****");
		System.out.println("\t" + getNome());
		System.out.println("\t" + getCPF());
		System.out.println("\t" + getWhatsapp());
		System.out.println("\t" + getTotalGasto());
		if(isAceitaOferta()) {
			System.out.println("Oferta aceita!");
		}else {
			System.out.println("Oferta não aceitas!");
		}
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
	public boolean isAceitaOferta() {
		return aceitaOferta;
	}

	public void setAceitaOferta(boolean aceitaOferta) {
		this.aceitaOferta = aceitaOferta;
	}
}
