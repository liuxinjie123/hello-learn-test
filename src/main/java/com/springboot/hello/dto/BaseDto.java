package com.springboot.hello.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BaseDto implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * name
     */
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
