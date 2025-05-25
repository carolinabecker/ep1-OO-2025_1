package ootrabalho;

public class Aluno {
	private String nome;
	private String matricula;
	private String curso;
	
	public Aluno() {
	
	}
	public Aluno(String nome, String matricula, String curso) {
		setNome(nome);
		setMatricula(matricula);
		setCurso(curso);
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	void listar() {
		System.out.println( this.nome + " - " + this.matricula + " - " + this.curso );
		
	}
	
	
	
	
	
}
