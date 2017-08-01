package Persistence;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entities.Categoria;
import Entities.Dificuldade;
import Entities.Palavra;


public class PersistenceDemo {

	public static void main(String[] args) {

		/*
		 * Code to open a session
		 */
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory SF = con.buildSessionFactory();
		Session session = SF.openSession();
		org.hibernate.Transaction TR = session.beginTransaction();

		/*
		 * Codigo teste piloto para criar objetos
		 */

		Set<Categoria> lista = new HashSet<Categoria>();
		
		Dificuldade dif1 = new Dificuldade();
		Dificuldade dif2 = new Dificuldade();
		Dificuldade dif3 = new Dificuldade();
		Palavra palavra1 = new Palavra();
		Categoria cat1 = new Categoria();
		
		palavra1.setDescricao("Adentis");
		palavra1.setId(1);
		dif1.setDescricao("facil");
		dif1.setId(1);
		dif2.setDescricao("medio");
		dif2.setId(2);
		dif3.setDescricao("dificil");
		dif3.setId(3);
		cat1.setCategoria_descricao("Empresas");
		cat1.setCategoria_id(1);
		
		lista.add(cat1);
		palavra1.setDificuldade(dif1);
		palavra1.setListaCategoria(lista);
		
		/*
		 * Code for transaction
		 */

		session.save(palavra1);
		session.save(dif1);
		session.save(dif2);
		session.save(dif3);
		TR.commit();
		
		session.close();
	}

}