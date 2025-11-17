package br.escola.model;

public class Aluno {
    private int id;
    private String nome;
    private String usuario;
    private String turma;
    private String matricula;
    private String turno;
    // getters e setters
    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getUsuario(){return usuario;}
    public void setUsuario(String usuario){this.usuario = usuario;}
    public String getTurma(){return turma;}
    public void setTurma(String turma){this.turma = turma;}
    public String getMatricula(){return matricula;}
    public void setMatricula(String matricula){this.matricula = matricula;}
    public String getTurno(){return turno;}
    public void setTurno(String turno){this.turno = turno;}
}
