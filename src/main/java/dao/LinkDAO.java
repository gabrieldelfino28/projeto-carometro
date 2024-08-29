package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Link;

public class LinkDAO implements IDAO<Link>{
	
	EntityManagerFactory mf = Persistence.createEntityManagerFactory ("HibJPA");
	
	@Override
	public Link pesquisar(String nomeRede) {
		return null;
	}

	@Override
	public void inserir(Link link) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.persist(link);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void atualizar(Link link) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.merge(link);
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
	public List<Link> listar() {
		EntityManager em = mf.createEntityManager();
		List<Link> links = em.createQuery("SELECT l FROM Link l", Link.class).getResultList();
		em.close();
		return links;
	}

	@Override
	public List<Link> apenasUm(String nomeRede) {
		EntityManager em = mf.createEntityManager();
		List<Link> links = em.createQuery("SELECT l FROM Link l WHERE l.nomeRede LIKE :nomeRede", Link.class)
				.setParameter("nomeRede", "%" + nomeRede + "%")
				.getResultList();
		em.close();
		return links;
	}
	
}
