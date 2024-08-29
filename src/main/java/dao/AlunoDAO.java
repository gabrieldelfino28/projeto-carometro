package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;
import model.Comentario;
import model.Historico;
import model.Link;

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
		List<Aluno> alunos = em.createQuery("SELECT a FROM aluno a", Aluno.class).getResultList();
		em.close();
		return alunos;
	}

	@Override
	public List<Aluno> apenasUm(Long id) {
		LinkDAO lDAO = new LinkDAO();
		ComentarioDAO cDAO = new ComentarioDAO();
		HistoricoDAO hDAO = new HistoricoDAO();
		
		EntityManager em = mf.createEntityManager();
		List<Aluno> alunos = em.createQuery("SELECT a FROM Aluno a WHERE a.id LIKE :id", Aluno.class)
				.setParameter("id", id)
				.getResultList();
		em.close();
		
		List<Link> links = lDAO.apenasUm(id);
		List<Comentario> coms = cDAO.apenasUm(id);
		List<Historico> his = hDAO.apenasUm(id);
		
		for (Aluno al : alunos) {
			al.setLinks(links);
			al.setComentarios(coms);
			al.setHistoricos(his);
		}
		return alunos;
	}
	
}
