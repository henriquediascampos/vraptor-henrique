package br.com.caelum.vraptor.generic;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.hibernateUtil.HibernateUtil;
import br.com.caelum.vraptor.modelos.pais.Pais;

public abstract class GenericDao<T>{

	@Inject
	protected Session session;
	
	private Class<T> classe;
	
	@PostConstruct
	@SuppressWarnings("unchecked")
	public void xablau() {
		this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void salvar(T clazz){
		session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(clazz);
			transaction.commit();
		} catch (Exception e) {
		}finally {
			session.close();
		}
	}
	
	public T buscarPorId(Long id){
		session = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria criteria = session.createCriteria(classe);
			criteria.add(Restrictions.idEq(id));
			return (T) criteria.uniqueResult();
		} catch (Exception e) {
			throw e;
		}finally {
			session.close();
		}
	}
	
	public List<T> lista() {
		session = HibernateUtil.getFabricaDeSessoes().openSession();
		try {	
			Criteria criteria = session.createCriteria(Pais.class, "pais");
			return criteria.list();
			
		} catch (Exception e) {
			throw e;
		}finally {
			session.close();
		}
	}
}
