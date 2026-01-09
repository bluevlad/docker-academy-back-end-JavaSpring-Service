package com.academy.backend.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("null")
public class HelloController {

    @GetMapping("/old-home")
    public ResponseEntity<String> hello() {
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<style>\n" +
                "body { font-family: Arial, sans-serif; text-align: center; margin-top: 50px; }\n" +
                "h1 { color: #333; }\n" +
                ".links { margin: 20px 0; }\n" +
                ".links a { display: block; margin: 10px; color: #007bff; text-decoration: none; }\n" +
                ".copyright { margin-top: 50px; font-size: 0.9em; color: #666; }\n" +
                ".image-container { margin-bottom: 20px; }\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"image-container\">\n" +
                "<img src=\"/images/logo.png\" alt=\"Academy Logo\" width=\"150\">\n" +
                "</div>\n" +
                "<h1>Hello, Unmong Systems!</h1>\n" +
                "<div class=\"links\">\n" +
                "<a href=\"http://www.unmong.com:8080/swagger-ui/index.html\">Online Academy Back-end Api Swagger-Ui : http://www.unmong.com:8080/swagger-ui/index.html</a>\n"
                +
                "<a href=\"http://www.unmong.com:3000\">Online Academy Frong-end Ui : http://www.unmong.com:3000</a>\n"
                +
                "</div>\n" +
                "<div class=\"copyright\">\n" +
                "<p><strong>Copyright</strong><br>UM Systems</p>\n" +
                "<p>Copyright (c) 2021 운몽시스템즈(UM Systems). All rights reserved.</p>\n" +
                "<p>이 소프트웨어는 운몽시스템즈(UM Systems)의 독점 소유이며, 저작권법에 의해 보호됩니다.<br>\n" +
                "본 소프트웨어의 무단 복제, 배포, 수정, 재배포는 법적으로 금지되어 있습니다.</p>\n" +
                "<p>This software is the exclusive property of UM Systems and is protected by copyright law.<br>\n" +
                "Unauthorized copying, distribution, modification, or redistribution of this software is prohibited by law.</p>\n"
                +
                "</div>\n" +
                "</body>\n" +
                "</html>";

        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(html);
    }
}
