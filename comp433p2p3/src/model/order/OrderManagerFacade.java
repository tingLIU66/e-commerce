package model.order;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import dal.Databaseoperation;
import dal.OrderDAO;
import model.order.Order;

public class OrderManagerFacade{
	
	private static OrderDAO odao = new OrderDAO();
	
	public Set<Order> getAllOrders(){
		return odao.getAllOrders();
	}
	
	public Order getOrder(int orderID) {
		return odao.getOrder(orderID);
	}

	public Order createOrder(float amount, String username, String orderdate){        
		//Order order = odao.createOrder(amount, username, orderdate);
		return null;//order;
	}
	
	public void payOrder(int orderID){
		odao.payOrder(orderID);
	}
	
	public void fulfillOrder(int orderID){
		odao.fulfillOrder(orderID);
	}
	
	public void shipOrder(int orderID){
		odao.shipOrder(orderID);
	}
	
	public void deliverOrder(int orderID){
		odao.deliverOrder(orderID);
	}
	
	public void cancelOrder(int orderID){
		odao.cancelOrder(orderID);
	}

	public void refundOrder(int orderID){
		odao.refundOrder(orderID);
	}
	
	public String getOrderStatus(int orderID){
		return odao.getOrderStatus(orderID);
	}
	
	public void deleteOrder(int orderID) {
		odao.deleteOrder(orderID);
	}
}
