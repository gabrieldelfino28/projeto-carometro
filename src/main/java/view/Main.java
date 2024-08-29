package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.AlunoController;
import model.Aluno;
import model.Comentario;
import model.Historico;
import model.Link;

public class Main {

	public static void main(String[] args) {
		AlunoController control = new AlunoController();
		Scanner scanner = new Scanner(System.in);
		String option = " ";
		Aluno al;
		Historico h;
		Link link;
		Comentario c;
		String menu = "Menu: " + "\n1- Novo Registro no Carômetro." + "\n2- Atualizar Registro no Carômetro."
				+ "\n3- Consultar um Registro." + "\n4- Listar todos." + "\n9- Sair.";
		do {
			System.out.println(menu);
			System.out.print("\nEscolha uma opção: ");
			option = scanner.next();
			switch (option) {
			case "1":
				al = new Aluno("Cleiton Santana", 2030, "ADS 2", 11102345);

				LocalDate dataCont = LocalDate.of(2017, 6, 17);
				LocalDate dataClose = LocalDate.of(2021, 7, 30);
				h = new Historico("Google", "Analista de TI", dataCont, dataClose, "Desenvolvedor Junior", al);
				List<Historico> his = new ArrayList<Historico>();
				his.add(h);
				his.add(h);

				link = new Link("github", "https://github.com/gabrieldelfino28", al);
				List<Link> links = new ArrayList<Link>();
				links.add(link);
				links.add(link);

				c = new Comentario("Fatec", "Socorro", al);
				List<Comentario> coms = new ArrayList<Comentario>();
				coms.add(c);
				coms.add(c);

				al.setComentarios(coms);
				al.setHistoricos(his);
				al.setLinks(links);
				control.inserirAluno(al);
				control.inserirComentario(c);
				control.inserirHistorico(h);
				control.inserirLink(link);
				System.out.println("\nCarometro Cadastrado.");
				break;
			case "2":
				System.out.println("\n.");
				break;
			case "3":
				//Long idAluno = 2l;
				try {
					//List<Aluno> alunos = control.buscarAluno(idAluno);
					List<Aluno> alunos = control.listarTodos();
					for (Aluno aluno : alunos) {
						System.out.println(aluno.toString());
					}
				} catch (Exception e) {
					System.err.println(e.getMessage());
					// TODO: handle exception
				}

				break;
			case "4":
				System.out.println("\n.");
				break;
			case "9":
				System.err.println("\nSaindo da Aplicacao...");
				scanner.close();
				System.exit(1);
				break;
			default:
				System.out.println("\nOpcao invalida. Tente novamente.");
				break;
			}
		} while (!option.equals("9"));
	}
}
