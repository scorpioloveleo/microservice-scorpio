package SuanFa;

import java.util.HashMap;

public class LRU {

    public static void main(String[] args) {
        LruList<Integer, String> lru = new LruList<>();
        lru.addFirst(1,"first");
        lru.addFirst(2, "second");
        lru.addFirst(3, "thirth");
        lru.getListString();
        System.out.println("使用: "+lru.get(2));
        lru.getListString();
        System.out.println("使用: "+lru.get(3));
        lru.getListString();
        System.out.println("使用: "+lru.get(1));
        lru.getListString();
        System.out.println("使用: "+lru.get(2));
        lru.getListString();
        System.out.println("填充: 4");
        lru.addFirst(4, "forth");
        lru.getListString();
    }

}

//双向链表
class Node<K,V>{
    K key;
    V value;
    Node<K,V> next, pre;

    public Node(K key, V value, Node<K, V> next, Node<K, V> pre) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.pre = pre;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    public void setPre(Node<K, V> pre) {
        this.pre = pre;
    }
}

class LruList<K,V>{
    Node<K,V> parent = null;
    int capacity = 3;
    int size = 0;
    public LruList() {
    }

    public void setParent(Node<K, V> parent) {
        this.parent = parent;
    }

    //添加到头部的方法
    void addFirst(K k, V v){
        Node<K, V> kvNode = new Node<>(k , v, null, null);
        if(size == capacity){
            removelast();
        }
        kvNode.setNext(this.parent);
        kvNode.setPre(null);
        if(this.parent != null){
            this.parent.setPre(kvNode);
        }
        this.setParent(kvNode);
        size++;
    }

    //删除最后一个
    K removelast(){
        if(parent == null){
            return null;
        }
        Node last = parent;
        while (last.next !=null){
            last = last.next;
        }
        K key = (K)last.key;
        last.pre.setNext(null);
        size--;
        return key;
    }

    //删除指定的key
    void remove(K nodeKey){
        Node val = parent;
        while (val.key !=nodeKey){
            val = val.next;
            if(val == null){
                break;
            }
        }

        if(val !=null){
            val.pre.setNext(val.next);
            size--;
        }
    }

    //查询并且，置顶
    V get(K k){
        if(parent == null){
            return null;
        }
        Node val = parent;
        while (val.key !=k){
            val = val.next;
            if(val == null){
                break;
            }
        }

        if(val != null){
            //置顶
            if(parent.key != val.key){
                val.pre.setNext(val.next);
                val.setNext(parent);
                val.setPre(null);
                parent.setPre(val);
                setParent(val);
            }
        }

        return (V)val.value;
    }

    void getListString(){
        if(parent == null){
            return;
        }
        Node val = parent;
        while (val != null){
            System.out.println(val.key);
            val = val.next;
            }
    }

}
