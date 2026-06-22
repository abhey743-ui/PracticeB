//package com.Apigateway.CorelationFilters;
//
//import jakarta.ws.rs.core.Cookie;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpCookie;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//
//import java.io.ObjectInputFilter;
//import java.util.List;
//
//@Component
//public class CustomPreFilter extends AbstractGatewayFilterFactory<CustomPreFilter.Config> {
//
//    public CustomPreFilter() {
//        super(Config.class);
//    }
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        return (exchange, chain) -> {
//
//            MultiValueMap<String, HttpCookie> cookies = exchange.getRequest().getCookies();
//
//            if (cookies == null || cookies.isEmpty()) {
//                throw new RuntimeException("This is invalid request");
//            }
//
//            return chain.filter(exchange);
//        };
//    }
//
//    public static class Config {
//        // If you want to pass values from YAML, define fields here
//        // Example: private boolean enabled;
//    }
//}
//
//
