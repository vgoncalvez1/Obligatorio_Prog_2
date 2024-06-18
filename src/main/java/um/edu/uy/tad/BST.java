package um.edu.uy.tad;

import um.edu.uy.tad.BinarySearchTree;

public class BST<T extends  Comparable<T>> implements BinarySearchTree<T> {
    private class Node{
        T data;
        Node left;
        Node Right;
        Node(T data){
            this.data = data;
            this.left = this.Right = null;
        }
    }

    private Node root;
    private int size;
    @Override
    public void insert(T data) {
        root = insert(root, data);
    }
    private Node insert(Node root, T data){
        if (root == null){
            root = new Node(data);
            return root;
        }
        if (data.compareTo(root.data) < 0){
            root.left = insert(root.left, data);
        }else if (data.compareTo(root.data) > 0){
            root.Right = insert(root.Right, data);
        }
        return root;
    }

    @Override
    public boolean search(T data) {
        return search(root, data);
    }
    private boolean search(Node root, T data){
        if (root == null){
            return false;
        }
        if (data.compareTo(root.data) < 0){
            return search(root.left, data);
        }else if (data.compareTo(root.data) > 0){
            return search(root.Right, data);
        }else {
            return true;
        }
    }

    @Override
    public void delete(T data) {
        root = delate(root, data);
    }

    private Node delate(Node root, T data){
        if (root == null){
            return null;
        }
        if (data.compareTo(root.data) < 0){
            root.left = delate(root.left, data);
        }else if (data.compareTo(root.data) > 0){
            root.Right = delate(root.Right, data);
        }else {
            if (root.left == null){
                size--;
                return root.Right;
            }else if (root.Right == null){
                size--;
                return root.left;
            }
            Node minNode = findMin(root.Right);
            root.data = minNode.data;
            root.Right = delate(root.Right, minNode.data);
        }
        return root;
    }

    private Node findMin(Node root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
