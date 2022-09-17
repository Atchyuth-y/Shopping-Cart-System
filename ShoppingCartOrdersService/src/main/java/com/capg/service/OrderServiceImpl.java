package com.capg.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.OrderDTO;
import com.capg.entity.Order;
import com.capg.exceptions.OrderNotFoundException;
import com.capg.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public OrderDTO createOrder(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		Order order = new Order(orderDTO);
		return new OrderDTO(orderRepository.save(order));	
	}

	@Override
	public List<OrderDTO> getOrders() {
		
		List<Order> orders= orderRepository.findAll();
		return orders.stream().map(OrderDTO::new).collect(Collectors.toList());
	}
	

	@Override
	public OrderDTO getOrder(Integer orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new  OrderNotFoundException("Order Does Not Exist With Given Id : "+orderId));
		
		return new OrderDTO(order);
	}
	
	@Override
	public Order updateOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		Optional<Order> user = this.orderRepository.findById(order.getOrderId());
		if (user.isPresent()) {
			Order orderUpdate = user.get();
			orderUpdate.setOrderName(order.getOrderName());
			orderUpdate.setQuantity(order.getQuantity());
			orderUpdate.setPrice(order.getPrice());
			orderRepository.save(orderUpdate);
	        return orderUpdate;
	    } else {
	        throw new Exception("Record not found with id : " + order.getOrderId());
	    }
	}

	

	@Override
	public void deleteOrder(Integer orderId) {
		Order order =orderRepository.findById(orderId).orElseThrow(() -> new  OrderNotFoundException("Order Does Not Exist With Given Id : "+orderId));
		
		orderRepository.delete(order);
		
	}

	@Override
	public void deleteAll() {
		orderRepository.deleteAll();
		
	}
}
	/*
	@Override
	@Transactional
	public CustomerDTO partialupdateCustomer(Integer customerId, String fname) {
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new  CustomerNotFoundException("Customer Does Not Exist With Given Id : "+customerId));
		customer.setFname(fname);
	//	customer.setLName(Lname);
		return new CustomerDTO(customer);
	}
}

	@Override
	public List<CustomerDTO> searchCustomers(String query) {
		
		List<Product> products= productRepository.searchProducts(query);
		return products.stream().map(ProductDTO::new).collect(Collectors.toList());
	}


	
		
	
@Override
	public List<Product> getUserByName( String name){
		
		return productRepository.findByName(name);
		
	}
@Override
public OrderDTO createOrder (OrderDTO orderDTO) {
	Order order = new Order(orderDTO);
	return new OrderDTO(orderRepository.save(order));	
}
*/

