package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Comentario;
import model.Link;

public class ComentarioDAO implements IDAO<Comentario>{
	
	EntityManagerFactory mf = Persistence.createEntityManagerFactory ("HibJPA");

	@Override
	public Comentario pesquisar(String nome) {
		return null;
	}

	@Override
	public void inserir(Comentario com) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.persist(com);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void atualizar(Comentario com) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.merge(com);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(long id) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		Link link = em.find(Link.class, id);
		if (link != null) {
			em.remove(link);
		}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Comentario> listar() {
		EntityManager em = mf.createEntityManager();
		List<Comentario> comentarios = em.createQuery("SELECT c FROM Comentario c", Comentario.class).getResultList();
		em.close();
		return comentarios;
	}

	@Override
	public List<Comentario> apenasUm(String categoria) {
		EntityManager em = mf.createEntityManager();
		List<Comentario> comentarios = em.createQuery("SELECT c FROM Comentario c WHERE c. LIKE :categoria", Comentario.class)
				.setParameter("categoria", "%" + categoria + "%")
				.getResultList();
		em.close();
		return comentarios;
	}
	
	
}
