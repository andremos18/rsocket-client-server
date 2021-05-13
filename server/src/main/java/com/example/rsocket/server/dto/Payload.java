package com.example.rsocket.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author AMoshkin
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payload {
    private String text;
}
