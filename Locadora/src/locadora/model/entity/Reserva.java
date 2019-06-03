package locadora.model.entity;

import java.util.Date;

public class Reserva {

	int idReserva;
	Date dataRetirada;
	Date dataEntrega;
	Double ValorPago;
	long diasLocado;

	private Cliente cliente = new Cliente();

	private Veiculo veiculo = new Veiculo();


	public Reserva(int idReserva, Date dataRetirada, Date dataEntrega, long diasLocado, Double valorPago) {
		this.idReserva = idReserva;
		this.dataRetirada = dataRetirada;
		this.dataEntrega = dataEntrega;
		ValorPago = valorPago;
		this.diasLocado = diasLocado;
	}

	public Reserva(int idReserva, Date dataRetirada, Date dataEntrega, long diasLocado, Double valorPago, int idCliente,
			int idVeiculo) {
		this.idReserva = idReserva;
		this.dataRetirada = dataRetirada;
		this.dataEntrega = dataEntrega;
		ValorPago = valorPago;
		this.diasLocado = diasLocado;
		this.ValorPago = valorPago;
		cliente.setIdCliente(idCliente);
		veiculo.setIdVeiculo(idVeiculo);

	}

	public Reserva(int idCliente, String firstName, String lastName, int idVeiculo, String modelo, Double diaria,
			int idReserva, Date dataRetirada, Date dataEntrega, long diasLocado, Double valorPago) {

		cliente.setIdCliente(idCliente);
		cliente.setFirstName(firstName);
		cliente.setLastName(lastName);
		veiculo.setIdVeiculo(idVeiculo);
		veiculo.setModelo(modelo);
		veiculo.setDiaria(diaria);
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

}
