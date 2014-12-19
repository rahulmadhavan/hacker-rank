package ds.impl;

import com.sun.jmx.remote.internal.ArrayQueue;
import ds.Queue;

/**
 * Created by rahulmadhavan on 12/15/14.
 */
public class ArrayQueueImpl<T> implements Queue<T>{

    private T[] array;
    private int head;
    private int tail;
    private int size;

    public ArrayQueueImpl(int size){
        this.size = size + 1;
        this.array = (T[])new Object[size + 1];
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public void enqueue(T element) {
        if((tail + 1)%size == head){
            throw new RuntimeException("Queue is full");
        }
        array[tail] = element;
        tail = (tail + 1) % size;
    }

    @Override
    public T remove() {
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        T element = array[head];
        head = (head + 1) % size;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return (head == tail);
    }


}
