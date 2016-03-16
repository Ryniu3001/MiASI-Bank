package client;
import java.util.ArrayList;
import java.util.List;

import product.Product;

public class Client {

	private String name;
	private String surname;
	private List<Product> productList;
	private String id; // pesel
	
	public Client(String name,String surname,String id)
	{
		this.name=name;
		this.surname=surname;
		this.id=id;
		productList=  new ArrayList<Product>();
	}
	
	public void addProduct(Product product){
		productList.add(product);
	}
	public Product GetProduct(int id)
	{
		return productList.get(id);
	}
	
	
}
