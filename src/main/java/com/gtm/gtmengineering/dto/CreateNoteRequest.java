package com.gtm.gtmengineering.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateNoteRequest(
    @NotBlank 
    @Size(max = 200) 
    String text
) {

}
