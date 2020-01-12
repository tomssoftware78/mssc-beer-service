package guru.springframework.msscbeerservice;

import com.codahale.metrics.MetricRegistry;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.geo.Metrics;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@SpringBootApplication
public class MsscBeerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsscBeerServiceApplication.class, args);
    }

    @Autowired
    private DataSource dataSource;

    //@Autowired
    //private MetricRegistry metricRegistry;

    @PostConstruct
    public void setupHikariWithMetrics() {
        if (dataSource instanceof HikariDataSource) {
            //((HikariDataSource) dataSource).setMetricRegistry(metricRegistry);
            System.out.println("Hikari datasource");

            //MetricsRe. counter("my.metric", "", "");
        }
    }

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
}
