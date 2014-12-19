package ds.impl;

import ds.BinaryTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by rahulmadhavan on 12/19/14.
 */
public class BinaryTreeImplTest {

    BinaryTree<Integer> tree;

    @Before
    public void before(){
        tree = new BinaryTreeImpl<Integer>();
    }

    @After
    public void after(){
        tree = null;
    }

    @Test
    public void inOrderShouldReturnNodesInOrder(){
        tree.insert(10);
        tree.insert(11);
        tree.insert(15);
        tree.insert(16);
        tree.insert(14);
        tree.insert(8);
        tree.insert(9);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        tree.insert(4);

        List<Integer> list = tree.inOrder();
        Integer[] array = {1, 3, 4, 7, 8, 9, 10, 11, 14 ,15, 16};

        assertArrayEquals("nodes should be the same as inserted and in order",array,list.toArray());

    }

    @Test
    public void preOrderShouldReturnNodesInPreOrder(){
        tree.insert(10);
        tree.insert(11);
        tree.insert(15);
        tree.insert(16);
        tree.insert(14);
        tree.insert(8);
        tree.insert(9);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        tree.insert(4);
        tree.insert(7);

        List<Integer> list = tree.preOrder();
        Integer[] array = {10, 8, 7, 1, 3, 4, 7, 9, 11, 15, 14, 16};

        assertArrayEquals("nodes should be the same as inserted and in pre order",array,list.toArray());

    }

    @Test
    public void postOrderShouldReturnNodesInPostOrder(){
        tree.insert(10);
        tree.insert(11);
        tree.insert(15);
        tree.insert(16);
        tree.insert(14);
        tree.insert(8);
        tree.insert(9);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        tree.insert(4);

        List<Integer> list = tree.postOrder();
        Integer[] array = {4, 3, 1, 7, 9, 8, 14, 16, 15, 11, 10};

        assertArrayEquals("nodes should be the same as inserted and in post order",array,list.toArray());

    }

    @Test
    public void removeShouldRemoveTheNodeFromTheTreeMaintainingTheOrder(){
        tree.insert(10);
        tree.insert(11);
        tree.insert(15);
        tree.insert(16);
        tree.insert(14);
        tree.insert(8);
        tree.insert(9);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        tree.insert(4);
        tree.insert(7);


        tree.remove(7);
        List<Integer> list = tree.inOrder();
        Integer[] array = {1, 3, 4, 7, 8, 9, 10, 11, 14 ,15, 16};

        assertArrayEquals("nodes should be the same as inserted and in In Order",array,list.toArray());

        List<Integer> list1 = tree.postOrder();
        Integer[] array1 = {3, 1, 7, 4, 9, 8, 14, 16, 15, 11, 10};

        assertArrayEquals("nodes should be the same as inserted and in post order",array1,list1.toArray());


    }



}
