package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private int anoFormacao;
	private String cursoFormado;
	private long ra;
	private String status;
	private String foto;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "aluno_id")
	private List<Comentario> comentarios = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "aluno_id")
	private List<Historico> historicos = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "aluno_id")
	private List<Link> links = new ArrayList<>();

	public Aluno() {
		super();
	}

	public Aluno(String nome, int anoFormacao, String cursoFormado, long ra, String status, String foto) {
		super();
		this.nome = nome;
		this.anoFormacao = anoFormacao;
		this.cursoFormado = cursoFormado;
		this.ra = ra;
		this.status = status;
		this.foto = foto;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "Aluno {id=" + id + ", nome=" + nome + ", anoFormacao=" + anoFormacao + ", cursoFormado=" + cursoFormado
				+ ", ra=" + ra + "status=" + status + ", fotoUrl=" + foto + "\nComentarios -> " + comentarios
				+ ",\nHistoricos -> " + historicos + "\nLinks -> " + links + "}";
	}
}