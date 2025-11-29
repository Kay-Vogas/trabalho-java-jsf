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
	
	private Long idCurso;
	
	private Boolean editandoCurso = false;
	
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
	
	public void deletarCurso(Curso curso){
		cursoService.remove(curso);
		atualizarListagem();
	}
	
	public void editarCurso() {

		cursoService.merge(curso);
		
		curso = new Curso();
		idCurso = 0L;
		atualizarListagem();
		
		FacesContext.getCurrentInstance().addMessage("msg", 
				new FacesMessage("Curso editado com Sucesso!"));
		editandoCurso = false;
	
	}
	
	public void carregarEditar(Curso c){
		curso = c;
		idCurso = c.getId();
		editandoCurso=true;
		
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

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public Boolean getEditandoCurso() {
		return editandoCurso;
	}

	public void setEditandoCurso(Boolean editandoCurso) {
		this.editandoCurso = editandoCurso;
	}
	
	
}
