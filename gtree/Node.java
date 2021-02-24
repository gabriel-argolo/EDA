package gtree;

import java.util.ArrayList;
import java.util.Iterator;

public class Node <T> implements ITree {
	private int data;
	private Node<T> father;
	private ArrayList<Node<T>> child;


	public Node() {

	}

	public Node (int data, ITree father) {
		this.data = data;
		this.father = (Node<T>) father;
		this.child = new ArrayList<>();

	}

	public Node (int data, Node<T> father) {
		this.data = data;
		this.father = father;
		this.child = new ArrayList();
	}



	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node<T> getFather() {
		return father;
	}

	public void setFather(Node<T> father) {
		this.father = father;
	}

	public ArrayList<Node<T>> getChild() {
		return child;
	}

	public void setChild(ArrayList<Node<T>> child) {
		this.child = child;
	}

	@Override
	public void add(ITree Node) {
		// TODO Auto-generated method stub
		this.child.add((Node<T>)Node);
	}

	@Override
	public void remove(ITree Node) {
		// TODO Auto-generated method stub
		this.child.remove(Node);
	}

	@Override
	public void source(int data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		Iterator<Node<T>> itr = child.iterator();

		while (itr.hasNext()) {
			System.out.print(itr.next().getData()+"     ");
		}
	}

	public Node searchNode(int fatherValue) {
		Node node = new Node();

		for (int i = 0; i < child.size(); i++) {
			if (child.get(i).getData() == fatherValue) {
				return child.get(i);
			}
		}
		return null;
	}

	public ITree getChild(int x) {
		return (ITree) child.get(x);
	}
}
