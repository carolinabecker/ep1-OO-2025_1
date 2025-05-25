package ootrabalho;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu{

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int opcaoPrincipal;
		ArrayList<Disciplina> disciplinas = new ArrayList<>();
		Cadastro cadastro = new Cadastro();
		
		
		 do {
	            System.out.println("\n=============================");
	            System.out.println("       MENU PRINCIPAL        ");
	            System.out.println("1 - Modo Aluno");
	            System.out.println("2 - Modo Disciplina");
	            System.out.println("3 - Modo avaliação ");
	            System.out.println("0 - Sair");
	            System.out.print("Escolha uma opção: ");
	            opcaoPrincipal = scanner.nextInt();
	            scanner.nextLine();

	            switch (opcaoPrincipal) {
	                case 1:
	                    menuAluno(scanner, cadastro, disciplinas);
	                    break;
	                case 2:
	                    menuDisciplina(scanner, disciplinas);
	                    break;
	                case 3:
	                    System.out.println("Consulta de notas ainda não implementada.");
	                    break;
	                case 0:
	                    System.out.println("Saindo do sistema...");
	                    break;
	                default:
	                    System.out.println("Opção inválida.");
	            }

	        } while (opcaoPrincipal != 0);

	        scanner.close();
	    }
		
		
	public static void menuAluno(Scanner scanner, Cadastro cadastro, ArrayList<Disciplina> disciplinas) {
	    int opcao;
	    do {
	        System.out.println("\n------ MENU ALUNO ------");
	        System.out.println("1 - Cadastrar Aluno");
	        System.out.println("2 - Listar Alunos");
	        System.out.println("3 - Matricular em Turma");
	        System.out.println("0 - Voltar");
	        System.out.print("Opção: ");
	        opcao = scanner.nextInt();
	        scanner.nextLine();

	        switch (opcao) {
	            case 1:
	                System.out.print("Nome: ");
	                String nome = scanner.nextLine();
	                System.out.print("Matrícula: ");
	                String matricula = scanner.nextLine();
	                System.out.print("Curso: ");
	                String curso = scanner.nextLine();

	                System.out.print("É aluno especial? (s/n): ");
	                String ehEspecial = scanner.nextLine();

	                Aluno aluno;
	                if (ehEspecial.equalsIgnoreCase("s")) {
	                    aluno = new AlunoEspecial(nome, matricula, curso);
	                } else {
	                    aluno = new Aluno(nome, matricula, curso);
	                }

	                cadastro.adicionarCadastro(aluno);
	                System.out.println("Aluno cadastrado!");
	                break;

	            case 2:
	                cadastro.listarAlunos();
	                break;

	            case 3:
	                System.out.print("Digite a matrícula do aluno: ");
	                String mat = scanner.nextLine();
	                Aluno alunoBuscado = cadastro.buscarAlunoPorMatricula(mat);

	                if (alunoBuscado == null) {
	                    System.out.println("Aluno não encontrado.");
	                    break;
	                }

	                System.out.print("Código da disciplina: ");
	                String codDisc = scanner.nextLine();
	                Disciplina disc = encontrarDisciplina(disciplinas, codDisc);

	                if (disc == null) {
	                    System.out.println("Disciplina não encontrada.");
	                    break;
	                }

	                disc.listarTurmas();
	                System.out.print("Informe o horário da turma para matrícula: ");
	                String horarioEscolhido = scanner.nextLine();

	                Turma turmaEscolhida = null;
	                for (Turma t : disc.getTurmas()) {
	                    if (t.getHorario().equalsIgnoreCase(horarioEscolhido)) {
	                        turmaEscolhida = t;
	                        break;
	                    }
	                }

	                if (turmaEscolhida == null) {
	                    System.out.println("Turma não encontrada.");
	                    break;
	                }

	                // Checar limite de disciplinas se for especial
	                if (alunoBuscado instanceof AlunoEspecial) {
	                    AlunoEspecial ae = (AlunoEspecial) alunoBuscado;
	                    if (ae.getDisciplinasMatriculadas().size() >= 2) {
	                        System.out.println("Aluno especial só pode cursar 2 disciplinas!");
	                        break;
	                    }
	                    ae.adicionarDisciplina(disc.getCodigo());
	                }

	                turmaEscolhida.matricularAluno(alunoBuscado);
	                break;

	            case 0:
	                System.out.println("Voltando ao menu principal...");
	                break;

	            default:
	                System.out.println("Opção inválida.");
	        }

	    } while (opcao != 0);
	}
	
		
		
public static void menuDisciplina(Scanner scanner,  ArrayList<Disciplina> disciplinas) {
   
    int opcaoDisc;

    do {
        System.out.println("\n------------ MENU DISCIPLINA ------------");
        System.out.println("1 - Cadastrar nova disciplina");
        System.out.println("2 - Adicionar pré-requisitos a disciplina");
        System.out.println("3 - Criar turma para disciplina");
        System.out.println("4 - Listar disciplinas e turmas");
        System.out.println("5 - Listar alunos de uma turma");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Opção: ");
        opcaoDisc = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoDisc) {
            case 1:
                System.out.print("Nome da disciplina: ");
                String nome = scanner.nextLine();
                System.out.print("Código da disciplina: ");
                String codigo = scanner.nextLine();
                System.out.print("Carga horária (em horas): ");
                int carga = scanner.nextInt();
                scanner.nextLine();

                Disciplina nova = new Disciplina(nome, codigo, carga);
                disciplinas.add(nova);
                System.out.println("Disciplina cadastrada com sucesso!");
                break;

            case 2:
                System.out.print("Código da disciplina que receberá o pré-requisito: ");
                String codigoBase = scanner.nextLine();
                Disciplina base = encontrarDisciplina(disciplinas, codigoBase);

                if (base != null) {
                    System.out.print("Código da disciplina pré-requisito: ");
                    String codigoRequisito = scanner.nextLine();
                    base.adicionarPreRequisito(codigoRequisito);
                    System.out.println("Pré-requisito adicionado.");
                } else {
                    System.out.println("Disciplina não encontrada.");
                }
                break;

            case 3:
                System.out.print("Código da disciplina para criar a turma: ");
                String codTurma = scanner.nextLine();
                Disciplina discTurma = encontrarDisciplina(disciplinas, codTurma);

                if (discTurma != null) {
                    System.out.print("Professor responsável: ");
                    String prof = scanner.nextLine();
                    System.out.print("Semestre (ex: 2025.1): ");
                    String semestre = scanner.nextLine();
                    System.out.print("Forma de avaliação: ");
                    String avaliacao = scanner.nextLine();
                    System.out.print("É presencial? (true/false): ");
                    boolean presencial = scanner.nextBoolean();
                    scanner.nextLine();
                    String sala = null;
                    if (presencial) {
                        System.out.print("Sala: ");
                        sala = scanner.nextLine();
                    }
                    System.out.print("Horário (ex: Terça 10h): ");
                    String horario = scanner.nextLine();
                    System.out.print("Capacidade máxima de alunos: ");
                    int max = scanner.nextInt();
                    scanner.nextLine();

                    boolean conflito = false;
                    for (Turma t : discTurma.getTurmas()) {
                        if (t.getHorario().equalsIgnoreCase(horario)) {
                            conflito = true;
                            break;
                        }
                    }

                    if (conflito) {
                        System.out.println("Já existe uma turma com esse horário.");
                    } else {
                        Turma turma = new Turma(prof, semestre, avaliacao, presencial, sala, horario, max);
                        discTurma.adicionarTurma(turma);
                        System.out.println("Turma criada com sucesso!");
                    }

                } else {
                    System.out.println("Disciplina não encontrada.");
                }
                break;

            case 4:
                for (Disciplina d : disciplinas) {
                    System.out.println("\n>> " + d.getNome() + " (" + d.getCodigo() + ")");
                    System.out.println("Carga horária: " + d.getCargaHoraria());
                    if (!d.getPreRequisitos().isEmpty()) {
                        System.out.println("Pré-requisitos: " + d.getPreRequisitos());
                    }
                    d.listarTurmas();
                }
                break;

            case 5:
                System.out.print("Código da disciplina: ");
                String cod = scanner.nextLine();
                Disciplina dBusca = encontrarDisciplina(disciplinas, cod);

                if (dBusca != null) {
                    System.out.print("Horário da turma: ");
                    String horario = scanner.nextLine();
                    for (Turma t : dBusca.getTurmas()) {
                        if (t.getHorario().equalsIgnoreCase(horario)) {
                            t.listarAlunos();
                        }
                    }
                } else {
                    System.out.println("Disciplina não encontrada.");
                }
                break;

            case 0:
                System.out.println("Voltando ao menu principal...");
                break;

            default:
                System.out.println("Opção inválida.");
        }

    } while (opcaoDisc != 0);
}
public static Disciplina encontrarDisciplina(ArrayList<Disciplina> disciplinas, String codigo) {
    for (Disciplina d : disciplinas) {
        if (d.getCodigo().equalsIgnoreCase(codigo)) {
            return d;
        }
    }
    return null;
}


}
