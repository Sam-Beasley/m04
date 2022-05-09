package com.olympic.cis143.m04.student.tacotruck.set;

import java.util.HashSet;
import java.util.Set;

import com.olympic.cis143.m04.student.tacotruck.Orders;
import com.olympic.cis143.m04.student.tacotruck.TacoImpl;

public class OrdersSetImpl  implements Orders {
	
	
	 Set<Object> tacoQueue = new HashSet<Object>();
    @Override
    public void addOrder(TacoImpl tacoOrder) {
    	tacoQueue.add(tacoOrder);
    }

    @Override
    public boolean hasNext() {
    	while(!tacoQueue.isEmpty())
    	{
    		return true;
    	}
    	
        return false;
    }

    @Override
    public TacoImpl closeNextOrder() {
    	
    	Object taco = tacoQueue.iterator().next();
    	tacoQueue.remove(taco);
		
        return (TacoImpl) taco;
    }

    @Override
    public int howManyOrders() {
    	int ordersLeft = tacoQueue.size();
        return ordersLeft;
    }
}
