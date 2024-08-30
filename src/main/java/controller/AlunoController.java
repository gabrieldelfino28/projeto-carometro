package controller;

import java.util.List;

import dao.AlunoDAO;
import dao.IDAO;
import model.Aluno;

public class AlunoController {
	private IDAO<Aluno> alunoDAO = new AlunoDAO();
	
	public void inserirAluno(Aluno al) {
		alunoDAO.inserir(al);
	}
	
	public List<Aluno> buscarAluno(Long id) {
		List<Aluno> al = alunoDAO.apenasUm(id);
		return al;
	}
	
	public List<Aluno> listarTodos() {
		List<Aluno> al = alunoDAO.listar();
		return al;
	}
	
	public void removerAluno(Long id) {
		alunoDAO.remover(id);
	}
}
