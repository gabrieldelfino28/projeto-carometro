package controller;

import dao.AlunoDAO;
import dao.HistoricoDAO;
import dao.IDAO;
import model.Aluno;
import model.Historico;

public class AlunoController {
	private IDAO<Aluno> alunoDao = new AlunoDAO();
	private IDAO<Historico> histDAO = new HistoricoDAO();
	
	public void inserirAluno(Aluno al) {
		alunoDao.inserir(al);
	}
	
	public void inserirHistorico(Historico his) {
		histDAO.inserir(his);
	}
	
}
