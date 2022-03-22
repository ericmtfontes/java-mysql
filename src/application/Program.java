package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import DAO.AlunoDAO;
import DTO.Aluno;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int opc = 0;
		do {
			System.out.println("SISTEMA PARA CADASTRAR ALUNO");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar");
			System.out.println("3 - Excluir");
			System.out.println("4 - Alterar");
			System.out.println("0 - Sair");
			opc = sc.nextInt();
			sc.nextLine();
			switch(opc) {
				case 1:
					System.out.print("Nome: ");
					String nome = sc.nextLine();
					System.out.print("Idade: ");
					int idade = sc.nextInt();
					cadastro(nome, idade);
					break;	
				case 2:
					listar();
					break;
				case 3:
					System.out.print("Id: ");
					int id = sc.nextInt();
					excluir(id);
					break;
				case 4:
					System.out.print("Digite o ID para alterar: ");
					int i = sc.nextInt();
					sc.nextLine();
					System.out.print("Nome: ");
					String n = sc.nextLine();
					System.out.print("Idade: ");
					int ida = sc.nextInt();
					alterar(n, ida, i);
			}
			
		}while(opc != 0);
		
		sc.close();
	}
	
	public static void cadastro(String nome, int idade) {
		Aluno aluno = new Aluno(nome, idade);
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.cadastrarBD(aluno);
		
	}
	
	public static void listar() {
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> lista = new ArrayList<>();
		lista = alunoDAO.listarBD();
		for(Aluno a : lista) {
			System.out.println(a);
			
		}
	}
	
	public static void excluir(int id) {
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.excluir(id);
	}
	
	public static void alterar(String nome, int idade, int id) {
		Aluno aluno = new Aluno(nome, idade);
		aluno.setId(id);
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.alterarBD(aluno);
	}
	

}
