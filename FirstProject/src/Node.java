
public class Node {
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	int data;
	Node left;
	Node right;
	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node(int data) {
		super();
		this.data = data;
	}

}
