package com.ysw.demojpa.entity;

import javax.persistence.*;

@Entity
//告诉spring这是一个实体类
@Table(name = "myUser")//指定该POJO类与数据库中的某个表映射
public class User {
    @Id//标注一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增长
    private Integer id;
    @Column(length = 50)//标注数据表的属性，可以用name，length等自定义
    private String name;
    @Column//默认列名就是属性名,也可以不用注解
    private String age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
