package one.microstream.domain;

import java.math.BigDecimal;
import java.util.UUID;


public class Product
{
	private String		uuid	= UUID.randomUUID().toString();
	private String		name;
	private String		description;
	private BigDecimal	price;
	
	public Product()
	{
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name, String description, BigDecimal price)
	{
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public BigDecimal getPrice()
	{
		return price;
	}
	
	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}
	
	public String getUuid()
	{
		return uuid;
	}
	
}
