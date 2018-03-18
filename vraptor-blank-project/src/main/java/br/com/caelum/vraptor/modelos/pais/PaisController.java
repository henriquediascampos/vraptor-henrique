package br.com.caelum.vraptor.modelos.pais;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class PaisController {

	private PaisDao paisDao;
	
	private final Result result;
	
	protected PaisController() {
		this(null);
	}
	
	@Inject
	public PaisController(Result result) {
		this.result = result;
	}
	
	@Path("/pais")
	public void pais() {
		result.include("variable", "pais!");
	}
	
	@Get("/pais/busca")
	public void busca() {
		Pais pais = paisDao.busca();
		result.include("variable", pais.getNome());
	}
}
