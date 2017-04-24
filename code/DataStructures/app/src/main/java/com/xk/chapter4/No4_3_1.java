package com.xk.chapter4;

import static javax.swing.text.html.HTML.Attribute.N;
import static javax.swing.text.html.HTML.Tag.I;
import static sun.java2d.cmm.ColorTransform.In;

/**
 * Created by xuekai on 2017/4/24.
 */

public class No4_3_1 {
    public static void main(String args[]) {

    }
}


/**
 * 二叉搜索树
 */
class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contain(Integer value) {
        return contain(value, root);
    }

    /**
     * 返回某个节点下是否有某个值
     *
     * @param value
     * @param node
     * @return
     */
    public boolean contain(Integer value, Node node) {
        if (node == null) {
            return false;
        }
        if (node.value.compareTo(value) > 0) {
            return contain(value, node.leftNode);
        } else if (node.value.compareTo(value) < 0) {
            return contain(value, node.rightNode);
        } else {
            return node.value.compareTo(value) == 0;
        }
    }

    public Integer findMin() {
        return 0;
    }

    public Integer findMax() {
        return 0;
    }

    public void insert(Integer v) {

    }

    public void remove(Integer v) {

    }

    public void printTree() {

    }

    /**
     * 在n下找最小的node
     * 由于二叉查找树的特性，有左孩子，就往左孩子中找(用递归的方法找)
     *
     * @param n
     * @return
     */
    public Node findMin(Node n) {
        if (n == null) {
            return n;
        }
        if (n.leftNode != null) {
            return findMin(n.leftNode);
        }
        return n;
    }

    /**
     * 在n下找最大的node
     * 由于二叉查找树的特性，有右孩子，就往右孩子中找(用非递归的方法找)
     *
     * @param n
     * @return
     */
    public Node findMax(Node n) {
        if (n != null) {
            while (n.rightNode != null) {
                n = n.rightNode;
            }
        }
        return n;
    }

    /**
     * 书上的没看懂
     * @param v
     * @param n
     * @return
     */
    public Node insert(Integer v, Node n) {
        if (n.value>v) {
            if(n.leftNode==null){
                Node node = new Node(v);
                n.leftNode=node;
                return node;
            }
            return insert(v,n.leftNode);
        }else if(n.value<v){
            if(n.rightNode==null){
                Node node = new Node(v);
                n.rightNode=node;
                return node;
            }
            return insert(v,n.rightNode);
        }
        return null;
    }

    public Node remove(Integer v, Node n) {
        return null;
    }

    public void printTree(Node n) {

    }

    /**
     * 节点，是一个内部类,实现了Comparable接口，因为二叉搜索树需要保证左子树的所有项小于节点，右子树所有项大于节点，
     * 所以肯定需要可以比较大小的能力,为了简单起见，直接让元素为int
     */
    private class Node {
        private Integer value;
        private Node leftNode;
        private Node rightNode;

        public Node(Integer value) {
            this(value, null, null);
        }

        public Node(Integer value, Node leftNode, Node rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }
}
