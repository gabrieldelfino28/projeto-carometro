package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comentario")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String categoria;
	private LocalDate data = LocalDate.now();
	private String conteudo;
	
	public Comentario() {
		super();
	}

	public Comentario(String categoria, String conteudo) {
		super();
		this.categoria = categoria;
		this.conteudo = conteudo;
	}

	public long getId() {
		return id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public String toString() {
		return "Comentario -> [id=" + id + ", categoria=" + categoria + ", data=" + data + ", conteudo=" + conteudo
				+ "]";
	}
}
