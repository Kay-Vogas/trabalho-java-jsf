package service;

import javax.ejb.Stateless;

import modelo.Curso;

@Stateless
public class CursoService extends GenericService<Curso> {
	
	public CursoService() {
		super(Curso.class);
	}
}
