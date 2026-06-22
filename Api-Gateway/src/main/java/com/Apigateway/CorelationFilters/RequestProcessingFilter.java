package com.Apigateway.CorelationFilters;

import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Configuration
@AllArgsConstructor
public class RequestProcessingFilter implements GlobalFilter {

    private FilterUtility filterUtility;
    private static final Logger logger =
            LoggerFactory.getLogger(RequestProcessingFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<String> header = exchange.getRequest().getHeaders().get("CORRELATION_ID");
                   if(header != null){
                       logger.debug("The correlation id is : {}",header.getFirst());
                       return chain.filter(exchange);
                   }


                       String id = filterUtility.createId();
                     exchange =   exchange.mutate().request(exchange.getRequest()
                               .mutate().header("CORRELATION_ID",id).build()).build();

                       logger.debug("The Correlation id is : {}",id);
                       return chain.filter(exchange);

        }
    }

