package com.springboot.hello.test.calculator;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OperationMultiply extends Operation implements Serializable {
    @Override
    public String getResult() {
        return String.valueOf(num1 * num2);
    }
}
