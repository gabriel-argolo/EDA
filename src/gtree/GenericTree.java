package gtree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTree<T> implements ITree {
	public int value;
	private ArrayList<Node<T>> tree = new ArrayList<Node<T>>();

	public GenericTree() {
		tree = new ArrayList<>();
	}

	public Node searchNode(int value) {
		for (int i = 0; i < tree.size(); i++) {
			if (tree.get(i).getData()==value) {
				return tree.get(i);
			}
		}
		return null;
	}

	@Override
	public void add(ITree Node) {
		// TODO Auto-generated method stub
		tree.add((Node<T>)Node);
	}

	@Override
	public void remove(ITree Node) {
		// TODO Auto-generated method stub
		List<Node<T>> list = getTree();
		list.remove(Node);
		removeNode(Node);
	}

	private void removeNode(ITree Node) {
		Node node = (Node) Node;
		ITree fatherNode = node.getFather();
		fatherNode.remove(Node);
	}
	
	private List<Node<T>> getTree() {
		// TODO Auto-generated method stub
		return tree;
	}

	@Override
	public void source(int data) {
		// TODO Auto-generated method stub}
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		Iterator<Node<T>> itr = tree.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next().getData()+"    ");
		}
	}
}
