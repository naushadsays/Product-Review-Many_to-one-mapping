package com.jsp.controller;

import java.util.ArrayList;


import com.jsp.dto.Product;
import com.jsp.dto.Review;
import com.jsp.service.ProductService;
import com.jsp.service.ReviewService;

public class Controller {
	public static void main(String[] args) {
		Product product = new Product();
		product.setName("DRILL MACHINE");

		Review r1 = new Review();
		r1.setReview("VERY GOOD PRODUCT");
		r1.setProduct(product);

		Review r2 = new Review();
		r2.setReview("BAD");
		r2.setProduct(product);

		Review r3 = new Review();
		r3.setReview("bad");
		r3.setProduct(product);
		
//		to delete a product record set the review id for every review 
		r1.setId(13);
		r2.setId(14);
		r3.setId(15);

		ArrayList<Review> al = new ArrayList<Review>();
		al.add(r3);
		al.add(r2);
		al.add(r1);

		
//		--------------------PRODUCT CRUD OPERATIONS----------------------
		
		ProductService pservice = new ProductService();

//		Save Operation COMMON FOR BOTH ENTITY PRESENT IN PRODUCTSERVICE
		pservice.create(product, al);

		
//		Update product
		product.setId(3);
		pservice.update(product);

		
//		delete product
		product.setId(5);
		pservice.delete(product, al);
		
		
//		read product by id 
		product.setId(1);
		Product p = pservice.readById(product);
		System.out.println(p.getId());
		System.out.println(p.getName());

		
		
//		------------------------------REVIEW OPERATIONS--------------------
		
		ReviewService reviewService= new ReviewService();
		
//		UPDATE REVIEW
		r1.setId(9);
		reviewService.update(r1);
		
//		DELETE REVIEW
		r1.setId(9);
		reviewService.delete(r1);
		
//		Read Review
		r1.setId(1);
		Review review= reviewService.readById(r1);
		System.out.println(review.getId());
		System.out.println(review.getReview());
		
		
		
		
		System.out.println("All Good");

	}

}
