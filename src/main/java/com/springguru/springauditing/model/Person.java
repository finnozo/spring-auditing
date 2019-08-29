package com.springguru.springauditing.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "person")
@Setter
@Getter
@ToString
public class Person extends BaseAudit<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Long id;

    @NotBlank(message = "name is required!")
    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "gender")
    @NotBlank(message = "gender is required!")
    private String gender;

    @Column(nullable = false, name = "age")
    @NotNull(message = "age is required!")
    private int age;
}
