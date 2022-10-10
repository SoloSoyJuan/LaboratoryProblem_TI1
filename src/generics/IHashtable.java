package generics;

public interface IHashtable<K, V> {
    public void insert(K key, V value);
    public boolean delete(K key);
    public INode<K,V> search(K key);
    public Integer hashFuntion(K key);
}
