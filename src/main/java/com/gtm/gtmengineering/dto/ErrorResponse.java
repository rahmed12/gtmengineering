package com.gtm.gtmengineering.dto;

public record ErrorResponse(
    int status,
    String error,
    String message
) {
}
