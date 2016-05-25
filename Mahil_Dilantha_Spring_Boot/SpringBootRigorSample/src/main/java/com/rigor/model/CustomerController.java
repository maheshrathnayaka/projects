package com.rigor.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rigor.controller.Customer;
@Controller
@RequestMapping("/customer")
public class CustomerController {
   private static List<Customer> list=new ArrayList<Customer>();
   
   static{
	  list.add(new Customer(1,"mahil"));
	  list.add(new Customer(2, "dilantha"));
   }
   
      @RequestMapping(value="",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody
   public List<Customer> getAllCustomer(){
	   return list;
   }
   @RequestMapping(value="",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody
   public void create(@RequestBody Customer customer){
	  // System.out.println(customer);
	 list.add(customer);
   }
   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
   @ResponseBody
   public Customer getCustomer(@PathVariable("id")int Id){
       for(Customer o : list){
           if(o.getId()==(Id))
               return o;
       }
       return null;
   }
   
   @RequestMapping(value="/{id}",method=RequestMethod.PUT)
   @ResponseBody
   public Customer updateCustomer(@PathVariable("id") String id,@RequestBody Customer customer){
	
	   for(Customer c:list){
		   if(c.getId()==Integer.parseInt(id)){
			   c.setName(customer.getName());
		   }
	   }
	   return customer; 
   }
   
   @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
   @ResponseBody
   public void deleteCustomer(@PathVariable("id") int id){
	   Customer rCust=null;
	   for(Customer c:list){
		   if(c.getId()==id){
			   rCust=c;
		   }
	   }
	   if(rCust==null){
		   
	   }else{
		   list.remove(rCust);
	   }
   }
}
