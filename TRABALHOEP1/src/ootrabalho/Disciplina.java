package ootrabalho;

import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private String codigo;
    private int cargaHoraria;
    private ArrayList<String> preRequisitos;
    private ArrayList<Turma> turmas;

    public Disciplina(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.preRequisitos = new ArrayList<>();
        this.turmas = new ArrayList<>();
    }

    public void adicionarPreRequisito(String codigoDisciplina) {
        preRequisitos.add(codigoDisciplina);
    }

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public void listarTurmas() {
        System.out.println("Turmas da disciplina " + nome + ":");
        for (Turma t : turmas) {
            t.listarTurma();
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public ArrayList<String> getPreRequisitos() {
        return preRequisitos;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }
}

