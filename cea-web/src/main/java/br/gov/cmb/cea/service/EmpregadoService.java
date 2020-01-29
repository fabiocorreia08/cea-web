package br.gov.cmb.cea.service;

import java.util.List;

import br.gov.cmb.cea.model.Empregado;

public interface EmpregadoService {
	
	public List<Empregado> getAll();
	
	public Empregado getById(long id); 
	
	public void saveOrUpdate(Empregado article); 
		
	public void delete(long id);


}
