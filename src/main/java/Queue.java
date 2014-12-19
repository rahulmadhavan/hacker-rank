import java.util.NoSuchElementException;

/**
 * Created by rahulmadhavan on 11/6/14.
 */

interface Queue{

    void enqueue(int element);

    int dequeue();

}

class ArrayQueue implements Queue{

    private static final int DEFAULT_SIZE = 5;
    int[] array;
    int first;
    int last;
    int size;

    public ArrayQueue(){
        array = new int[DEFAULT_SIZE];
        size = DEFAULT_SIZE;
        first = 0;
        last = 0;
    }

    public void enqueue(int element) {
        if((last+1)%size == first){
            throw new RuntimeException("Queue is full. cant add " + element);
        }else{
            array[last] = element;
            last = (last + 1) % size;
        }
    }

    public int dequeue() {
        if(first == last){
            throw new RuntimeException("Queue is empty");
        }else{
            int element = array[first];
            first = (first + 1) % size;
            return element;
        }
    }

    public static void main(String[] args) {

        Queue q = new ArrayQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

    }

}


class LinkedQueue implements Queue{

    Item first;
    Item last;

    public LinkedQueue(){
        first = null;
        last = null;
    }

    public int dequeue(){
        if(this.isEmpty()){
            throw new NoSuchElementException("The queue is empty");
        }else{
            Item oldFirst = this.first;
            this.first = this.first.getNext();
            if(this.first == null){
                last = null;
            }
            return oldFirst.getValue();
        }
    }

    public void enqueue(int value){
        if(last == null){
            first = new Item(value,null);
            last = first;
        }else{
            Item newLast = new Item(value,last);
            last.setNext(newLast);
            last = newLast;
        }
    }

    public boolean isEmpty(){
        if(null == first){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        Queue q = new LinkedQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.dequeue());

    }

}


class Item{


    private int value;
    private Item previous;
    private Item next;


    public Item(int val, Item previous){
        this.value = val;
        this.previous = previous;
        this.next = null;

    }

    int getValue(){
        return value;
    }

    void setPrevious(Item item){
        this.previous = item;
    }

    Item getPrevious(){
        return this.previous;
    }

    void setNext(Item item){
        this.next = item;
    }

    Item getNext(){
        return this.next;
    }
}

