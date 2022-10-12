package generics;

public class Stack<V> implements IStack<V> {
    private INode<Integer, V> top;

    public Stack(){
    }

    @Override
    public void push(int key, V element) {
        INode<Integer, V> node = new Node<>(key, element);
        if(top == null){
            top = node;
        }else{
            node.setNext(top);
            top = node;
        }
    }

    @Override
    public V pop() {
        INode<Integer, V> node = top.getNext();
        V element = top.getValue();
        top.setNext(null);
        top = node;
        return element;
    }

    @Override
    public V top() {
        return top.getValue();
    }

    @Override
    public boolean isEmpty() {
        boolean empty;
        empty = (top==null) ? true : false;
        return empty;
    }
}
