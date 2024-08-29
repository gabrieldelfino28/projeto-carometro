package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Historico;

public class HistoricoDAO implements IDAO<Historico>{
	EntityManagerFactory mf = Persistence.createEntityManagerFactory ("HibJPA");
	
	@Override
	public Historico pesquisar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Historico h) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.persist(h);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void atualizar(Historico h) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.merge(h);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(long id) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		Historico historico = em.find(Historico.class, id);
		if (historico != null) {
			em.remove(historico);
		}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Historico> listar() {
		EntityManager em = mf.createEntityManager();
		List<Historico> historicos = em.createQuery("SELECT h FROM Historico h", Historico.class).getResultList();
		em.close();
		return historicos;
	}

	@Override
	public List<Historico> apenasUm(Long aluno_id) {
		EntityManager em = mf.createEntityManager();
		List<Historico> historicos = em.createQuery("SELECT h FROM Historico h WHERE c.aluno_id LIKE :aluno_id", Historico.class)
				.setParameter("aluno_id", aluno_id)
				.getResultList();
		em.close();
		return historicos;
	}

}
