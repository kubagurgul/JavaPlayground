package com.jgurgul.j13.generics;

import java.util.ArrayList;
import java.util.Collection;

public class Stack<E> {

    private ArrayList<E> arr = new ArrayList<E>();

    public void pushAll(Iterable<? extends E> src) {
        for (E e: src) {
            push(e);
        }
    }

    public void popAll(Collection<? super E> dst) {
        while(!arr.isEmpty()) {
            dst.add(pop());
        }
    }

    public void push(E el) {
        arr.add(el);
    }

    public E pop() {
        return arr.remove(arr.size()-1);
    }

    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>();
        stack.push(1l);
        stack.push(2);
        stack.push(2.2);

        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(11);
        ints.add(12);

        stack.pushAll(ints);

        System.out.println(stack.pop());
        System.out.println(stack.pop());


        Collection<Object> ci = new ArrayList<>();
        stack.popAll(ci);


    }
}
