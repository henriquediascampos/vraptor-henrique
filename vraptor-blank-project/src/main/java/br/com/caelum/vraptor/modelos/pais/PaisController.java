package br.com.caelum.vraptor.modelos.pais;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class PaisController {

	@Inject
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
		List<Pais> pais = paisDao.lista();
		result.use(Results.json()).from(pais).recursive().serialize();
	}
	
	@Get("/pais/buscaId")
	public void buscaId(Long id) {
		Pais pais = paisDao.buscarPorId(id);
		result.use(Results.json()).from(pais).recursive().serialize();
	}
	
	@Get("/pais/salvar")
	public void salvar(String nome) {
		Pais pais = new Pais();
		pais.setNome(nome);
		paisDao.salvar(pais);
		result.include("variable", "pais!");
		result.use(Results.json()).from(pais).recursive().serialize();
	}
	
	@Get("/pais/bucarNome")
	public void buscarNome(String nome) {
		Pais pais = paisDao.buscarPorNome(nome);
		result.use(Results.json()).from(pais).serialize();
	}
}
