package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import modelo.Curso;
import service.CursoService;

@ViewScoped
@ManagedBean
public class CursoBean {
	
	@EJB
	private CursoService cursoService;
	
	private Curso curso = new Curso();
	
	private List<Curso> cursos = new ArrayList<Curso>();
	
	private String textoPesquisa;
	
	@PostConstruct
	public void iniciarListagem() {
		atualizarListagem();
	}
	
	public void atualizarListagem(){
		cursos = cursoService.listAll();
	}
	
	public void gravarCurso(){
		cursoService.create(curso);
		curso = new Curso();
		atualizarListagem();
		FacesContext.getCurrentInstance().addMessage("msg", 
				new FacesMessage("Curso criado com Sucesso!"));
	}
	
	public void pesquisarCurso() {
		
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public String getTextoPesquisa() {
		return textoPesquisa;
	}

	public void setTextoPesquisa(String textoPesquisa) {
		this.textoPesquisa = textoPesquisa;
	}
	
	
}
