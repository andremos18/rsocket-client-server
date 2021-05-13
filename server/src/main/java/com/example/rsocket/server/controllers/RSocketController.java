package com.example.rsocket.server.controllers;

import com.example.rsocket.server.dto.Payload;
import com.example.rsocket.server.dto.Request;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author AMoshkin
 */
@Slf4j
@Controller
public class RSocketController {

    @MessageMapping("fire-and-forget")
    public Mono<Void> fireAndForget(Request request) {
        log.info("Received notification for my-request-response: " + request.getText());
        return Mono.empty();
    }

    @MessageMapping("request-response")
    public Mono<Payload> getRequestResponse(Request request) {
        return Mono.just(Payload.builder()
                .text(request.getText())
                .build());
    }

    @MessageMapping("request-stream")
    public Flux<Payload> getRequestStream(Request request) {
        return Flux.just(Payload.builder()
                .text(request.getText())
                .build());
    }

    @MessageMapping("channel")
    public Flux<Payload> getRequestStream(Publisher<Request> request) {
        return Flux.from(request)
                .delayElements(Duration.ofMillis(10))
                .map(r -> Payload.builder()
                        .text(r.getText())
                        .build());
    }
}
