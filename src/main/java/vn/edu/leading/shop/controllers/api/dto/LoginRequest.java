package vn.edu.leading.shop.controllers.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    @NotBlank
    protected String password;
    @NotBlank
    private String username;
}
