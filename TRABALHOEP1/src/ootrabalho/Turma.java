package ootrabalho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Turma {
    private String professorResponsavel;
    private String semestre;
    private String formaAvaliacao;
    private boolean presencial;
    private String sala; // se for remota, será "Remota" ou null
    private String horario;
    private int capacidadeMaxima;
    private ArrayList<Aluno> alunosMatriculados;
    private Map<Aluno, Avaliacao> avaliacoes;

    public Turma(String professorResponsavel, String semestre, String formaAvaliacao,
                 boolean presencial, String sala, String horario, int capacidadeMaxima) {

        this.professorResponsavel = professorResponsavel;
        this.semestre = semestre;
        this.formaAvaliacao = formaAvaliacao;
        this.presencial = presencial;
        this.sala = presencial ? sala : null;
        this.horario = horario;
        this.capacidadeMaxima = capacidadeMaxima;
        this.alunosMatriculados = new ArrayList<>();
        this.avaliacoes = new HashMap<>();
    }

    public boolean matricularAluno(Aluno aluno) {
        if (alunosMatriculados.size() >= capacidadeMaxima) {
            System.out.println("Turma cheia! Não foi possível matricular o aluno.");
            return false;
        }
        alunosMatriculados.add(aluno);
        avaliacoes.put(aluno, null);
        System.out.println("Aluno " + aluno.getNome() + " matriculado com sucesso!");
        return true;
    }
    
    public void lancarAvaliacao(Aluno aluno, Avaliacao avaliacao) {
        if (!alunosMatriculados.contains(aluno)) {
            System.out.println("Aluno não está matriculado nesta turma.");
            return;
        }
        avaliacoes.put(aluno, avaliacao);
        System.out.println("Avaliação registrada com sucesso para " + aluno.getNome());
    }

    public void listarAlunos() {
        System.out.println("Alunos matriculados na turma de " + professorResponsavel + ":");
        for (Aluno a : alunosMatriculados) {
            a.listar();
        }
    }

    public void listarTurma() {
        System.out.println("Professor: " + professorResponsavel + 
                           " | Semestre: " + semestre + 
                           " | Avaliação: " + formaAvaliacao + 
                           " | Modalidade: " + (presencial ? "Presencial" : "Remota") + 
                           " | Sala: " + (sala != null ? sala : "N/A") + 
                           " | Horário: " + horario + 
                           " | Vagas restantes: " + (capacidadeMaxima - alunosMatriculados.size()));
    }
    
    

    public String getHorario() {
        return horario;
    }

    public boolean temHorarioConflitante(String outroHorario) {
        return this.horario.equalsIgnoreCase(outroHorario);
    }


public String getProfessorResponsavel() {
    return professorResponsavel;
}

public String getSemestre() {
    return semestre;
}

public String getFormaAvaliacao() {
    return formaAvaliacao;
}

public boolean isPresencial() {
    return presencial;
}

public String getSala() {
    return sala;
}

public Map<Aluno, Avaliacao> getAvaliacoes() {
    return avaliacoes;
}

public ArrayList<Aluno> getAlunosMatriculados() {
    return alunosMatriculados;
}
}

