package com.hibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hibernate.dto.OrderDTO;

@Service
public interface OrderService {
	public void createOrder(OrderDTO orderDTO);
	
	public void updateOrder(OrderDTO orderDTO);
	
	public void deleteOrder(Long id);
	
	public List<OrderDTO> listOrders();
}
