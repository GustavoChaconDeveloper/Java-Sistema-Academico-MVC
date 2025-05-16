package br.com.exemplo.model;

public class Cadastro {
	// Atributos
	private int rgm;
	private String nome;
	private String email;
	private String dtaNascimento;
	private String cpf;
	private String cep;
	private String endereco;
	private String numero;
	private String bairro;
	private String municipio;
	private String estado;
	private String telefone;
	private String campus;
	private String curso;
	private String turno;

	// construtores
	public Cadastro() {
	}

	public Cadastro(int rgm, String nome, String email, String dtaNascimento, String cpf, String cep, String endereco,
			String numero, String bairro, String municipio, String estado, String telefone, String campus, String curso,
			String turno) {
		super();
		this.rgm = rgm;
		this.nome = nome;
		this.email = email;
		this.dtaNascimento = dtaNascimento;
		this.cpf = cpf;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.municipio = municipio;
		this.estado = estado;
		this.telefone = telefone;
		this.campus = campus;
		this.curso = curso;
		this.turno = turno;
	}

	public int getRgm() {
		return rgm;
	}

	public void setRgm(int rgm) {
		this.rgm = rgm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDtaNascimento() {
		return dtaNascimento;
	}

	public void setDtaNascimento(String dtaNascimento) {
		this.dtaNascimento = dtaNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	
	
	
	}