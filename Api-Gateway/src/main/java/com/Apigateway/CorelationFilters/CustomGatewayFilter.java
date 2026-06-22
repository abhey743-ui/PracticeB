//package com.Apigateway.CorelationFilters;
//
//
//import lombok.AllArgsConstructor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//
//@Component
//@AllArgsConstructor
//public class CustomGatewayFilter implements GatewayFilter {
//
//    private static final Logger logger =
//            LoggerFactory.getLogger(CustomGatewayFilter.class);
////
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//          return chain.filter(exchange).then(Mono.fromRunnable(()->{
//                  String id = String.valueOf(exchange.getRequest().getHeaders().get("CORRELATION_ID"));
//                   logger.debug("the gateway filter running fine : {}", id);
//
//          }));
//    }
//}
