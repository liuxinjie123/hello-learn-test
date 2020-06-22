package com.springboot.hello.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserDto implements Serializable {
    /**
     * name
     */
    private String name;
    /**
     * phone
     */
    private String phone;
    /**
     * age
     */
    private Integer age;

    public UserDto(String name, String phone, int age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }
}
