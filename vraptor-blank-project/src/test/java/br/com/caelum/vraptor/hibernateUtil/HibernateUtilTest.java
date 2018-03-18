package br.com.caelum.vraptor.hibernateUtil;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {
	
		@Test
		public void conectar(){
			Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
			sessao.close();
			HibernateUtil.getFabricaDeSessoes().close();
		}
}
