package one.microstream.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;
import one.microstream.domain.Product;
import one.microstream.storage.DB;


@Controller("/")
public class ControllerProduct
{
	@Get
	public HttpResponse<List<Product>> getHttpList()
	{
		return HttpResponse.ok(DB.get().root().getProducts());
	}
	
	@Patch
	public HttpResponse<Product> update(@Body final Product product)
	{
		final Optional<Product> productOptional =
			DB.get().root().getProducts().stream().filter(p -> p.getUuid().equals(product.getUuid())).findFirst();
		
		if(productOptional.isPresent())
		{
			final Product changedProduct = productOptional.get();
			changedProduct.setDescription(product.getDescription());
			changedProduct.setProduct(product.getProduct());
			changedProduct.setPrice(product.getPrice());
			changedProduct.setCurrency(product.getCurrency());
			changedProduct.setDepartment(product.getDepartment());
			changedProduct.setCompany(product.getCompany());
			
			DB.get().storage().store(changedProduct);
			
			return HttpResponse.ok(changedProduct);
		}
		
		return HttpResponse.notFound();
	}
	
	@Put
	public HttpResponse<Product> insert(@Body final Product product)
	{
		final Product createdProduct = new Product(
			product.getId(),
			product.getProduct(),
			product.getDescription(),
			product.getCompany(),
			product.getPrice(),
			product.getCurrency(),
			product.getDepartment());
		
		DB.get().root().getProducts().add(createdProduct);
		DB.get().storage().store(DB.get().root().getProducts());
		
		return HttpResponse.ok(createdProduct);
	}
	
	@Put("/setup")
	@Consumes(value = MediaType.ALL)
	public HttpResponse<String> setup(@Body final String json)
	{
		final Gson gson = new Gson();

		final Type founderListType = new TypeToken<ArrayList<Product>>(){}.getType();
		final List<Product> productList = gson.fromJson(json, founderListType);
		
		DB.get().root().getProducts().addAll(productList);
		DB.get().storage().store(DB.get().root().getProducts());
		
		return HttpResponse.ok("1000 Products created");
	}
	
	@Delete("/{uuid}")
	@Consumes(value = MediaType.ALL)
	public HttpResponse<Product> delete(@PathVariable final String uuid)
	{
		final Optional<Product> productToDelete =
			DB.get().root().getProducts().parallelStream().filter(p -> p.getUuid().equals(uuid)).findFirst();
		
		if(productToDelete.isPresent())
		{
			DB.get().root().getProducts().remove(productToDelete.get());
			DB.get().storage().store(DB.get().root().getProducts());
			
			return HttpResponse.ok("Product has been successfully deleted");
		}
		
		return HttpResponse.notFound();
	}
	
	@Delete("/clear")
	public HttpResponse<Product> delete()
	{
		DB.get().root().getProducts().clear();
		DB.get().storage().store(DB.get().root().getProducts());
		
		return HttpResponse.ok("Product has been successfully deleted");
	}
}
