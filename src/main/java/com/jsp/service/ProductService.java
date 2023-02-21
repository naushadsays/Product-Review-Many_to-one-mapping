package com.jsp.service;

import java.util.List;

import com.jsp.dao.ProductDao;
import com.jsp.dto.Product;
import com.jsp.dto.Review;

public class ProductService {
	ProductDao productDao = new ProductDao();

	public void create(Product p, List<Review> al) {
		productDao.create(p, al);
	}

	public void update(Product p) {
		productDao.update(p);
	}

	public void delete(Product p, List<Review> al) {
		ReviewService reviewService = new ReviewService();
		reviewService.deleteAll(al);
		productDao.delete(p);
	}

	public Product readById(Product p) {
		return productDao.readById(p);

	}
}
