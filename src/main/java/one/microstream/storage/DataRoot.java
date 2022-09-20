package one.microstream.storage;

import java.util.ArrayList;
import java.util.List;

import one.microstream.domain.Product;

public class DataRoot
{
	public final List<Product> products = new ArrayList<>();

	public List<Product> getProducts()
	{
		return products;
	}
}
