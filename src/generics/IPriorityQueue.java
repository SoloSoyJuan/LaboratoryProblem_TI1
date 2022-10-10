package generics;

public interface IPriorityQueue<V> {
    public int parent(int post);
    public int right(int post);
    public int left(int post);
    public void insert(int key, V value);
    public V maximum();
    public V extractMax();
    public void maxHeapify(int post);
    public void builtMaxHeap();
    public void heapSort();
    public boolean increasekey(int post, int key);
}
