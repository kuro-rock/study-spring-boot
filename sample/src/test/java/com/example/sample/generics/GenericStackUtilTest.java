package com.example.sample.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericStackUtilTest {

    @Test
    void as() {
        List<String> stringList = new ArrayList<>();

        stringList.add("hoge");
        stringList.add("fuga");

        GenericStack<String> genericStack = GenericStackUtil.as(stringList);
        System.out.println(genericStack.pop());
    }
}