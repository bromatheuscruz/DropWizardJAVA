package cruz.io.learning.dropwizard;

import org.jdbi.v3.core.Jdbi;

import cruz.io.learning.dropwizard.db.ProductDAO;
import cruz.io.learning.dropwizard.resources.ProductResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class LearningDropwizardApplication extends Application<LearningDropwizardConfiguration> {

	public static void main(final String[] args) throws Exception {
		new LearningDropwizardApplication().run(args);
	}

	@Override
	public String getName() {
		return "LearningDropwizard";
	}

	@Override
	public void initialize(final Bootstrap<LearningDropwizardConfiguration> bootstrap) {

		bootstrap.addBundle(new MigrationsBundle<LearningDropwizardConfiguration>() {
			@Override
			public DataSourceFactory getDataSourceFactory(LearningDropwizardConfiguration configuration) {
				return configuration.getDataSourceFactory();
			}
		});
	}

	@Override
	public void run(final LearningDropwizardConfiguration configuration, final Environment environment) {

		// register database
		final JdbiFactory factory = new JdbiFactory();
		final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
		ProductDAO productDao = jdbi.onDemand(ProductDAO.class);

		// register resources
		ProductResource productResource = new ProductResource(productDao);
		environment.jersey().register(productResource);
	}

}
