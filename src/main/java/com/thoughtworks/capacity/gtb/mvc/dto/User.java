package com.thoughtworks.capacity.gtb.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;

    @NotBlank
    @Pattern(regexp = "[0-9A-Za-z_]{3,10}")
    @Length(min = 3,max = 10)
    private String username;

    @NotBlank
    @Length(min = 5,max = 12)
    private String password;

    @Email
    private String email;
}
