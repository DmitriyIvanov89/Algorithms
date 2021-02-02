package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    public static void main(String[] args) {

        Tree root = new Tree(20,
                    new Tree(7,
                            new Tree(4,null,new Tree(6)),new Tree(9)),
                    new Tree(35,
                            new Tree(31,new Tree(28),null),
                            new Tree(40,new Tree(38),new Tree(52))));

        System.out.println("Обход в глубину: ");
        deep(root);
        System.out.println("----------------");
        System.out.println("Обход в ширину: ");
        wild(root);
        System.out.println();
        System.out.println("-----------------");
    }
    static class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value,Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }
    }
    public static void deep (Tree root) {
        Stack<Tree> deepSum = new Stack<>();
        deepSum.push(root);
        while (!deepSum.isEmpty()) {
            Tree node = deepSum.pop();
            System.out.println(node.value);
            if (node.right != null) {
                deepSum.push(node.right);
            }
            if (node.left != null) {
                deepSum.push(node.left);
            }
        }
    }
    public static void wild (Tree root) {
        Queue<Tree> wildSum = new LinkedList<>();
        wildSum.add(root);
        while (!wildSum.isEmpty()) {
            Tree node = wildSum.remove();
            System.out.print(node.value + " ");
            if (node.right != null) {
                wildSum.add(node.right);
            }
            if (node.left != null) {
                wildSum.add(node.left);
            }
        }
    }
}
