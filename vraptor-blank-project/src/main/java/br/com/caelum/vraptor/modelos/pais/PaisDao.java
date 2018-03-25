package br.com.caelum.vraptor.modelos.pais;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.generic.GenericDao;

@SuppressWarnings("serial")
@RequestScoped
public class PaisDao extends GenericDao<Pais> implements Serializable{
	
	@SuppressWarnings("unchecked")
	public List<Pais> busca() {
		Criteria criteria = session.createCriteria(Pais.class, "pais");
		return criteria.list();
	}
	
	public Pais buscaPorIdi(Long id) {
		Criteria criteria = session.createCriteria(Pais.class, "pais");
		criteria.add(Restrictions.idEq(id));
		return (Pais) criteria.uniqueResult();
	}
	
	public Pais buscarPorNome(String nome) {
		Criteria criteria = session.createCriteria(Pais.class, "pais");
		criteria.add(Restrictions.eq("pais.nome", nome));
		return (Pais) criteria.uniqueResult();
	}
}
