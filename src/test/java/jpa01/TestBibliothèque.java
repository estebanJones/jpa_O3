package jpa01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;


import jpa01.model.Emprunt;
import jpa01.model.Livre;
import jpa01.model.Client;

public class TestBibliothèque {
	private EntityManager em;
	private EntityManagerFactory factory;
	
	@Before
	public void init() {
		
	}
	
	@Test
	public void listEmpruntEtLivres() {
		factory = Persistence.createEntityManagerFactory("pu_essai");
		em = factory.createEntityManager();
		if(em != null) {
			String query = "SELECT e FROM Emprunt e";
			TypedQuery<Emprunt> q = em.createQuery(query, Emprunt.class);
			for(Emprunt e : q.getResultList()) {
				System.out.println("Emprunt : " + e);
				for(Livre l : e.getLivres()) {
					System.out.println("Livre: " + l);
				}

			}
		}
		em.close();
		factory.close();
	}
	
	@Test
	public void empruntsParClient() {
		factory = Persistence.createEntityManagerFactory("pu_essai");
		em = factory.createEntityManager();
		
		if(em != null) {
			String query = "SELECT c FROM Client c WHERE c.id=" + 3;
			TypedQuery<Client> client = em.createQuery(query, Client.class);
			Client c = client.getSingleResult();
			System.out.println("Client: " + c.getNom() + " " + c.getPrenom());
			for(Emprunt e : c.getEmprunts()) {
				System.out.println("Emprunt: " + e);
			}
		}
		em.close();
		factory.close();
	}

}
