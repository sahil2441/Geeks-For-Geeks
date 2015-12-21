package tree;

import utilities.Node;

public class HeightBalancedTree {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.setLeft(new Node(5));
		root.setRight(new Node(20));
		System.out.println(isHeightBalanced(root));
	}

	private static boolean isHeightBalanced(Node root) {
		return height(root) != -1;
	}

	private static int height(Node root) {
		if (root == null)
			return 0;
		if (height(root.getLeft()) == -1)
			return -1;
		if (height(root.getRight()) == -1)
			return -1;

		int hl = height(root.getLeft());
		int hr = height(root.getRight());
		int diff = Math.abs(height(root.getLeft()) - height(root.getRight()));

		return diff > 1 ? -1 : max(hl, hr) + 1;

	}

	private static int max(int hl, int hr) {
		return hl > hr ? hl : hr;
	}
}
