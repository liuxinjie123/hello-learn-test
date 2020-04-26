package com.springboot.hello.test.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation implements Serializable {
    protected OperationParams params;

    public String getResult() {
        return null;
    }

}
