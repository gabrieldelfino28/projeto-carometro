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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Historico> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Historico> apenasUm(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
