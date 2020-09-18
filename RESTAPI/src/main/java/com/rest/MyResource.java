package com.rest;

import java.io.File;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.rest.dto.Customer;
import com.rest.dto.EmailSending;
import com.rest.dto.Products;
import com.rest.dto.Services;
import com.ts.dao.CustomerDao;
import com.ts.dao.ProductsDao;
import com.ts.dao.ServicesDao;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
   @Path("registerCustomer")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    
	public void registerCustomer(Customer customer) {
		System.out.println("Data Recieved in Register : " + customer); 
		//int x=EmployeeDao.addRecord(employee);
		CustomerDao customerDao = new CustomerDao();
	    customerDao.register(customer);  
	} 
  
   
   
  
   
   @Path("loginCustomer/{email}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getLogincustomer(@PathParam("email") String email,@PathParam("password") String password){
		
		System.out.println("recieved in path params: " + email + " "+ password);
		CustomerDao  customerDao = new CustomerDao();
		Customer customer = customerDao.getLogincustomer(email,password);
		return customer;
		
   	 }
   
   @Path("registerServices")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
   
	public void registerServices(Services services) {
		System.out.println("Data Recieved in Register : " + services); 
		//int x=EmployeeDao.addRecord(employee);
		ServicesDao servicesDao = new ServicesDao();
		ServicesDao.register(services); 
		EmailSending emailSending = new EmailSending();
		emailSending.sendEmail(services); 
	} 
   
   @Path("email")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
  
	public void email(Services services) {
		System.out.println("Data Recieved in Register : " + services); 
		//int x=EmployeeDao.addRecord(employee);
		EmailSending emailSending = new EmailSending();
		emailSending.sendEmail(services); 
	} 
   
   
   @POST
	@Path("/uploadImage")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public void uploadImage(@FormDataParam("Image") InputStream fileInputStream,@FormDataParam("Image") FormDataContentDisposition
			formDataContentDisposition,@FormDataParam("productName") String productName,@FormDataParam("description") String description, @FormDataParam("price") Double price) throws IOException{
		
		
		int read = 0;
		byte[] bytes = new byte[1024];

		String path = this.getClass().getClassLoader().getResource("").getPath();
		String pathArr[] = path.split("/WEB-INF/classes/");

		FileOutputStream out = new FileOutputStream(new File(pathArr[0] + "/image",formDataContentDisposition.getFileName()));

		while((read = fileInputStream.read(bytes)) != -1){
			out.write(bytes,0,read);
		}
		out.flush();
		out.close();
		
		Products products = new Products();
		products.setProductName(productName);
		products.setDescription(description);
		products.setPrice(price);	
		products.setImageName(formDataContentDisposition.getFileName());
		ProductsDao productsDao = new ProductsDao();

		productsDao.register(products);
		
	}
   
  
   
 /*  
   @POST
	@Path("/uploadImage")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public void uploadImage(@FormDataParam("Image") InputStream fileInputStream, @FormDataParam("Image") FormDataContentDisposition
   formDataContentDisposition, @FormDataParam("productName") String productName, @FormDataParam("description") String description, @FormDataParam("price") Double price) {
	int read = 0;
	byte[] bytes = new byte[1024];
	
	String path = this.getClass().getClassLoader().getResource("").getPath();
	String pathArr[] = path.split("/WEB-INF/classes/");
	
	FileOutputStream out;//= new FileOutputStream(new File(pathArr[0]+"/image/",( formDataContentDisposition).getFileName()));
	  try{
		   out = new FileOutputStream(new File(pathArr[0]+"/image/",( formDataContentDisposition).getFileName()));
	       
		
			while ((read = fileInputStream.read(bytes)) != -1) {
				out.write(bytes, 0 ,read);
			}
	out.flush();
	out.close();
	   }
		catch (IOException e) {
		   e.printStackTrace();
	   }  
	
	
	Products products = new Products();
	products.setProductId(1);
	products.setProductName(productName);
	products.setDescription(description);
	products.setPrice(price);
	products.setImageName(formDataContentDisposition.getFileName());
	ProductsDao productDao = new ProductsDao();
	ProductsDao.addProduct(products);
	}  
	
	  */
   @Path("getAllProducts")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Products> getProductsAll(){

		ProductsDao  productsDao  = new ProductsDao();
		List<Products> productsList = productsDao.getAllProducts();
		System.out.println(productsList);
		return (ArrayList<Products>) productsList;

	}
}


