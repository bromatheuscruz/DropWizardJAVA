package cruz.io.learning.dropwizard.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cruz.io.learning.dropwizard.api.dtos.Product;
import cruz.io.learning.dropwizard.db.ProductDAO;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

	private ProductDAO productDao;

	public ProductResource(ProductDAO productDao) {
		this.productDao = productDao;
	}

	@GET
	public Response findAllProducts() {
		List<Product> products = productDao.findAllProducts();
		return Response.ok(products).build();
	}

	@GET
	@Path("/{id}")
	public Response getProductById(@PathParam("id") Long id) {
		
		Product product = productDao.findProductById(id);

		if (product == null) {
			throw new WebApplicationException("Product does not exist", Response.Status.NOT_FOUND);
		}
		return Response.ok(product).build();
	}

	@POST
	public Response saveProduct(Product product) {

		productDao.createProduct(product);
		return Response.noContent().build();
	}

}
