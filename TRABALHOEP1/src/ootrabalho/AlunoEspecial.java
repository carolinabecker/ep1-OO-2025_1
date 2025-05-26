package ootrabalho;

import java.util.ArrayList;

public class AlunoEspecial extends Aluno {
    private ArrayList<String> disciplinasMatriculadas;
    private ArrayList<Boolean> presencas;

    public AlunoEspecial(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
        this.disciplinasMatriculadas = new ArrayList<>();
        this.presencas = new ArrayList<>();
    }

    public boolean matricularDisciplina(String disciplina) {
        if (disciplinasMatriculadas.size() >= 2) {
            System.out.println("Aluno especial só pode cursar até 2 disciplinas.");
            return false;
        }
        disciplinasMatriculadas.add(disciplina);
        presencas.add(false); 
        System.out.println("Matriculado na disciplina: " + disciplina);
        return true;
    }

    public void registrarPresenca(String disciplina) {
        int index = disciplinasMatriculadas.indexOf(disciplina);
        if (index != -1) {
            presencas.set(index, true);
            System.out.println("Presença registrada para a disciplina: " + disciplina);
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    public void listarDisciplinas() {
        System.out.println("Disciplinas do aluno especial " + getNome() + ":");
        for (int i = 0; i < disciplinasMatriculadas.size(); i++) {
            System.out.println("- " + disciplinasMatriculadas.get(i) + 
                " | Presença: " + (presencas.get(i) ? "Sim" : "Não"));
        }
    }
    
    public void removerDisciplina(String codigoDisciplina) {
        disciplinasMatriculadas.remove(codigoDisciplina);
    }

    

    public void limparDisciplinas() {
        disciplinasMatriculadas.clear();
    }


   
    @Override
    void listar() {
        System.out.println(getNome() + " - " + getMatricula() + " - " + getCurso() + " [ALUNO ESPECIAL]");
    }
    public ArrayList<String> getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

	public void adicionarDisciplina(String codigo) {
		
		
	}

}
