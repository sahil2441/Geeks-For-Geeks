package tree;

import java.util.ArrayDeque;
import java.util.Queue;

import utilities.Node;

public class LevelOrder {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.setLeft(new Node(5));
		root.setRight(new Node(20));
		root.getLeft().setLeft(new Node(1));
		root.getLeft().setRight(new Node(11));
		root.getRight().setLeft(new Node(19));
		root.getRight().setRight(new Node(21));
		levelOrder(root);
	}

	private static void levelOrder(Node root) {
		Queue queue = new ArrayDeque<>();
		queue.add(root);
		int maxCount = 0;
		int currentCount = 0;

		while (!queue.isEmpty()) {
			Queue queue2 = new ArrayDeque<>();
			currentCount = 0;
			while (!queue.isEmpty()) {

				Node node = (Node) queue.poll();
				System.out.println(node.getData());
				currentCount++;

				if (node.getLeft() != null)
					queue2.add(node.getLeft());

				if (node.getRight() != null)
					queue2.add(node.getRight());
			}
			if (currentCount > maxCount)
				maxCount = currentCount;
			queue = queue2;
		}
		System.out.println("Max Count: " + maxCount);

	}

}
