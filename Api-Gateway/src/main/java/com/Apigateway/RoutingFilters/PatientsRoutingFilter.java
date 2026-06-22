package com.Apigateway.RoutingFilters;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.time.Duration;

@Configuration
@AllArgsConstructor
public class PatientsRoutingFilter {
//    private CustomPreFilter customPreFilter;
//    private CustomGatewayFilter customGatewayFilter;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes().route(r->
                         r.path("/patients/**")
                                 .filters(f->
                                         f.rewritePath("/patients/(?<segment>.*)", "/${segment}")
                                                 .retry(retryConfig -> retryConfig
                                                         .setRetries(3)
                                                         .setMethods(HttpMethod.GET)
                                                         .setBackoff(Duration.ofMillis(1000), Duration.ofMillis(8000), 2, true)
                                                 )
                                                 .circuitBreaker(cr->cr.setName("patientBreaker").setFallbackUri("forward:/fallback"))

                                 )
                                 .uri("lb://PATIENT")).route(
                                         r-> r.path("/Email/**")
                                                 .filters(f-> f
                                                         .rewritePath("/Email/(?<segment>.*)", "/${segment}")

                                                         .retry(retryConfig -> retryConfig
                                                         .setRetries(3)
                                                         .setMethods(HttpMethod.GET)
                                                                 .setStatuses(HttpStatus.REQUEST_TIMEOUT, HttpStatus.INTERNAL_SERVER_ERROR)
                                                         .setBackoff(Duration.ofMillis(1000), Duration.ofMillis(8000), 2, true))

                                                 ).uri("lb://Email")).build();

    }
}
