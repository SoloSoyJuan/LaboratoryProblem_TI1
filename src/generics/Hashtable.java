package generics;

public class Hashtable<K, V> implements IHashtable<K, V> {
    //----------------------------------------------- Attributes
    private final int MAX = 5843;
    private INode<K,V>[] table;
    //----------------------------------------------- Constructor
    public Hashtable() {
        table = (Node<K, V>[]) new Node<?,?>[MAX];
    }
    //----------------------------------------------- Methods
    @Override
    public void insert(K key, V value) {
        int post = hashFuntion(key);

        if(table[post] == null){
            table[post] = new Node<K,V>(key, value);
        }else if(table[post].getKey().equals(key)){
            table[post].setValue(value);
        }else{
            boolean found = false;
            INode<K, V> current = table[post];

            while(current.getNext() != null && !found){
                if(current.getNext().getKey().equals(key)){
                    current.getNext().setValue(value);
                    found = true;
                }
            }
            if(!found){
                current.setNext(new Node<>(key, value));
            }
        }
    }

    @Override
    public boolean delete(K key) {
        boolean delete = false;
        INode<K, V> node1 = search(key);

        if(node1 != null){
            if(node1.getPrev() != null){
                INode<K, V> nNext = node1.getNext();
                INode<K, V> nPrev = node1.getPrev();
                nPrev.setNext(nNext);
                nNext.setPrev(nPrev);
                node1.setPrev(null);
                node1.setNext(null);
                delete = true;
            }else{
                INode<K, V> nNext = node1.getNext();
                if(nNext != null){
                    nNext.setPrev(null);
                }
                node1.setNext(null);
                int post = hashFuntion(key);
                table[post] = nNext;
                delete = true;
            }
        }
        return delete;
    }

    @Override
    public INode<K, V> search(K key) {
        int post = hashFuntion(key);

        if(table[post] != null){
            if(!table[post].getKey().equals(key)){
                boolean found = false;
                INode<K, V> current = table[post];

                while(current.getNext() != null && !found){
                    if(current.getNext().getKey().equals(key)){
                        return current.getNext();
                    }
                }
            }else{
                return table[post];
            }
        }
        return null;
    }

    @Override
    public Integer hashFuntion(K key) {
        int value = key.hashCode();
        value = value % MAX;
        return value;
    }
}
