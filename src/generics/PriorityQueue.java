package generics;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class PriorityQueue<V> implements IPriorityQueue<V> {
    private final int SIZE = 50;
    private INode<Integer, V> [] pQueue;
    private int heapSize;
    private int length;

    public PriorityQueue(){
        pQueue = (Node<Integer, V>[]) new Node<?, ?>[SIZE];
        this.heapSize = -1;
        this.length = -1;
    }
    @Override
    public int parent(int post) {
        return ((post+1)/2)-1;
    }

    @Override
    public int right(int post) {
        return ((post+1)*2);
    }

    @Override
    public int left(int post) {
        return ((post+1)*2)-1;
    }

    @Override
    public void insert(int key, V value) {
        heapSize++;
        length++;
        if(length < pQueue.length){
            pQueue[length] = new Node<>(Integer.MIN_VALUE, value);
        }else{
            INode<Integer, V>[] thePQueue = (Node<Integer, V>[]) new Node<?, ?>[SIZE*5];
            for (int i = 0; i < pQueue.length; i++) {
                thePQueue[i] = pQueue[i];
            }
            pQueue = thePQueue;
            insert(key, value);
        }
        increasekey(length, key);
    }

    @Override
    public V maximum() {
        return pQueue[0].getValue();
    }

    @Override
    public V extractMax() {
        V max = pQueue[0].getValue();
        pQueue[0] = pQueue[heapSize];
        pQueue[heapSize] = null;
        heapSize--;
        length--;
        maxHeapify(0);
        return max;
    }

    @Override
    public void maxHeapify(int post) {
        // safe value of positions for left and right
        int r = right(post);
        int l = left(post);
        // safe left and right generics value
        INode<Integer, V> right = pQueue[r];
        INode<Integer, V> left = pQueue[l];
        // generic biggest value and position
        INode<Integer, V> largest;
        int place;
        if(l<=heapSize && left.getKey() > pQueue[post].getKey()){
            largest = left;
            place = l;
        }else{
            largest = pQueue[post];
            place = post;
        }
        if(r<=heapSize && right.getKey() > pQueue[post].getKey()){
            largest = right;
            place = r;
        }
        if(!largest.equals(pQueue[post])){
            INode<Integer, V> q = pQueue[post];
            pQueue[post] = largest;
            pQueue[place] = q;
            maxHeapify(place);
        }
    }

    @Override
    public void builtMaxHeap() {
        heapSize = length;
        for (int i = heapSize/2; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    @Override
    public void heapSort() {
        builtMaxHeap();
        for (int i = length; i >= 1; i--) {
            //exchange A[0] with A[i]
            INode<Integer, V> node = pQueue[0];
            pQueue[0] = pQueue[i];
            pQueue[i] = node;
            //subtract 1 to heapSize and call maxHeapify
            heapSize--;
            maxHeapify(0);
        }
    }

    @Override
    public boolean increasekey(int post, int key) {
        if(key < pQueue[post].getKey()){
            return false;
        }
        pQueue[post].setKey(key);
        while(post>0 && pQueue[parent(post)].getKey() < pQueue[post].getKey()){
            INode<Integer, V> node = pQueue[parent(post)];
            pQueue[parent(post)] = pQueue[post];
            pQueue[post] = node;
            post = parent(post);
        }
        return true;
    }

    public String toString(){
        heapSort();
        String s = "Start";
        for (int i = length; i >= 0; i--) {
            s += pQueue[i].getValue().toString();
        }
        builtMaxHeap();
        return s+"\nEnd\n";
    }
    @Override
    public boolean delete(V value){
        boolean delete = false;
        for (int i = 0; i <= length; i++) {
            if(pQueue[i].getValue().equals(value)){
                delete = true;
                for (int j = i; j <= length; j++) {
                    pQueue[j] = pQueue[j+1];
                }
                heapSize--;
                length--;
                break;
            }
        }
        return delete;
    }
}
