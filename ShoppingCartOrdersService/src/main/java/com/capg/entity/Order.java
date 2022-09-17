package com.capg.entity;





import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.capg.dto.OrderDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection= "orders")
public class Order {
	
	@Transient
	public static String SEQUENCE_NAME;

	@Id
	private Integer orderId;
	

	private String orderName;
	

	private Integer quantity;
	

	private double price;
	
	
	public Order(OrderDTO orderDTO) {
		this.orderId=orderDTO.getOrderId();
		this.orderName=orderDTO.getOrderName();
		this.quantity=orderDTO.getQuantity();
		this.price=orderDTO.getPrice();
	}
	
}

