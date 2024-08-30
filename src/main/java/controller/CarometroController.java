package controller;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class CarometroController {
	private List<Aluno> pendenteAnalise = new ArrayList<>();
	private List<Aluno> alunosPublicados = new ArrayList<>();

	private void  PreencheAlunosPendentes(){
		//Select de todos alunos da base com status "Pendente Análise de Publicação"
	}

	private void  PreencheAlunosPublicados(){
		//Select de todos alunos da base com status "Publicado"
	}

	private Aluno  buscaAlunoPublicado(Aluno aluno){
		try {
			Aluno al = alunosPublicados.get(alunosPublicados.indexOf(aluno));
			return al;
		} catch (Exception e){
			System.out.println("Aluno Publicado: " + aluno.getNome() + " não localizado");
		}
		return null;
	}


	private Aluno  buscaAlunoAnalise(Aluno aluno){
		try {
			Aluno al = pendenteAnalise.get(pendenteAnalise.indexOf(aluno));
			return al;
		} catch (Exception e){
			System.out.println("Aluno Pendente para Análise: " + aluno.getNome() + " não localizado");
		}
		return null;
	}

	public void publicarAluno(Aluno aluno){
		try{
			Aluno novoAlunoPublicado = buscaAlunoAnalise(aluno);
			alunosPublicados.add(novoAlunoPublicado);
			atualizarStatusAluno(aluno, "Publicado");
			System.out.println("Aluno " + aluno.getNome()+ " publicado com sucesso");
		} catch (Exception e){
			//Mensagem de erro;
			System.out.println("NÃO foi possível publicar o aluno " + aluno.getNome() + " do carômetro");
		}
	}

	public void removerAlunoCarometro(Aluno aluno){
		try{
			Aluno alunoRemovido = buscaAlunoPublicado(aluno);
			pendenteAnalise.add(alunoRemovido);
			atualizarStatusAluno(aluno, "Pendente Análise de Publicação");
			System.out.println("Aluno " + aluno.getNome()+ " removido do carômetro");
		} catch (Exception e){
			System.out.println("NÃO foi possível remover o aluno " + aluno.getNome() + " do carômetro e movê-lo para pendentes");
		}
	}

	public void atualizarStatusAluno(Aluno aluno, String status){
		//aluno.setStatus(status); // Alterar diagrama? 
		//Metodo atualizar aluno (aluno);
		System.out.println("Aluno " + aluno.getNome() + " teve seu status atualizado para " + status);
	}

	public void excluirAlunoPublicado(Aluno aluno){ 
		try{
			alunosPublicados.remove(buscaAlunoPublicado(aluno));
			//Metodo para excluir aluno da base;
			System.out.println("Aluno " + aluno.getNome()+ " excluído do sistema");
		} catch (Exception e){
			System.out.println("NÃO foi possível excluir o aluno " + aluno.getNome() + " do carômetro");
		}
	}	

	public void recusarPublicacao(Aluno aluno){
		try{
			pendenteAnalise.remove(buscaAlunoAnalise(aluno));
			System.out.println("A publicação do aluno " + aluno.getNome() + " foi recusada");
			//Metodo para excluir aluno da base;
		} catch (Exception e){
			System.out.println("Erro ao recusar a publicação do aluno:  " + aluno.getNome() + " no carômetro");
		}
	}
}
