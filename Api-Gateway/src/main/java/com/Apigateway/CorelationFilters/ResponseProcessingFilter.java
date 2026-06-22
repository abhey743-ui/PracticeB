package com.Apigateway.CorelationFilters;

import org.bouncycastle.jcajce.provider.symmetric.ARC4;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class ResponseProcessingFilter {

    @Bean
    public GlobalFilter globalFilter() {
        return (exchange, chain) -> {

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {

                String correlationId = exchange.getRequest()
                        .getHeaders()
                        .getFirst("CORRELATION_ID");

                if (correlationId != null) {
                    exchange.getResponse()
                            .getHeaders()
                            .set("CORRELATION_ID", correlationId);
                }

            }));
        };
    }
}
