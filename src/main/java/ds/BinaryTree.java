package ds;


import java.util.List;

/**
 * Created by rahulmadhavan on 12/16/14.
 */
public interface BinaryTree<T extends Comparable<T>> {

    void insert(T val);

    void remove(T val);

    List<T> inOrder();

    List<T> preOrder();

    List<T> postOrder();

}
