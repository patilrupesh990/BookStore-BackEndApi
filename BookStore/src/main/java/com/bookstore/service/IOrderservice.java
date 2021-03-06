package com.bookstore.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.bookstore.entity.Order;
import com.bookstore.response.OrderResponse;

public interface IOrderservice {

	public ResponseEntity<Object> makeOrder(int id,int quantity,int userId);
	public ResponseEntity<Object> makeOrderWithToken(int id,int quantity,String token);
	public ResponseEntity<Object> cancelOrder(int bookId);
	public ResponseEntity<Object> getCartList(int userId);
	public ResponseEntity<Object> getCartListWithToken(String token);
	public ResponseEntity<Object> updateQuantity(Order order) ;
	public ResponseEntity<Object> confirmOrder(String token,List<Order> order);
	public ResponseEntity<OrderResponse> getOrderList(String token);
//	/**
//	 * 
//	 * @param token
//	 * @param orderId
//	 * @param bookId
//	 * @return
//	 */
//	public boolean isRatingAdded(String token, int orderId, int bookId);
}
