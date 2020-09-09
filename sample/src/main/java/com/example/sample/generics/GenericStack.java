package com.example.sample.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericStack<E> {
    private final List<E> taskList;

    public GenericStack() {
        taskList = new ArrayList<>();
    }

    public void push (E task) {
        taskList.add(task);
    }

    public E pop() {
        if (taskList.isEmpty()) {
            return null;
        }
        return taskList.remove(taskList.size()-1);
    }
}
