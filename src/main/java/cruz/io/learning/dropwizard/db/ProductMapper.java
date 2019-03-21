package cruz.io.learning.dropwizard.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import cruz.io.learning.dropwizard.api.dtos.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product map(ResultSet rs, StatementContext ctx) throws SQLException {
		return new Product(
				rs.getLong("id"),
				rs.getString("name"),
				rs.getString("description")
		);
	}

}
