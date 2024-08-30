package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="link")
public class Link implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomeRede;
	private String link;
	
	
	public Link() {
		super();
	}

	public Link(String nomeRede, String link) {
		super();
		this.nomeRede = nomeRede;
		this.link = link;
	}

	public long getId() {
		return id;
	}

	public String getNomeRede() {
		return nomeRede;
	}

	public void setNomeRede(String nomeRede) {
		this.nomeRede = nomeRede;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Link -> [id=" + id + ", nomeRede=" + nomeRede + ", link=" + link + "]";
	}
}
