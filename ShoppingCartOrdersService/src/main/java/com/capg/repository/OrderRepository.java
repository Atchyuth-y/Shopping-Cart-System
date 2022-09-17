package com.capg.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



import com.capg.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,Integer> {

	}

