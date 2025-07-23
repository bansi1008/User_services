package com.example.demo.Dto;
import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse  {
    private String message;
    private LocalDateTime timestamp;
    private int statusCode;
    private String error;
    private String path;

   

    
}
