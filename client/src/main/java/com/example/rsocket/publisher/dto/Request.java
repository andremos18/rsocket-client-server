package com.example.rsocket.publisher.dto;

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
public class Request {
    private String text;
}
