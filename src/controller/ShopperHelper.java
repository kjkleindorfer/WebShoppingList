package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;
import model.Shopper;

public class ShopperHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleShoppingList");

	public void insertShopper(Shopper li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<Shopper> showAllShoppers() {
		EntityManager em = emfactory.createEntityManager();
		List<Shopper> allShoppers = em.createQuery("SELECT s FROM Shopper s").getResultList();
		return allShoppers;
	}

	public Shopper findShopper(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Shopper> typedQuery = em.createQuery("select sh from Shopper sh where sh.shopperName = :selectedName",
				Shopper.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		Shopper foundShopper;
		try {
			foundShopper = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundShopper = new Shopper(nameToLookUp);
		}
		em.close();

		return foundShopper;
	}
}
