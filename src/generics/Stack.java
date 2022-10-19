package generics;

public class Stack<V> implements IStack<V> {
    private INode<Integer, V> top;

    public Stack(){
    }

    @Override
    public void push(boolean entry, int key, V element) {
        INode<Integer, V> node = new NodeThreeValue<>(entry, key, element);
        if(top == null){
            top = node;
        }else{
            node.setNext(top);
            top = node;
        }
    }

    @Override
    public INode<Integer, V> pop() {
        INode<Integer, V> node = top.getNext();
        top.setNext(null);
        INode<Integer, V> element = top;
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
