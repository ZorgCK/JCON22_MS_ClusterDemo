package one.microstream.controller;

import java.util.List;
import java.util.Optional;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
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
	public HttpResponse<Product> update(@Body Product product)
	{
		Optional<Product> productOptional =
			DB.get().root().getProducts().stream().filter(p -> p.getUuid().equals(product.getUuid())).findFirst();
		
		if(productOptional.isPresent())
		{
			Product changedProduct = productOptional.get();
			changedProduct.setDescription(product.getDescription());
			changedProduct.setName(product.getName());
			changedProduct.setPrice(product.getPrice());
			
			DB.get().storage().store(changedProduct);
			
			return HttpResponse.ok(changedProduct);
		}
		
		return HttpResponse.notFound();
	}
	
	@Put
	public HttpResponse<Product> insert(@Body Product product)
	{
		Product createdProduct = new Product(product.getName(), product.getDescription(), product.getPrice());
		
		DB.get().root().getProducts().add(createdProduct);
		DB.get().storage().store(DB.get().root().getProducts());
		
		return HttpResponse.ok(createdProduct);
	}
	
	@Delete
	@Consumes(value = MediaType.ALL)
	public HttpResponse<Product> delete(@QueryValue String uuid)
	{
		Optional<Product> productToDelete =
			DB.get().root().getProducts().parallelStream().filter(p -> p.getUuid().equals(uuid)).findFirst();
		
		if(productToDelete.isPresent())
		{
			DB.get().root().getProducts().remove(productToDelete.get());
			DB.get().storage().store(DB.get().root().getProducts());
			
			HttpResponse.ok("Product has been successfully deleted");
		}
		
		return HttpResponse.notFound();
	}
}
