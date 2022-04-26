package com.tutorial.demorest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ebills")
public class EbillResource {

EbillRepository repo = new EbillRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	//get all the ebills data
	public List<Ebill> getEbills() {
		
		System.out.println("get Ebills called...");

		return repo.getEbills();
	}
	
	@GET
	@Path("ebill/{id}") 
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	//get a specific ebill
	public Ebill getEbill(@PathParam("id") int id) {

		return repo.getEbill(id);
	}
	
	@POST 
	@Path("ebill")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	//inserting data
	public Ebill createEbill(Ebill a1) {
		System.out.println(a1);
		repo.create(a1);
		return a1;
	}
	
	
	@PUT
	@Path("ebill")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	//inserting data
	public Ebill updateEbill(Ebill a1) {
		System.out.println(a1);
		if(repo.getEbill(a1.getBillId()).getBillId()==0) {
			repo.create(a1);
			
		}else {
			repo.update(a1);
		}
		
		return a1;
	}
	
	@DELETE
	@Path("ebill/{id}")
	public Ebill killEbill(@PathParam("id") int id) {
		Ebill  a = repo.getEbill(id);
		
		if(a.getBillId()!=0)
			repo.delete(id);
		return a;
	}
}
