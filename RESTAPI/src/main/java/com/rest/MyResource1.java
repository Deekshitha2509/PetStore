package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.dto.Customer;
import com.rest.dto.Products;
import com.ts.dao.CustomerDao;
import com.ts.dao.ProductsDao;

@Path("myresource1")
public class MyResource1 {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    @Path("regCustomer")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String daoTest() {
    	Customer customer = new Customer();
    	
    	/*customer.setCustomerId(1);
    	customer.setCustomerName("Deekshu");
    	customer.setMobileNum("7660967097");
    	customer.setAddress("karimnagar");
    	customer.setEmail("5b8@gmail.com");
    	customer.setPassword("password");
    	*/
    	CustomerDao customerDao = new CustomerDao();
    	customerDao.register(customer);
   
   
  /*  	Employee emp=new Employee();
    	emp.setEmpId(100);
    	emp.setEmpName("PASHA");
    	emp.setEmail("dummy@gmail.com");
    	emp.setJoinDate(new java.util.Date());
    	emp.setDepartment(dept);
    	
    	EmployeeDAO empDao = new EmployeeDAO();
    	empDao.register(emp);*/
    	return "Success";
    }
}
    
  