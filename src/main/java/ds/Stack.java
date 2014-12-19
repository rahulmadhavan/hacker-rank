package ds;

/**
 * Created by rahulmadhavan on 12/14/14.
 */
public interface Stack<T> {

    void push(T element);

    T pop();

    boolean isEmpty();

    T peek();

}
