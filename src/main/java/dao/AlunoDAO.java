package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;


import model.Aluno;

public class AlunoDAO implements IDAO<Aluno> {
	/*
	 * Não foi necessário usar as outras DAO's
	 * */
	
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
		List<Aluno> alunos = new ArrayList<>();
		try {
			alunos = em.createQuery("SELECT a FROM Aluno a ", Aluno.class).getResultList();
			for (Aluno aluno : alunos) {
				Hibernate.initialize(aluno.getComentarios());
				Hibernate.initialize(aluno.getHistoricos());
				Hibernate.initialize(aluno.getLinks());
			}
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		} finally {
			em.close();
		}
		return alunos;
	}

	@Override
	public List<Aluno> apenasUm(Long id) {
		
		EntityManager em = mf.createEntityManager();
		List<Aluno> alunos = new ArrayList<>();
		try {
			alunos = em.createQuery("SELECT a FROM Aluno a WHERE a.id LIKE :id", Aluno.class).setParameter("id", id).getResultList();
			for (Aluno aluno : alunos) {
				Hibernate.initialize(aluno.getComentarios());
				Hibernate.initialize(aluno.getHistoricos());
				Hibernate.initialize(aluno.getLinks());
			}
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		} finally {
			em.close();
		}
		
		return alunos;
	}
	
}
