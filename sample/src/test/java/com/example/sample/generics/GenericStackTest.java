package com.example.sample.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericStackTest {

    @Test
    void string() {
        GenericStack<String> genericStack = new GenericStack<>();
        genericStack.push("hoge");

    }

    @Test
    void integer() {
        GenericStack<Integer> genericStack = new GenericStack<>();
        genericStack.push(1);
    }
}