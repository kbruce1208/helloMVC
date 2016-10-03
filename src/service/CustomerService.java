package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {

	private Map<String, Customer> customers;

	private static final CustomerService instance = new CustomerService();

	private CustomerService() {
		customers = new HashMap<String, Customer>();
	}

	public static CustomerService getInstance() {
		return instance;
	}
	
	public boolean CheckCustomer(Customer customer) {
		if(customers.containsKey(customer.getId())) {
			return false;
		}
		else
			return true;
	}

	public void addCustomer(Customer customer) {
			customers.put(customer.getId(), customer);
	}
	

	public Customer findCustomer(String id) {
		if(id != null)
				return(customers.get(id.toLowerCase()));
		else
			return null;
	}

	
	public Customer login(String id, String password) {
		if (findCustomer(id) != null && findCustomer(id).getPassword().equals(password)) {
			return findCustomer(id);
		} 
		else
			return null;
	}
}
