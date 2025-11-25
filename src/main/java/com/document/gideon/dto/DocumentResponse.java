package com.document.gideon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DocumentResponse {

    private Long id;
    private String title;
    private String content;
    private Long userId;
    private LocalDateTime lastModified;
}
