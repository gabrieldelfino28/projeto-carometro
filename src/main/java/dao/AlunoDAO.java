package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

public class AlunoDAO implements IDAO<Aluno> {
	
	EntityManagerFactory mf = Persistence.createEntityManagerFactory ("HibJPA");
	
	@Override
	public Aluno pesquisar(String nome) {
		return null;
	}

	@Override
	public void inserir(Aluno aluno) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void atualizar(Aluno aluno) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(long id) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		Aluno aluno = em.find(Aluno.class, id);
		if (aluno != null) {
			em.remove(aluno);
		}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Aluno> listar() {
		EntityManager em = mf.createEntityManager();
		List<Aluno> alunos = em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
		em.close();
		return alunos;
	}

	@Override
	public List<Aluno> apenasUm(String nome) {
		EntityManager em = mf.createEntityManager();
		List<Aluno> alunos = em.createQuery("SELECT a FROM Aluno a WHERE a.nome LIKE :nome", Aluno.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
		em.close();
		return alunos;
	}
	
}
