package com.ts.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import com.rest.dto.Products;
import com.ts.db.HibernateTemplate;

public class ProductsDao {
	
	private SessionFactory factory = null;
	
	/* public int register(Products products) {		
		return HibernateTemplate.addObject(products);
	}
*/
	public ProductsDao getProducts(int productsId) {
		return (ProductsDao)HibernateTemplate.getObject(ProductsDao.class,productsId);
	}

	//public List<ProductsDao> getAllProducts() {
	//	List<ProductsDao> Products=(List)HibernateTemplate.getObjectListByQuery("From ProductsDao");
		//return Products;	
//	}
	public List<Products> getAllProducts() {
		List<Products> productsList = 
				HibernateTemplate.getSubjectListByQuery();
		return productsList;
	}

	/*public int update(Products products) {		
		int result = HibernateTemplate.updateObject(products);
		return result;
	}
	public int delete(int productId) {		
		int result = HibernateTemplate.deleteObject(Products.class,productId);
		return result;
	} */

	public List<ProductsDao> getProdByName(String productsName) {	
		return (List)HibernateTemplate.getObjectListByName(ProductsDao.class,"productsName",productsName);
	}

	public int register(Products products) {
		//java.util.Date utilDate = new java.sql.Date(instructor.getJoinDate().getTime()); 
		return HibernateTemplate.addObject(products);
	}


	
}



