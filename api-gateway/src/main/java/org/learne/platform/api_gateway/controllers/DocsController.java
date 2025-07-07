package org.learne.platform.api_gateway.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

import java.net.URI;

public class DocsController {

    @GetMapping("/public/docs")
    public Mono<Void> redirectToSwaggerUi(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.FOUND);
        response.getHeaders().setLocation(URI.create("/swagger-ui/index.html"));
        return response.setComplete();
    }
}
