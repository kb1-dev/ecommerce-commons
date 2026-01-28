package com.kbl.ecommerce.commons.data.dto;

import lombok.*;

import java.time.Instant;

@Builder
@Data
public class ApiErrorDto {
    private Instant timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

}
