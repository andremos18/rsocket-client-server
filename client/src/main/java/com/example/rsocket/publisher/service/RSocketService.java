package com.example.rsocket.publisher.service;

import com.example.rsocket.publisher.dto.Request;
import com.example.rsocket.publisher.dto.Payload;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author AMoshkin
 */
@Service
@RequiredArgsConstructor
public class RSocketService {

    private final RSocketRequester rSocketRequester;

    public Mono<Void> fireAndForget(Request request) {
        return rSocketRequester.route("fire-and-forget!")
                .data(request)
                .send();
    }

    public Mono<Payload> getRequestResponse(Request request) {
        return rSocketRequester.route("request-response")
                .data(request)
                .retrieveMono(Payload.class);
    }

    public Flux<Payload> getRequestStream(Request request) {
        return rSocketRequester.route("request-stream")
                .data(request)
                .retrieveFlux(Payload.class);
    }

    public Flux<Payload> getRequestStream(Flux<Request> request) {
        return rSocketRequester.route("channel")
                .data(request)
                .retrieveFlux(Payload.class);
    }

}
