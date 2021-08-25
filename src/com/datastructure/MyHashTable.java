package com.datastructure;

public class MyHashTable<K, V> {
    MyMapNode head;
    MyMapNode tail;

    //Method for get the word from Linked List
    public V get(K word) {
        MyMapNode<K, V> myNode = searchNode(word);
        return (myNode == null) ? null : myNode.getValue();
    }

    //Method for searching word from Linked List
    public MyMapNode<K, V> searchNode(K word) {
        MyMapNode<K, V> currentNode = head;
        int position = 0;
        while (currentNode != null) {
            position++;
            if (currentNode.getKey().equals(word)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    //Method for adding key and value to hash table
    public void add(K key, V value) {
        MyMapNode<K, V> myNode = searchNode(key);
        if (myNode == null) {
            myNode = new MyMapNode<>(key, value);
            this.append(myNode);
        } else
            myNode.setValue(value);

    }

    // Method to append value to Linked List
    private void append(MyMapNode<K, V> myNode) {
        if (this.head == null)
            this.head = myNode;
        if (this.tail == null)
            this.tail = myNode;
        else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    @Override
    public String toString() {
        return "MyLinkedListNodes{" + head + '}';
    }
}