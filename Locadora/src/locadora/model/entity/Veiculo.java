package locadora.model.entity;

public class Veiculo {
	
	int idVeiculo;
	String fabricante;
	String modelo;
	String ano;
	Double diaria;
	
		
	public Veiculo(int idVeiculo, String fabricante, String modelo, String ano, Double diaria) {
		this.idVeiculo = idVeiculo;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.ano = ano;
		this.diaria = diaria;
	}
	public int getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public Double getDiaria() {
		return diaria;
	}
	public void setDiaria(Double diaria) {
		this.diaria = diaria;
	}
	
	
}
