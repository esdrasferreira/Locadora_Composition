package locadora.model.entity;

import java.util.Date;

import locadora.model.service.calculos.CalculosReserva;

public class Reserva {

	int idReserva;
	Date dataRetirada;
	Date dataEntrega;
	Double ValorPago;
	long diasLocado;

	private Cliente cliente;
	int idCliente;
	String firstName;
	String lastName;

	private Veiculo auto;
	int idVeiculo;
	String modelo;
	Double diaria;
	
	CalculosReserva cr = new CalculosReserva();

	public Reserva(int idReserva, Date dataRetirada, Date dataEntrega, long diasLocado, Double valorPago) {
		this.idReserva = idReserva;
		this.dataRetirada = dataRetirada;
		this.dataEntrega = dataEntrega;
		ValorPago = valorPago;
		this.diasLocado = diasLocado;
	}

	public Reserva(int idReserva, Date dataRetirada, Date dataEntrega, long diasLocado, Double valorPago,
			int idCliente, int idVeiculo) {
		this.idReserva = idReserva;
		this.dataRetirada = dataRetirada;
		this.dataEntrega = dataEntrega;
		ValorPago = valorPago;
		this.diasLocado = diasLocado;
		this.ValorPago = valorPago;
		this.idCliente = idCliente;
		this.idVeiculo = idVeiculo;

	}

	public Reserva(int idCliente, String firstName, String lastName, int idVeiculo, String modelo, Double diaria,
			int idReserva, Date dataRetirada, Date dataEntrega, long diasLocado, Double valorPago) {

		this.idCliente = idCliente;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idVeiculo = idVeiculo;
		this.modelo = modelo;
		this.diaria = diaria;
		this.idReserva = idReserva;
		this.dataRetirada = dataRetirada;
		this.dataEntrega = dataEntrega;
		this.diasLocado = diasLocado;
		this.ValorPago = valorPago;

	}

	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Double getValorPago() {
		return ValorPago;
	}

	public void setValorPago(Double valorPago) {
		ValorPago = valorPago;
	}

	public long getDiasLocado() {
		return diasLocado;
	}

	public void setDiasLocado(long diasLocado) {
		this.diasLocado = diasLocado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Veiculo getAuto() {
		return auto;
	}

	public void setAuto(Veiculo auto) {
		this.auto = auto;
	}

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getDiaria() {
		return diaria;
	}

	public void setDiaria(Double diaria) {
		this.diaria = diaria;
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

}
