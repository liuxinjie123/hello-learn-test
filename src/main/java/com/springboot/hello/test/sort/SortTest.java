package com.springboot.hello.test.sort;

import com.alibaba.fastjson.JSON;
import com.springboot.hello.dto.UserDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        List<UserDto> userList = new ArrayList<>();
        userList.add(new UserDto("aaa", "15618177577", 30));
        userList.add(new UserDto("bbb", "18621091609", 28));
        userList.add(new UserDto("ccc", "13223878572", 28));

        System.out.println("userList: " + JSON.toJSONString(userList));

        Collections.sort(userList, new Comparator<UserDto>() {
            @Override
            public int compare(UserDto o1, UserDto o2) {
                Integer age1 = o1.getAge();
                Integer age2 = o2.getAge();
                int temp = age1.compareTo(age2);
                if (temp != 0) {
                    return temp;
                }
                String name1 = o1.getName();
                String name2 = o2.getName();
                temp = name2.compareTo(name1);
                return temp;
            }
        });
        System.out.println("userList: " + JSON.toJSONString(userList));
    }
}
