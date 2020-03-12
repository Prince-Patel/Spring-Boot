package com.hibernate.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hibernate.dto.OrderDTO;
import com.hibernate.service.impl.OrderServiceImpl;

@RestController
@RequestMapping(value = "/v1/order-service")
public class OrderController {

	@Autowired
	private OrderServiceImpl orderServiceImpl;
	@Autowired
	private Gson gson;
	
	@RequestMapping(value = "create-order",produces = "application/json",method = RequestMethod.POST)
	public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {
		orderServiceImpl.createOrder(orderDTO);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Order Creation Successful",HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "update-order",produces = "application/json",method = RequestMethod.PUT)
	public ResponseEntity<String> updateOrder(@RequestBody OrderDTO orderDTO) {
		//System.out.println(orderDTO.toString());
		orderServiceImpl.updateOrder(orderDTO);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Order Updated Successfully",HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "delete-order",produces = "application/json",consumes ="application/json", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteOrder(@RequestBody OrderDTO orderDTO) {
		orderServiceImpl.deleteOrder(orderDTO.getId());
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Order deleted Successfully",HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "list-order",produces = "application/json",method = RequestMethod.GET)
	public ResponseEntity<List<OrderDTO>> listOrder() {
		
		List<OrderDTO> orderDTOs = orderServiceImpl.listOrders();
		//String orders = gson.toJson(orderDTOs);
		//System.out.println(orders);
		ResponseEntity<List<OrderDTO>> responseEntity = new ResponseEntity<List<OrderDTO>>(orderDTOs,HttpStatus.OK);
		return responseEntity;
	}
}
