package ootrabalho;

import java.util.ArrayList;


public class Cadastro {
	
	ArrayList<Aluno> listaAlunos;
	public Cadastro(){
		this.listaAlunos = new ArrayList<>();
		
	}
	void adicionarCadastro(Aluno novoAluno) {
		listaAlunos.add(novoAluno);
	}

	void listarAlunos() {
			System.out.println("\n Lista de alunos: ");
			
			for(Aluno a: listaAlunos) {
				a.listar();
			}
		}
	public Aluno buscarAlunoPorMatricula(String matricula) {
		    for (Aluno a : listaAlunos) {
		        if (a.getMatricula().equalsIgnoreCase(matricula)) {
		            return a;
		        }
		    }
		    return null;
		}

}
