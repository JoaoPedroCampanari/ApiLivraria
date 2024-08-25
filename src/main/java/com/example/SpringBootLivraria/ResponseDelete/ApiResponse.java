package com.example.SpringBootLivraria.ResponseDelete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.Link;

public class ApiResponse {

    @NotBlank
    private String message;
    @NotNull
    private Link link;

    public ApiResponse(String message, Link link) {
        this.message = message;
        this.link = link;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
}
