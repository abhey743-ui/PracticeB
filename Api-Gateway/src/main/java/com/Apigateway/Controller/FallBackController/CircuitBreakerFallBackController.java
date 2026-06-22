package com.Apigateway.Controller.FallBackController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class CircuitBreakerFallBackController {

    @GetMapping("/fallback")
    public Mono<String> Fallback(){
                  return Mono.just("Please try again later the service is not available");
    }
}
