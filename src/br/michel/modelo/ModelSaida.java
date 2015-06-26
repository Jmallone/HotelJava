package br.michel.modelo;

public class ModelSaida {
	
	int idHospedagem;
	String DataSaida, HorarioSaida, Status, Nome;
	
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getIdHospedagem() {
		return idHospedagem;
	}
	public void setIdHospedagem(int idHospedagem) {
		this.idHospedagem = idHospedagem;
	}
	public String getDataSaida() {
		return DataSaida;
	}
	public void setDataSaida(String dataSaida) {
		DataSaida = dataSaida;
	}
	public String getHorarioSaida() {
		return HorarioSaida;
	}
	public void setHorarioSaida(String horarioSaida) {
		HorarioSaida = horarioSaida;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	

}
