import utilities.Node;


public class RoughWork {

	public static void main(String[] args) {
		Node node=new Node(10);
		foo(node);
		System.out.println(node.getData());

	}

	private static void foo(Node node) {
		node.setData(20);
		
	}

}
