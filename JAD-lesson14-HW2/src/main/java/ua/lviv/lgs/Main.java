package ua.lviv.lgs;

import java.util.HashSet;
import java.util.Set;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		Cart cart = new Cart("smth","name1");
		
		Item item1 = new Item("smth1");
		Item item2 = new Item("smth2");
		Item item3 = new Item("smth3");
		Item item4 = new Item("smth4");
		cart.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4)));
				
		session.persist(cart);

		transaction.commit();
		session.close();
	}

}