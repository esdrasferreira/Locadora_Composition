package com.pojo;

public class Funcionario {
	
	int idFuncionario;
	String funcao;
	Double salario;
	int idcliente;
	
	
	
	public Funcionario(int idFuncionario, String funcao, Double salario, int idcliente) {
		this.idFuncionario = idFuncionario;
		this.funcao = funcao;
		this.salario = salario;
		this.idcliente = idcliente;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	

}
