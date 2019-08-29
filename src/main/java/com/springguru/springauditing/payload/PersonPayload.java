package com.springguru.springauditing.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
public class PersonPayload {

    @NotBlank(message = "name is required!")
    private String name;

    @NotBlank(message = "gender is required!")
    private String gender;

    @NotNull(message = "age is required!")
    private Integer age;
}
