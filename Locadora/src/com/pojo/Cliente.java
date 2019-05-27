package com.pojo;

public class Cliente {
	
	int idCliente;
	String firstName;
	String lastName;
	
	
	
	public Cliente(int idCliente, String firstName, String lastName, String cpf, String birthDay) {
		this.idCliente = idCliente;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.birthDay = birthDay;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	String cpf;
	String birthDay;

	
}
