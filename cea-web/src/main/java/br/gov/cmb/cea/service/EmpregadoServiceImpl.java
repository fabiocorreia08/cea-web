package br.gov.cmb.cea.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.cmb.cea.model.Empregado;
import br.gov.cmb.cea.repository.EmpregadoRepository;

@Service
@Transactional
public class EmpregadoServiceImpl implements EmpregadoService{
	
	@Autowired
	EmpregadoRepository empregadoRepository;

	@Override
	public List<Empregado> getAll() {
		return (List<Empregado>) empregadoRepository.findAll();
	}

	@Override
	public Empregado getById(long id) {
		return empregadoRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Empregado article) {
		empregadoRepository.save(article);		
	}

	@Override
	public void delete(long id) {
		empregadoRepository.deleteById(id);		
	}

}