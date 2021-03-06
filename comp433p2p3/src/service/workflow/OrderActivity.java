package service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.order.Order;
import model.order.OrderManagerFacade;
import service.representation.order.OrderRepresentation;

public class OrderActivity {
	
	private static OrderManagerFacade omf = new OrderManagerFacade();
	
	public Set<OrderRepresentation> getAllOrders() {
		
		Set<Order> orders = new HashSet<Order>();
		Set<OrderRepresentation> orderRepresentations = new HashSet<OrderRepresentation>();
		orders = omf.getAllOrders();
		
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
          Order order = (Order)it.next();
          OrderRepresentation orderRepresentation = new OrderRepresentation();
                   
          orderRepresentation.setorderID(order.getorderID());
          orderRepresentation.setorderdate(order.getorderdate());
          orderRepresentation.setusername(order.getusername());
          orderRepresentation.setproductname(order.getproductname());
          orderRepresentation.setproductqty(order.getproductqty());
          orderRepresentation.settotalprice(order.gettotalprice());
          orderRepresentation.settax(order.gettax());
          orderRepresentation.setamount(order.getamount());
          orderRepresentation.setshippingaddress(order.getshippingaddress());			
          orderRepresentation.setorderstatus(order.getorderstatus());
          
          //now add this representation in the list
          orderRepresentations.add(orderRepresentation);
        }
		return orderRepresentations;
	}
	
	public OrderRepresentation getOrder(int orderID) {
		
		Order order = omf.getOrder(orderID);
		
		OrderRepresentation orderRepresentation = new OrderRepresentation();
		orderRepresentation.setorderID(order.getorderID());
        orderRepresentation.setorderdate(order.getorderdate());
        orderRepresentation.setusername(order.getusername());
        orderRepresentation.setproductname(order.getproductname());
        orderRepresentation.setproductqty(order.getproductqty());
        orderRepresentation.settotalprice(order.gettotalprice());
        orderRepresentation.settax(order.gettax());
        orderRepresentation.setamount(order.getamount());
        orderRepresentation.setshippingaddress(order.getshippingaddress());			
        orderRepresentation.setorderstatus(order.getorderstatus());
		
		return orderRepresentation;

	}
	
	public OrderRepresentation createOrder(float amount, String username, String orderdate) {	
		Order order = omf.createOrder(amount, username, orderdate);
		
		OrderRepresentation orderRep = new OrderRepresentation();
		orderRep.setamount(order.getamount());
		orderRep.setusername(order.getusername());
		orderRep.setorderdate(order.getorderdate());
		
		return orderRep;
	}
	
	public void payOrder(int orderID){	
		omf.payOrder(orderID);
	}
	
	public void fulfillOrder(int orderID){
		omf.fulfillOrder(orderID);
	}
	
	public void shipOrder(int orderID){
		omf.shipOrder(orderID);
	}
	
	public void deliverOrder(int orderID){
		omf.deliverOrder(orderID);
	}
	
	public void cancelOrder(int orderID){
		omf.cancelOrder(orderID);
	}

	public void refundOrder(int orderID){
		omf.refundOrder(orderID);
	}
	
	public String getOrderStatus(int orderID){
		return omf.getOrderStatus(orderID);
	}
	
	public String deleteOrder(int orderID) {	
		omf.deleteOrder(orderID);
		
		return "OK";
	}

}
