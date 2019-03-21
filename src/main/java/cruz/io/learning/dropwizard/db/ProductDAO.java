package cruz.io.learning.dropwizard.db;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import cruz.io.learning.dropwizard.api.dtos.Product;

@RegisterRowMapper(ProductMapper.class)
public interface ProductDAO {

	@SqlUpdate("insert into dropwizard_product (name, description) values (:name, :description)")
	void createProduct(@BindBean Product product);

	@SqlQuery("select * from dropwizard_product")
	List<Product> findAllProducts();
	
	@SqlQuery("select * from dropwizard_product where id = :id")
	Product findProductById(@Bind("id") Long id);
}
