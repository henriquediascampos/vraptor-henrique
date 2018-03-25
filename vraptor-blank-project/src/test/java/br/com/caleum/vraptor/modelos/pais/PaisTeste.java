package br.com.caleum.vraptor.modelos.pais;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;

import br.com.caelum.vraptor.modelos.pais.Pais;
import br.com.caelum.vraptor.modelos.pais.PaisDao;

public class PaisTeste {
	
	//@Inject
	private PaisDao paisDao;
	
	@Ignore
	@Test
	public void listar() {
		//Pais pais = paisDao.busca();
		//System.out.println(pais.getNome());
	}
	
	@Ignore
	@Test
	public void buscaId() {
		Long id = 1L;
		Pais pais = paisDao.buscarPorId(id);
		System.out.println(pais.getNome());
	}
	
	@Test
	public void salvar(){
		Pais pais = new Pais();
		pais.setNome("Brasil");
		paisDao = new PaisDao();
		paisDao.salvar(pais);
	}
}
