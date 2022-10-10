package generics;

public interface INode<K, V> {
    public K getKey();
    public void setKey(K key);
    public V getValue();
    public void setValue(V value);
    public INode<K, V> getNext();
    public INode<K, V> getPrev();
    public void setNext(INode<K, V> next);
    public void setPrev(INode<K, V> prev);
}
