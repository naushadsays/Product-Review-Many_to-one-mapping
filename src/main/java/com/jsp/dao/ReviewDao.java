package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.Review;

public class ReviewDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void update(Review r) {
		Review review = entityManager.find(Review.class, r.getId());
		if (review != null) {
			entityTransaction.begin();
			review.setReview(r.getReview());
			entityManager.merge(review);
			entityTransaction.commit();
			System.out.println("All Good");
		} else {
			System.out.println("Id not found");
		}
	}

	public Review readById(Review r) {
		return entityManager.find(Review.class, r.getId());
	}

	public void delete(Review r) {
		Review review = entityManager.find(Review.class, r.getId());
		if (review != null) {
			entityTransaction.begin();
			entityManager.remove(review);
			entityTransaction.commit();
			System.out.println("All Good");
		} else {
			System.out.println("Id not found");
		}
	}
}
