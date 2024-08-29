package view;

import java.time.LocalDate;
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
		
		do {
			System.out.println("Menu: " + "\n1- Novo Registro no Carômetro." + "\n2- Atualizar Registro no Carômetro."
					+ "\n3- Consultar um Registro." + "\n4- Listar todos." + "\n9- Sair.");
			System.out.print("\nEscolha uma opção: ");
			option = scanner.next();
			switch (option) {
			case "1":
				al = new Aluno("Cleiton 2", 2030, "ADS 2", 11102345);
				control.inserirAluno(al);
				
				LocalDate dataCont = LocalDate.of(2017, 6, 17);
				LocalDate dataClose = LocalDate.of(2021, 7, 30);
				h = new Historico("Google", "Analista de TI", dataCont, dataClose, "Desenvolvedor Junior", al);
				control.inserirHistorico(h);
				
				link = new Link("github", "https://github.com/gabrieldelfino28", al);
				c = new Comentario("Fatec", "Socorro", al);
				control.inserirLink(link);
				control.inserirComentario(c);
				
				System.out.println("\nCarometro Cadastrado.");
				break;
			case "2":
				System.out.println("\n.");
				break;
			case "3":
				System.out.println("\n.");
				break;
			case "4":
				System.out.println("\n.");
				break;
			case "9":
				System.out.println("\nSaindo do menu.");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("\nOpcao invalida. Tente novamente.");
				break;
			}
		} while (!option.equals("9"));
	}
}
