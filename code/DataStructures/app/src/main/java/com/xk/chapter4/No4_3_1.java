package com.xk.chapter4;

import static javax.swing.text.html.HTML.Attribute.N;
import static javax.swing.text.html.HTML.Tag.I;
import static sun.java2d.cmm.ColorTransform.In;

/**
 * Created by xuekai on 2017/4/24.
 */

public class No4_3_1 {
    public static void main(String args[]) {
        No4_3_1 self = new No4_3_1();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.printTree();
        BinarySearchTree.Node insert = binarySearchTree.insert(9);
        System.out.println();
        System.out.println(insert.getValue());
        binarySearchTree.printTree();
        System.out.println();
        binarySearchTree.remove(22);
        binarySearchTree.printTree();
    }

}


/**
 * 二叉搜索树
 */
class BinarySearchTree {
    private Node root;


    public void init() {
        Node node2 = new Node(2);
        Node node6 = new Node(6);
        Node node10 = new Node(10);
        Node node16 = new Node(16);
        Node node20 = new Node(20);
        Node node24 = new Node(24);
        Node node28 = new Node(28);
        Node node32 = new Node(32);
        Node node4 = new Node(4, node2, node6);
        Node node12 = new Node(12, node10, null);
        Node node8 = new Node(8, node4, node12);
        Node node18 = new Node(18, node16, node20);
        Node node22 = new Node(22, node18, node24);
        Node node30 = new Node(30, node28, node32);
        Node node26 = new Node(26, node22, node30);
        Node node14 = new Node(14, node8, node26);
        root = node14;

    }

    public BinarySearchTree() {
        this.root = null;
        init();
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

    public Node insert(Integer v) {
        return insert(v, root);
    }

    public Node remove(Integer v) {
        return remove(v,root);
    }

    public void printTree() {
        printMiddleTree(root);
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
     * @param v
     * @param n
     * @return 根节点
     */
    public Node insert(Integer v, Node n) {
        if (n == null) {//遍历到某个节点，他是空的，那就往这里放
            return new Node(v);
        }
        if (n.value > v) {
            n.leftNode = insert(v, n.leftNode);
        }
        if (n.value < v) {
            n.rightNode = insert(v, n.rightNode);
        }
        if (n.value == v) {
//            不考虑重复情况
        }
        return n;
    }

    /**
     * 如果是叶子节点，直接删除就好了，如果有孩子，就需要绕过
     *
     * @param v
     * @param n
     * @return
     */
    public Node remove(Integer v, Node n) {
        if (n == null) {
            return n;
        }
        if (n.value > v) {
            n.leftNode = remove(v, n.leftNode);
        } else if (n.value < v) {
            n.rightNode = remove(v, n.rightNode);
        } else {//要移除该node
            if(n.leftNode!=null&&n.rightNode!=null){
                //有两个孩子
                n.value=findMin(n.rightNode).value;
                n.rightNode = remove(n.value, n.rightNode);
            }else {
                n=(n.leftNode!=null)?n.leftNode:n.rightNode;
            }
        }
        return n;
    }

    /**
     * 先序遍历
     *
     * @param n
     */

    public void printTree(Node n) {
        if (n != null) {
            System.out.println(n.value);
            printTree(n.leftNode);
            printTree(n.rightNode);
        }
    }

    /**
     * 中序遍历
     *
     * @param n
     */
    public void printMiddleTree(Node n) {
        if (n != null) {
            printMiddleTree(n.leftNode);
            System.out.print(n.value + " ");
            printMiddleTree(n.rightNode);
        }
    }

    /**
     * 节点，是一个内部类,实现了Comparable接口，因为二叉搜索树需要保证左子树的所有项小于节点，右子树所有项大于节点，
     * 所以肯定需要可以比较大小的能力,为了简单起见，直接让元素为int
     */
    public class Node {
        private Integer value;
        private Node leftNode;
        private Node rightNode;

        public Integer getValue() {
            return value;
        }

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
