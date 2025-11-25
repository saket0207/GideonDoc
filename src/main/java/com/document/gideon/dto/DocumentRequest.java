package com.document.gideon.dto;


import com.document.gideon.respository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class DocumentRequest {

    private String title;
    private String content;
    private Long userId;

}
