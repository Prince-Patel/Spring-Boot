package com.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "app_data.orders")
public class OrderDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="order_id")
	private String orderId;

	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="user_id")
	private String userId;

	@Override
	public String toString() {
		return "{\"id\":" + id + ",\" orderId\":\"" + orderId + "\", \"createdDate\":\"" + createdDate + "\", \"userId\":\"" + userId
				+ "\"}";
	}
	
	
}
