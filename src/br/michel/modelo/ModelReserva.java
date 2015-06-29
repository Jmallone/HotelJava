package br.michel.modelo;

public class ModelReserva {

	int idFunc, idNome, idTipo, Telefone; 
	String Status, Requ, DataAtual, DataFinal, NomeCli, NomeTipo;
	
	
	
	public String getNomeCli() {
		return NomeCli;
	}
	public void setNomeCli(String nomeCli) {
		NomeCli = nomeCli;
	}
	public String getNomeTipo() {
		return NomeTipo;
	}
	public void setNomeTipo(String nomeTipo) {
		NomeTipo = nomeTipo;
	}
	public int getTelefone() {
		return Telefone;
	}
	public void setTelefone(int telefone) {
		Telefone = telefone;
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
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getRequ() {
		return Requ;
	}
	public void setRequ(String requ) {
		Requ = requ;
	}
	public String getDataAtual() {
		return DataAtual;
	}
	public void setDataAtual(String dataAtual) {
		DataAtual = dataAtual;
	}
	public String getDataFinal() {
		return DataFinal;
	}
	public void setDataFinal(String dataFinal) {
		DataFinal = dataFinal;
	}
	
	
	
}
