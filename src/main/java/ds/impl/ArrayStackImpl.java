package ds.impl;

import ds.Stack;

/**
 * Created by rahulmadhavan on 12/14/14.
 *
 */
public class ArrayStackImpl<T> implements Stack<T>{

    private T[] array;
    private int size;
    private int index;

    public ArrayStackImpl(int size){
        this.size = size;
        this.array = (T[])new Object[size];
        this.index = 0;
    }

    @Override
    public void push(T element) {
        if(size == index){
            throw new RuntimeException("Stack is full");
        }
        array[index++] = element;
    }

    @Override
    public T pop() {
        if(this.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return array[--index];
    }

    @Override
    public boolean isEmpty() {
        return (0 == index);
    }

    @Override
    public T peek() {
        if(this.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return array[index - 1];
    }

}
