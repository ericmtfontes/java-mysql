package DTO;

public class Aluno {
	private Integer id;
	private String nome;
	private Integer idade;
	
	public Aluno() {
		
		
	}
	
	public Aluno(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getId() + "," + this.getNome() + "," + this.getIdade());
		
		return sb.toString();
		
	}
}
