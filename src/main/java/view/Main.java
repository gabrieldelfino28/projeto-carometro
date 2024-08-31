package view;

import java.time.LocalDate;
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
		Aluno al = new Aluno();
		List<Aluno> alunos;
		String option = " ";
		Long idAluno;
		Historico h;
		Link link;
		Comentario c;
		
		String menu = "Menu: " + "\n1- Novo Registro no Carômetro." + "\n2- Atualizar Registro no Carômetro."
				+ "\n3- Consultar um Registro." + "\n4- Listar todos." + "\n5- Remover um Registro." + "\n9- Sair.";
		do {
			System.out.println(menu);
			System.out.print("\nEscolha uma opção: ");
			option = scanner.next();
			switch (option) {
			case "1":
				String url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpdg4hhXE_dm1EUlDETK44c-7siaHGTGdENQ&s";
				LocalDate dataCont = LocalDate.of(2017, 6, 17);
				LocalDate dataClose = LocalDate.of(2021, 7, 30);

				al = new Aluno("Cleiton Santana", 2030, "ADS 2", 11102345, "Pendente", url);
				link = new Link("github", "https://github.com/gabrieldelfino28");
				h = new Historico("Google", "Analista de TI", dataCont, dataClose, "Desenvolvedor Junior");
				c = new Comentario("Fatec", "Socorro");
				
				al.getComentarios().add(c);
				al.getHistoricos().add(h);
				al.getLinks().add(link);
				control.inserirAluno(al);
				System.out.println("\nCarometro Cadastrado.");
				break;
			case "2":
				System.out.println("\nCarometro Atualizado.");
				break;
			case "3":
				System.out.println("Insira o ID do aluno: ");
				idAluno = scanner.nextLong();
				alunos = control.buscarAluno(idAluno);
				if (!alunos.isEmpty()) {
					for (Aluno aluno : alunos) {
						System.out.println(aluno.toString());
					}
				} else {
					System.err.println("Registro não encontrado.");
				}
				break;
			case "4":
				try {
					alunos = control.listarTodos();
					for (Aluno aluno : alunos) {
						System.out.println(aluno.toString());
					}
				} catch (Exception e) {
					System.err.println(e.getLocalizedMessage());
				}
				break;
			case "5":
				System.out.println("Insira o ID do aluno: ");
				idAluno = scanner.nextLong();
				control.removerAluno(idAluno);
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
