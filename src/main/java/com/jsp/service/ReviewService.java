package com.jsp.service;

import java.util.List;

import com.jsp.dao.ReviewDao;
import com.jsp.dto.Review;

public class ReviewService {
	ReviewDao reviewDao = new ReviewDao();

	public void update(Review r) {
		reviewDao.update(r);
	}

	public void delete(Review r) {
		reviewDao.delete(r);
	}

	public Review readById(Review r) {
		return reviewDao.readById(r);

	}

	public void deleteAll(List<Review> al) {
		for (Review r : al) {
			reviewDao.delete(r);
		}
	}

}
