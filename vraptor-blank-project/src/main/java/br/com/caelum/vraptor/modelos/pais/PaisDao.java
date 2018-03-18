package br.com.caelum.vraptor.modelos.pais;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;

import br.com.caelum.vraptor.generic.GenericDao;

@RequestScoped
public class PaisDao extends GenericDao<Pais> implements Serializable{
	
	public Pais busca() {
		Criteria criteria = session.createCriteria(Pais.class, "pais");
		return (Pais) criteria.uniqueResult();
	}
}
