package com.example.rsocket.publisher.controllers;

import com.example.rsocket.publisher.dto.Payload;
import com.example.rsocket.publisher.dto.Request;
import com.example.rsocket.publisher.service.RSocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author AMoshkin
 */
@RestController
@RequiredArgsConstructor
public class RSocketController {

    private final RSocketService rSocketService;

    @PostMapping("/fire-and-forget")
    public Mono<Void> fireAndForget(@RequestBody Request request) {
        return rSocketService.fireAndForget(request);
    }

    @PostMapping("/request-response")
    public Mono<Payload> getRequestResponse(@RequestBody Request request) {
        return rSocketService.getRequestResponse(request);
    }

    @PostMapping("/request-stream")
    public Flux<Payload> getRequestStream(@RequestBody Request request) {
        return rSocketService.getRequestStream(request);
    }

    @PostMapping("/channel")
    public Flux<Payload> getChannel(@RequestBody List<Request> requests) {
        return rSocketService.getRequestStream(Flux.fromIterable(requests));
    }
}
