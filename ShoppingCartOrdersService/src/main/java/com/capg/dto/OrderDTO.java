package com.capg.dto;

import com.capg.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	
	private Integer orderId;
	

	private String orderName;
	

	private Integer quantity;
	

	private double price;
	
	
	
	public OrderDTO(Order order) {
		this.orderId=order.getOrderId();
		this.orderName=order.getOrderName();
		this.quantity=order.getQuantity();
		this.price=order.getPrice();
		
	}
}
