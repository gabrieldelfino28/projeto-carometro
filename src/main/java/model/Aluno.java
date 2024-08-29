package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="aluno")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private int anoFormacao;
	private String cursoFormado;
	private long ra;
	
	public Aluno() {
		super();
	}

	public Aluno(String nome, int anoFormacao, String cursoFormado, long ra) {
		super();
		this.nome = nome;
		this.anoFormacao = anoFormacao;
		this.cursoFormado = cursoFormado;
		this.ra = ra;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoFormacao() {
		return anoFormacao;
	}

	public void setAnoFormacao(int anoFormacao) {
		this.anoFormacao = anoFormacao;
	}

	public String getCursoFormado() {
		return cursoFormado;
	}

	public void setCursoFormado(String cursoFormado) {
		this.cursoFormado = cursoFormado;
	}

	public long getRa() {
		return ra;
	}

	public void setRa(long ra) {
		this.ra = ra;
	}	
	
}