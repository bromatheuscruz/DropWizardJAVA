package cruz.io.learning.dropwizard.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cruz.io.learning.dropwizard.api.dtos.ProductDTO;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
	
	@GET
	public Response findAllProducts() {
		ProductDTO product = new ProductDTO(1L, "Caneta BIC", "Escolar" );
		return Response.ok(product).build();
	}
	
	
}
