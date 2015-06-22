package br.michel.modelo;

//Model for Staff
public class ModelFuncionario {
	String Nome, Email, Bairro,Logradouro, RG, CPF, Telefone, Celular, Numero, CEP, Funcao, Admissao, Demissao, Motivo;
	int id, id_end;
	String Nasci;
	String Carteira;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public String getLogradouro() {
		return Logradouro;
	}
	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getCelular() {
		return Celular;
	}
	public void setCelular(String celular) {
		Celular = celular;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		Numero = numero;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getFuncao() {
		return Funcao;
	}
	public void setFuncao(String funcao) {
		Funcao = funcao;
	}
	public String getAdmissao() {
		return Admissao;
	}
	public void setAdmissao(String admissao) {
		Admissao = admissao;
	}
	public String getDemissao() {
		return Demissao;
	}
	public void setDemissao(String demissao) {
		Demissao = demissao;
	}
	public String getMotivo() {
		return Motivo;
	}
	public void setMotivo(String motivo) {
		Motivo = motivo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_end() {
		return id_end;
	}
	public void setId_end(int id_end) {
		this.id_end = id_end;
	}
	public String getNasci() {
		return Nasci;
	}
	public void setNasci(String string) {
		Nasci = string;
	}
	public String getCarteira() {
		return Carteira;
	}
	public void setCarteira(String string) {
		Carteira = string;
	}

}
