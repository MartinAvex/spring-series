package com.xavier.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.beans.ConstructorProperties;

@Data
@NoArgsConstructor
@ToString
public class UserModel {

    private String name;

    private Integer age;

    private String description;

    public UserModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /*
    * java通过反射的方式可以获取到方法的参数名称，不过源码中的参数通过编译之后会变成class对象，通常情况下源码变成class文件之后，参数的真实名称会丢失，参数的名称会变成arg0,arg1,arg2这样的，
    * 和实际参数名称不一样了，如果需要将源码中的参数名称保留在编译之后的class文件中，编译的时候需要用下面的命令：javac -parameters XXX
    * 但是我们难以保证编译代码的时候，操作人员一定会带上-parameters参数，所以方法的参数可能在class文件中会丢失，导致反射获取到的参数名称和实际参数名称不符。
    * 参数名称可能不稳定的问题，spring提供了解决方案，通过ConstructorProperties注解来定义参数的名称，将这个注解加在构造方法上面
    * */

    @ConstructorProperties({"name", "description", "age"})
    public UserModel(String name, String description, Integer age) {
        this.name = name;
        this.description = description;
        this.age = age;
    }
}
