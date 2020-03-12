package com.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.dao.impl.OrderDAOImpl;
import com.hibernate.dto.OrderDTO;
import com.hibernate.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAOImpl orderDAO;
	
	@Override
	public void createOrder(OrderDTO orderDTO) {
		
		orderDAO.createOrder(orderDTO);
	}

	@Override
	public void updateOrder(OrderDTO orderDTO) {
		orderDAO.updateOrder(orderDTO);
	}

	@Override
	public void deleteOrder(Long id) {
		orderDAO.deleteOrder(id);
		
	}

	@Override
	public List<OrderDTO> listOrders() {
		return orderDAO.listOrders() ;
		
	}

}
