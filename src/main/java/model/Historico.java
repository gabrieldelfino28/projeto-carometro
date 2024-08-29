package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="historico")
public class Historico implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nomeEmpresa;
	private String cargo;
	private LocalDate dataContratacao;
	private LocalDate dataDesligamento;
	private String funcao;

	@ManyToOne()
	private Aluno aluno;

	public Historico() {
		super();
	}

	public Historico(String nomeEmpresa, String cargo, LocalDate dataContratacao, LocalDate dataDesligamento,
			String funcao, Aluno aluno) {
		super();
		this.nomeEmpresa = nomeEmpresa;
		this.cargo = cargo;
		this.dataContratacao = dataContratacao;
		this.dataDesligamento = dataDesligamento;
		this.funcao = funcao;
		this.aluno = aluno;
	}

	public long getId() {
		return id;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public LocalDate getDataDesligamento() {
		return dataDesligamento;
	}

	public void setDataDesligamento(LocalDate dataDesligamento) {
		this.dataDesligamento = dataDesligamento;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
