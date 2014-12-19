/**
 * Created by rahulmadhavan on 11/6/14.
 */
public class Stack<T> {

    final private static int DEFAULT_SIZE = 10;
    int index;
    T[] array;
    int size;

    Stack(){
        size = DEFAULT_SIZE;
        index = -1;
        array = (T[]) new Object[size];
    }

    Stack(int s){
        size = s;
        index = -1;
        array = (T[]) new Object[size];
    }

    public void push(T element){
        if(this.index + 1 < this.size){
            this.array[++index] = element;
        }else{
            throw new RuntimeException("Stack is full cant push " + element);
        }
    }

    public T pop(){
       if (!this.isEmpty()){
            return this.array[this.index--];
       }else{
            throw new RuntimeException("Stack is empty");
       }
    }

    public boolean isEmpty(){
        if(this.index == -1){
            return true;
        }else{
            return false;
        }

    }


    public static void main(String[] args) {

        Stack<Integer> s = new Stack<Integer>();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }

}
