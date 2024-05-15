package one.microstream.domain;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Introspected
@Serdeable
public class Product
{
	private String uuid;
	private String id;
	private String product;
	private String description;
	private String company;
	private String price;
	private String currency;
	private String department;

	public Product(
		final String uuid,
		final String id,
		final String product,
		final String description,
		final String company,
		final String price,
		final String currency,
		final String department
	)
	{
		this.uuid = uuid;
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
		return this.uuid;
	}

	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public String getId()
	{
		return this.id;
	}

	public void setId(final String id)
	{
		this.id = id;
	}

	public String getProduct()
	{
		return this.product;
	}

	public void setProduct(final String product)
	{
		this.product = product;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getCompany()
	{
		return this.company;
	}

	public void setCompany(final String company)
	{
		this.company = company;
	}

	public String getPrice()
	{
		return this.price;
	}

	public void setPrice(final String price)
	{
		this.price = price;
	}

	public String getCurrency()
	{
		return this.currency;
	}

	public void setCurrency(final String currency)
	{
		this.currency = currency;
	}

	public String getDepartment()
	{
		return this.department;
	}

	public void setDepartment(final String department)
	{
		this.department = department;
	}
}
