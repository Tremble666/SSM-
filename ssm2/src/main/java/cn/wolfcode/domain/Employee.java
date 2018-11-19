package cn.wolfcode.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {
    private Long id;
    private String name;
    private String password;
    private String email;
    private Integer age;
    private boolean admin;
    private Department dept;
}