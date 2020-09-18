package com.ts.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import com.rest.dto.Orders;
import com.rest.dto.Products;
import com.ts.db.HibernateTemplate;

public class OrdersDao {
	
	private SessionFactory factory = null;

	public OrdersDao getOrdByUserPass(String loginId,String password) {

		return (OrdersDao)HibernateTemplate.getObjectByUserPass(loginId,password);
	}

	public int register(OrdersDao order) {
		//java.util.Date utilDate = new java.sql.Date(order.getJoinDate().getTime()); 
		return HibernateTemplate.addObject(order);
	}

	public int delete(int orderId) {		
		int result = HibernateTemplate.deleteObject(Orders.class,orderId);
		return result;
	}

	public List<OrdersDao> getOrdByName(String orderName) {	
		return (List)HibernateTemplate.getObjectListByName(OrdersDao.class,"orderName",orderName);
	}
}


