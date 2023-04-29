package com.example.UserManagmentSystem.models;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotEmpty
    private Integer userId;

    @NotNull
    @Size(min = 4,max = 16,message = "Kindly give your full name with space")
    private String userName;

    @Pattern(regexp = "\\b\\d{4}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12][0-9]|3[01])\\b")
    private String dateOfBirth;

    @Email
    @NotEmpty
    private String email;

    @Pattern(regexp = "^\\\\+(?:[0-9]){1,3}(?:\\\\([0-9]{1,3}\\\\)|[0-9]{1,3})[0-9]{6,10}$")
    private String phoneNo;
    private String date;
    private String time;
}
