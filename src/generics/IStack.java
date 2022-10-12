package generics;

public interface IStack<V> {
    public void push(int key, V element);
    public V pop();
    public V top();
    public boolean isEmpty();
}
