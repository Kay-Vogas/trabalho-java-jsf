package modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;

@Entity
public class Curso {
	
	@Id @GeneratedValue
	private Long id;
   
    private String nome;
    private String area;
    private int duracao; 
    
    @OneToMany
    private List<Aluno> alunos;

    public Curso() {
       
    }
    
    public Long getId() {
		return id;
	}
	
    public void setId(Long id) {
		this.id = id;
	}
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
}