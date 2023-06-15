package one.microstream.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.micronaut.core.io.ResourceResolver;
import io.micronaut.core.io.scan.ClassPathResourceLoader;
import one.microstream.domain.Product;


public class MockupUtils
{
	public static List<Product> loadMockupData()
	{
		List<Product> products = new ArrayList<Product>();
		
		ClassPathResourceLoader loader = new ResourceResolver().getLoader(ClassPathResourceLoader.class).get();
		Optional<URL> productsURL = loader.getResource("mockup/MOCKDATA.json");
		
		JSONParser productParser = new JSONParser();
		
		try
		{
			FileReader productReader = new FileReader(new File(productsURL.get().getFile()));
			
			// Read JSON file
			Object productJSON = productParser.parse(productReader);
			JSONArray productList = (JSONArray)productJSON;
			// Iterate over employee array
			productList.forEach(pro ->
			{
				Product p = parseProductObject((JSONObject)pro);
				products.add(p);
			});
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		
		return products;
	}
	
	private static Product parseProductObject(JSONObject pro)
	{
		Product p = new Product();
		
		p.setId((String)pro.get("id"));
		p.setProduct((String)pro.get("product"));
		p.setDescription((String)pro.get("description"));
		p.setCompany((String)pro.get("company"));
		p.setPrice((String)pro.get("price"));
		p.setCurrency((String)pro.get("currency"));
		p.setDepartment((String)pro.get("department"));
		
		return p;
	}
	

}
