package one.microstream.domain;

import java.util.UUID;


public class Product
{
	private final String	uuid	= UUID.randomUUID().toString();
	private String			id;
	private String			product;
	private String			description;
	private String			company;
	private String			price;
	private String			currency;
	private String			department;
	
	public Product()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(
		String id,
		String product,
		String description,
		String company,
		String price,
		String currency,
		String department)
	{
		super();
		this.id = id;
		this.product = product;
		this.description = description;
		this.company = company;
		this.price = price;
		this.currency = currency;
		this.department = department;
	}
	
	
	public String getUuid()
	{
		return uuid;
	}

	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getProduct()
	{
		return product;
	}
	
	public void setProduct(String product)
	{
		this.product = product;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getCompany()
	{
		return company;
	}
	
	public void setCompany(String company)
	{
		this.company = company;
	}
	
	public String getPrice()
	{
		return price;
	}
	
	public void setPrice(String price)
	{
		this.price = price;
	}
	
	public String getCurrency()
	{
		return currency;
	}
	
	public void setCurrency(String currency)
	{
		this.currency = currency;
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	public void setDepartment(String department)
	{
		this.department = department;
	}
	
}
