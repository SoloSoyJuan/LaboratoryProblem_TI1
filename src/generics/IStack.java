package generics;

public interface IStack<V> {
    public void push(boolean entry, int key, V element);
    public INode<Integer, V> pop();
    public V top();
    public boolean isEmpty();
}
