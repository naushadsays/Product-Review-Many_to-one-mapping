package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.Product;
import com.jsp.dto.Review;

public class ProductDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void create(Product p, List<Review> al) {
		entityTransaction.begin();
		entityManager.persist(p);
		for (Review review : al) {
			entityManager.persist(review);
		}
		entityTransaction.commit();
	}

	public Product readById(Product p) {
		return entityManager.find(Product.class,p.getId());

	}

	public void update(Product p) {
		Product product = entityManager.find(Product.class, p.getId());
		if (product != null) {
			entityTransaction.begin();
			product.setName(p.getName());
			entityManager.merge(product);
			entityTransaction.commit();
			System.out.println("All Good");
		} else
			System.out.println("Id not found");
	}

	public void delete(Product p) {
		Product product = entityManager.find(Product.class, p.getId());
		if (product != null) {
			entityTransaction.begin();
			entityManager.remove(product);
			entityTransaction.commit();
			System.out.println("All Good");
		} else {
			System.out.println("Id not found");
		}
	}
}
