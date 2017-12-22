package ctcicommon;

import java.util.*;

public class BSTNode <T extends Comparable<?>> {

	public BSTNode<T> left;
	public BSTNode<T> right;
	public T data;

	public BSTNode(T value) {
		this.left = null;
		this.right = null;
		this.data = value;
	}
	
    public static <T extends Comparable<?>> void printNode(BSTNode<T> root) {
        int maxLevel = BSTNode.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<BSTNode<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BSTNode.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BSTNode.printWhitespaces(firstSpaces);

        List<BSTNode<T>> newNodes = new ArrayList<BSTNode<T>>();
        for (BSTNode<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BSTNode.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
            	BSTNode.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                	BSTNode.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                	BSTNode.printWhitespaces(1);

                BSTNode.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                	BSTNode.printWhitespaces(1);

                BSTNode.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(BSTNode<T> node) {
        if (node == null)
            return 0;

        return Math.max(BSTNode.maxLevel(node.left), BSTNode.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
	
}
