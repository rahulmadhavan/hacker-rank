package ds;

/**
 * Created by rahulmadhavan on 12/15/14.
 */
public interface Queue<T> {

    void enqueue(T element);

    T remove();

    boolean isEmpty();

}
