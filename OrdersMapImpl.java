package com.olympic.cis143.m04.student.homework.tacotruckmap.impl;

import com.olympic.cis143.m04.student.homework.tacotruckmap.OrderDoesNotExistException;
import com.olympic.cis143.m04.student.homework.tacotruckmap.Orders;
import com.olympic.cis143.m04.student.homework.tacotruckmap.TacoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrdersMapImpl implements Orders {
	
	public Map<String, List<TacoImpl>> order = new HashMap<String, List<TacoImpl>>();
	int listSize = order.size() +1;
    @Override
    public void createOrder(final String orderid) {
    	List<TacoImpl> tacosList = new ArrayList<TacoImpl>();
    		order.put(orderid,tacosList);
    	
    }

    @Override
    public void addTacoToOrder(final String orderid, final TacoImpl taco) throws OrderDoesNotExistException {
    	if(!orderid.equals("Order" + listSize) )
        {
        	throw new OrderDoesNotExistException (orderid);
        }
    	order.get(orderid).add(taco);
    	
    }

    @Override
    public boolean hasNext() {
    	while(!tacosList.isEmpty())
    	{
    		return true;
    	}
        return false;
    }

    @Override
    
    public List<TacoImpl> closeOrder(final String orderid) throws OrderDoesNotExistException {
    	if(!orderid.equals("Order" + listSize) )
        {
        	throw new OrderDoesNotExistException (orderid);
        }
    	
    	
    	
    	order.remove(orderid);
    	
    	
       return  tacosList;
       
    	
    }

    @Override
    public int howManyOrders() {
    	int totalOrders = order.size();
        return totalOrders;
    }

    @Override
    public List<TacoImpl> getListOfOrders(final String orderid) throws OrderDoesNotExistException {
        
    	if(!orderid.equals("Order" + listSize) )
        {
        	throw new OrderDoesNotExistException (orderid);
        }
        return tacosList;
    }
}
