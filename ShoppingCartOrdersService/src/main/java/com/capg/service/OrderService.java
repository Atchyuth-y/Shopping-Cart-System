package com.capg.service;

import java.util.List;


import com.capg.dto.OrderDTO;
import com.capg.entity.Order;


public interface OrderService {
	
	List<OrderDTO> getOrders();
	
	OrderDTO getOrder(Integer orderId);
	
	OrderDTO createOrder(OrderDTO order);
	
	Order updateOrder(Order order) throws Exception;

	void deleteOrder(Integer orderId);
	
	void deleteAll();



	


	

}


