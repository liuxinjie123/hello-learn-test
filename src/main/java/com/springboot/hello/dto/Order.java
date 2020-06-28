package com.springboot.hello.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * type
     */
    private Integer type;
}
