package com.hibernate.dao;

import java.util.List;

import com.hibernate.dto.OrderDTO;

public interface OrderDAO {
	
	public void createOrder(OrderDTO orderDTO);
	
	public void updateOrder(OrderDTO orderDTO);
	
	public void deleteOrder(Long id);
	
	public List<OrderDTO> listOrders();

}
