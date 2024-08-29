package controller;

import dao.AlunoDAO;
import dao.ComentarioDAO;
import dao.HistoricoDAO;
import dao.IDAO;
import dao.LinkDAO;
import model.Aluno;
import model.Comentario;
import model.Historico;
import model.Link;

public class AlunoController {
	private IDAO<Aluno> alunoDAO = new AlunoDAO();
	private IDAO<Historico> histDAO = new HistoricoDAO();
	private IDAO<Link> linkDAO = new LinkDAO();
	private IDAO<Comentario> comDAO = new ComentarioDAO();
	
	public void inserirAluno(Aluno al) {
		alunoDAO.inserir(al);
	}
	
	public void inserirHistorico(Historico his) {
		histDAO.inserir(his);
	}
	
	public void inserirLink(Link lin) {
		linkDAO.inserir(lin);
	}
	
	public void inserirComentario(Comentario com) {
		comDAO.inserir(com);
	}
	
}
