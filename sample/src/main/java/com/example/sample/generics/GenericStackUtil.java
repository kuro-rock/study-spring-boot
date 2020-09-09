package com.example.sample.generics;

import java.util.List;

public class GenericStackUtil {

    public static <T> GenericStack<T> as(List<T> list) {
        GenericStack<T> genericStack = new GenericStack<>();
        list.forEach(genericStack::push);
        return genericStack;
    }
}
