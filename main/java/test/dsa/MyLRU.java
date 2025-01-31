package test.dsa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

public class MyLRU {

}

interface CacheElement<K, V> {
    boolean put(K key, V val);
    Optional<V> get(K key);
    int size();
    void clear();
}

class DLinkedNode<T> {
    T key;
    T val;
    DLinkedNode prev;
    DLinkedNode next;

    DLinkedNode(T key, T val) {
        this.key = key;
        this.val = val;
    }

    public void addNode(DLinkedNode node, DLinkedNode head) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        /**
         * Remove an existing node from the linked list.
         */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(DLinkedNode node, DLinkedNode head){
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node, head);
    }

    public DLinkedNode popTail(DLinkedNode tail) {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}


class LRUCache<K, V> implements CacheElement<K, V> {
    private int size;
    private Map<K, DLinkedNode<CacheElement<K, V>>> linkedListNodeMap;
    private LinkedList<CacheElement<K, V>> doublyLinkedList;
    DLinkedNode head = new DLinkedNode(null, null);
    DLinkedNode tail = new DLinkedNode(null, null);

    public LRUCache(int capacity) {
        this.linkedListNodeMap = new HashMap<>();
        this.doublyLinkedList = new LinkedList<>();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    @Override
    public boolean put(K key, V val) {
        if (linkedListNodeMap.containsKey(key)) {
            DLinkedNode linkedNode = linkedListNodeMap.get(key);
            linkedNode.moveToHead(linkedNode, head);
        } else {
            //test.dsa.CacheElement newElem = new test.dsa.CacheElement<K, V>(key, val);
            DLinkedNode newNode = new DLinkedNode(key, val);
            newNode.addNode(newNode, head);
            linkedListNodeMap.put(key, newNode);
        }
        return true;
    }

    @Override
    public Optional<V> get(K key) {
        return Optional.empty();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

}
