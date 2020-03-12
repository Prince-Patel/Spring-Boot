package com.hibernate.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.dao.OrderDAO;
import com.hibernate.dto.OrderDTO;



@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createOrder(OrderDTO orderDTO) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(orderDTO);
	}

	@Override
	public void updateOrder(OrderDTO orderDTO) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaUpdate<OrderDTO> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(OrderDTO.class);
		Root<OrderDTO> root = criteriaUpdate.from(OrderDTO.class);
		if(!orderDTO.getOrderId().isEmpty()) {
			System.out.println("orderid not null");
		criteriaUpdate.set("orderId", orderDTO.getOrderId());
		}
		if( !orderDTO.getCreatedDate().isEmpty()) {
			System.out.println("date not null");
		criteriaUpdate.set("createdDate", orderDTO.getCreatedDate());
		}
		if(!orderDTO.getUserId().isEmpty()) {
			System.out.println("userid not null");
		criteriaUpdate.set("userId", orderDTO.getUserId());
		}
		criteriaUpdate.where(criteriaBuilder.equal(root.get("id"), orderDTO.getId()));
		
		session.createQuery(criteriaUpdate).executeUpdate();
		
		//session.saveOrUpdate(orderDTO);
	}

	@Override
	public void deleteOrder(Long id) {
		System.out.println("DAO IMPL");
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaDelete<OrderDTO> criteriaDelete = criteriaBuilder.createCriteriaDelete(OrderDTO.class);
		Root<OrderDTO> root = criteriaDelete.from(OrderDTO.class);
		
		criteriaDelete.where(criteriaBuilder.equal(root.get("id"), id));
		session.createQuery(criteriaDelete).executeUpdate();
		//session.delete(orderDTO);
		
	}

	
	@Override
	public List<OrderDTO> listOrders() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<OrderDTO> criteriaQuery = criteriaBuilder.createQuery(OrderDTO.class);
		Root<OrderDTO> root = criteriaQuery.from(OrderDTO.class);
		
		criteriaQuery.select(root);
		List<OrderDTO> orderDTOs =session.createQuery(criteriaQuery).getResultList();
		
		
		//List<OrderDTO> orders=session.createQuery("from OrderDTO").getResultList();
		return orderDTOs;
	}

}
