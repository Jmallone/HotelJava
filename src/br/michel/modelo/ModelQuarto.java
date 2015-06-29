package br.michel.modelo;

public class ModelQuarto {

	String Status, Num, NomeTipo, Valor;
	int IdTipo, Id;

	
	
	
	public String getValor() {
		return Valor;
	}
	public void setValor(String valor) {
		Valor = valor;
	}
	public String getNomeTipo() {
		return NomeTipo;
	}
	public void setNomeTipo(String nomeTipo) {
		NomeTipo = nomeTipo;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getIdTipo() {
		return IdTipo;
	}
	public void setIdTipo(int idTipo) {
		IdTipo = idTipo;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getNum() {
		return Num;
	}
	public void setNum(String num) {
		Num = num;
	}

	
}
