package com.example.rsocket.publisher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Service;

/**
 * @author AMoshkin
 */
@Service
public class MessagePublisher {

    @Autowired
    private RSocketRequester rSocketRequester;

    @EventListener(ApplicationStartedEvent.class)
    public void init() {
        rSocketRequester.route("ticket.save").data("");
    }
}
