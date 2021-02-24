package gtree;

public interface ITree {

	public void add(ITree Node);
	public void remove(ITree Node);
	public void source(int data);
	public void print();
	public Node searchNode(int fatherValue);

}
