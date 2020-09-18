package com.ts.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.rest.dto.Products;
import com.rest.dto.Services;
import com.ts.db.HibernateTemplate;

public class ServicesDao {

private SessionFactory factory = null;
	
	public static int register(Services services) {		
		return HibernateTemplate.addObject(services);
	}

	public Services getService(int serviceId) {
		return (Services)HibernateTemplate.getObject(Services.class,serviceId);
	}

	public List<Services> getAllser() {
		List<Services> services=(List)HibernateTemplate.getObjectListByQuery("From Service");
		return services;	
	}

	public List<Services> getserByName(String serviceName) {	
		return (List)HibernateTemplate.getObjectListByName(Services.class,"serviceName",serviceName);
	}
	
	public int update(Services services) {		
		int result = HibernateTemplate.updateObject(services);
		return result;
	}
	public int delete(int serviceId) {		
		int result = HibernateTemplate.deleteObject(Products.class,serviceId);
		return result;
	}
}
