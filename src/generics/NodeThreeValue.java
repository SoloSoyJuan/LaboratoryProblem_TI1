package generics;

public class NodeThreeValue<K, V> implements INode<K , V>{
    private boolean entry;
    private K key;
    private V value;
    private INode<K, V> next;
    private INode<K, V> prev;

    public NodeThreeValue(boolean entry, K key, V value){
        this.entry = entry;
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
    public boolean getEntry(){
        return entry;
    }
    public void setEntry(boolean entry){
        this.entry = entry;
    }
    @Override
    public K getKey() {
        return null;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public V getValue() {
        return value;
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
}
