package com.xavier.kownledge;

import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Optional;

public class StringTest {


    class User {
        String name = "we";
    }

    @Test
    public void StringDemo_01() throws Exception {
        User user = new User();
        Field name = user.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(user, "de");
        System.out.println(user.name);
    }

    @Test
    public void StringDemo() throws Exception {
        String s = new String("abc");
        System.out.println(s.hashCode());
        //System.out.println(s);
        System.out.println("==============================");
        // 在这中间可以添加N⾏代码，但必须保证s引⽤的指向不变，最终将输出变成abcd
        Class<? extends String> strClass = s.getClass();
        Field value = strClass.getDeclaredField("value");
        value.setAccessible(true);
        value.set(s, "abcd".toCharArray());
        System.out.println(s);
        System.out.println(s.hashCode());
    }

    @Test
    public void StringDemo_02() {
        String s1 = new String("abc");
        String s2 = "abc"; // s1 == s2? false
        String s3 = s1.intern(); // s2 == s3?  true
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
    }

    /*IntegerCache --->  [-128, 127]*/
    @Test
    public void Demo_04() {
        Integer i1 = 100;
        Integer i2 = 100; // i1 == i2? true
        Integer i3 = 128;
        Integer i4 = 128; // i3 == i4? false
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }

    @Test
    public void Demo_03() {
        final int i;
        int j;
        //System.out.println(i);
    }

    @Test
    public void Demo_05() {
        Person person = null;
        String s = Optional.ofNullable(person).map(Person::getName).orElse("null");
        String s1 = Optional.ofNullable(person).map(Person::getName).orElseGet(null);
        System.out.println(s);
        System.out.println(s1);
    }

    @Getter
    public class Person {
        private String name;
        private Integer age;

        public Person() {
            this.name = "name";
        }
    }

}
