package um.edu.uy;

public class BST<T extends  Comparable<T>> implements BinarySearchTree<T>{
    private class Node{
        T element;
        Node left;
        Node Right;
        Node(T element){
            this.element = element;
        }
    }

    private Node root;
    private int size;
    @Override
    public void insert(T element) {
        root = insert(root, element);
    }
    private Node insert(Node node, T element){
        if (node == null){
            size++;
            return new Node(element);
        }
        if (element.compareTo(node.element) < 0){
            node.left = insert(node.left, element);
        }else if (element.compareTo(node.element) > 0){
            node.Right = insert(node.Right, element);
        }
        return node;
    }

    @Override
    public boolean search(T element) {
        return search(root, element);
    }
    private boolean search(Node node, T element){
        if (node == null){
            return false;
        }
        if (element.compareTo(node.element) < 0){
            return search(node.left, element);
        }else if (element.compareTo(node.element) > 0){
            return search(node.Right, element);
        }else {
            return true;
        }
    }

    @Override
    public void delete(T element) {
        root = delate(root, element);
    }

    private Node delate(Node node, T element){
        if (node == null){
            return null;
        }
        if (element.compareTo(node.element) < 0){
            node.left = delate(node.left, element);
        }else if (element.compareTo(node.element) > 0){
            node.Right = delate(node.Right, element);
        }else {
            if (node.left == null){
                size--;
                return node.Right;
            }else if (node.Right == null){
                size--;
                return node.left;
            }
            Node minNode = findMin(node.Right);
            node.element = minNode.element;
            node.Right = delate(node.Right, minNode.element);
        }
        return node;
    }

    private Node findMin(Node node){
        while (node.left != null){
            node = node.left;
        }
        return node;
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
