package br.michel.modelo;


public class ModelEntrada {
	
	//TODO: Adicionar na tela Entrada a Reserva como opcional
	int idFunc, idNome, idNum, idReserva;
	String dataAtual, dataPrev, desc, horarioEntrada, status, num;
	
	
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getIdFunc() {
		return idFunc;
	}
	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}
	public int getIdNome() {
		return idNome;
	}
	public void setIdNome(int idNome) {
		this.idNome = idNome;
	}
	public int getIdNum() {
		return idNum;
	}
	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}
	public String getDataAtual() {
		return dataAtual;
	}
	public void setDataAtual(String dataAtual) {
		this.dataAtual = dataAtual;
	}
	public String getDataPrev() {
		return dataPrev;
	}
	public void setDataPrev(String dataPrev) {
		this.dataPrev = dataPrev;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getHorarioEntrada() {
		return horarioEntrada;
	}
	public void setHorarioEntrada(String horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}
	
}
