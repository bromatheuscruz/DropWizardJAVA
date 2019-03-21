package cruz.io.learning.dropwizard;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class LearningDropwizardConfiguration extends Configuration {
    
	@NotNull
	@Valid
	private DataSourceFactory database = new DataSourceFactory();
	
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
    
    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory factory) {
        this.database = factory;
    }
	
}
