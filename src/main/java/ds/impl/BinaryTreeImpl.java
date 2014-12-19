package ds.impl;

import ds.BinaryTree;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by rahulmadhavan on 12/16/14.
 */
public class BinaryTreeImpl<T extends Comparable<T>> implements BinaryTree<T> {

    Node<T> root;

    public BinaryTreeImpl(){
        root = null;
    }

    public BinaryTreeImpl(T value){
        root = new Node<T>(value);
    }


    @Override
    public void insert(T val) {
        if(null == root){
            root = new Node<T>(val);
        }else{
            insert(root,val);
        }
    }


    private void insert(Node<T> node, T val) {
        int result = node.value.compareTo(val);

        if(result > 0){
            if(null != node.left){
                this.insert(node.left, val);
            }else{
                node.left = new Node<T>(val);
                node.left.parent = node;
            }
        }else {
            if(null != node.right){
                this.insert(node.right, val);
            }else{
                node.right = new Node<T>(val);
                node.right.parent = node;
            }
        }
    }

    @Override
    public void remove(T val) {
        if(null == root){
            return;
        }else{
            remove(root, val);
        }
    }

    private void remove(Node<T> node, T val){
        int result = node.value.compareTo(val);

        if(result == 0){
            removeNode(node);
        }else if(result > 0){
            if (null == node.left){
                return;
            }
            this.remove(node.left,val);
        }else{
            if (null == node.right){
                return;
            }
            this.remove(node.right,val);
        }

    }

    private void removeNode(Node<T> node){
        if(null == node.left && null == node.right){
            if(node.parent == null){
                root = null;
            }else{
                if(node.parent.left == node){
                    node.parent.left = null;
                }else{
                    node.parent.right = null;
                }
            }
        }else if(null == node.left){
            node.right.parent = node.parent;
            if(node.parent.left == node){
                node.parent.left = node.right;
            }else{
                node.parent.right = node.right;
            }
        }else if(null == node.right){
            node.left.parent = node.parent;
            if(node.parent.left == node){
                node.parent.left = node.left;
            }else{
                node.parent.right = node.left;
            }
        }else{
            Node<T> maxNode = maxNodeInTree(node.left);
            node.value = maxNode.value;
            removeNode(maxNode);
        }

    }

    private Node<T> maxNodeInTree(Node<T> node){
        if(null == node.right){
            return node;
        }else{
            return maxNodeInTree(node.right);
        }
    }

    public List<T> inOrder(){
        if(root == null){
            return new ArrayList<T>();
        }else{
            return inOrder(root,new ArrayList<T>());
        }
    }


    private List<T> inOrder(Node<T> node,List<T> list){
        if(null != node.left){
            this.inOrder(node.left, list);
        }
        list.add(node.value);
        if(null != node.right){
            this.inOrder(node.right,list);
        }

        return list;
    }

    public List<T> preOrder(){
        if(root == null){
            return new ArrayList<T>();
        }else{
            return preOrder(root,new ArrayList<T>());
        }
    }


    private List<T> preOrder(Node<T> node,List<T> list){
        list.add(node.value);
        if(null != node.left){
            this.preOrder(node.left, list);
        }
        if(null != node.right){
            this.preOrder(node.right,list);
        }

        return list;
    }


    public List<T> postOrder(){
        if(root == null){
            return new ArrayList<T>();
        }else{
            return postOrder(root,new ArrayList<T>());
        }
    }


    private List<T> postOrder(Node<T> node,List<T> list){
        if(null != node.left){
            this.postOrder(node.left, list);
        }
        if(null != node.right){
            this.postOrder(node.right,list);
        }
        list.add(node.value);

        return list;
    }


    class Node<T>{

        T value;
        Node<T> left;
        Node<T> right;
        Node<T> parent;

        public Node(T value){
            this.value = value;
            left = null;
            right = null;
            parent = null;

        }

    }


}
