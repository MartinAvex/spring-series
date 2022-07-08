package com.xavier.demo01.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
public class User {

    private String name;

    private Integer age;

    public User() {
        this.name = "No Arguments Constructor Methods!";
    }
}
