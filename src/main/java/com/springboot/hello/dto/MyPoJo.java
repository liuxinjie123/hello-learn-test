package com.springboot.hello.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class MyPoJo implements Serializable {
    /**
     * name
     */
    private String name;

    /**
     * description
     */
    private String description;

}
