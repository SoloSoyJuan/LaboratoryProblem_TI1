package generics;

public class Node<K, V> implements INode<K, V> {

    private K key;
    private V value;
    private INode<K, V> next;
    private INode<K, V> prev;

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public INode<K, V> getNext() {
        return next;
    }

    @Override
    public INode<K, V> getPrev() {
        return prev;
    }

    @Override
    public void setNext(INode<K, V> next) {
        this.next = next;
    }

    @Override
    public void setPrev(INode<K, V> prev) {
        this.prev = prev;
    }

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
