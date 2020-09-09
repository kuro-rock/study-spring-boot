package com.example.sample.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringStackTest {


    @Test
    void push() {
        StringStack stringStack = new StringStack();
        stringStack.push("a");
        System.out.println(stringStack.getTaskList());
    }

    @Test
    void pop() {
        StringStack stringStack = new StringStack();
        stringStack.push("b");
        System.out.println(stringStack.pop());
    }
}