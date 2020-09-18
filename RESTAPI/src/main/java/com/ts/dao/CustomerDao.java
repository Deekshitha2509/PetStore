package com.ts.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import com.rest.dto.Customer;
import com.rest.dto.Products;
import com.ts.db.HibernateTemplate;

public class CustomerDao {
	
	private SessionFactory factory = null;
			
		    public int register(Customer customer) {		
			     return HibernateTemplate.addObject(customer);
		    }
			public Customer getcustomer(int customerId) {
				return (Customer)HibernateTemplate.getObject(Customer.class,customerId);
			}
			public int update(Customer customer) {		
				int result = HibernateTemplate.updateObject(customer);
				return result;
			}
			public int delete(int customerId) {		
				int result = HibernateTemplate.deleteObject(Customer.class,customerId);
				return result;
			}

			public List<Customer> getAllcustomer() {
				List<Customer> customer=(List)HibernateTemplate.getObjectListByQuery("From Customer");
				return customer;	
			}

			public List<Customer> getserByName(String customerName) {	
				return (List)HibernateTemplate.getObjectListByName(Customer.class,"customerName",customerName);

		}
			public Customer getLogincustomer(String loginId, String password) {
				// TODO Auto-generated method stub
				return (Customer) HibernateTemplate.getObjectByUserPass(loginId,password);
			}
			

}

	

