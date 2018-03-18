package br.com.caelum.vraptor.generic;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;


public class GenericDao<T>{

	//@Inject
	protected Session session;
	
	private Class<T> classe;

	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
}
