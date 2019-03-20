package cruz.io.learning.dropwizard;

import cruz.io.learning.dropwizard.resources.ProductResource;
import io.dropwizard.Application;
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
        // TODO: application initialization
    }

    @Override
    public void run(final LearningDropwizardConfiguration configuration,
                    final Environment environment) {
    	environment.jersey().register(ProductResource.class);
    }

}
