package com.springboot.hello.test.calculator;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OperationMultiply extends Operation implements Serializable {
    @Override
    public String getResult() {
        return String.valueOf(params.num1 * params.num2);
    }
}
