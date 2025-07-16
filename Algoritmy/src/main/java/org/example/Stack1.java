package org.example;

public class Stack1 {
    // region Поля
    Node1 head;
    // endregion

    // region Методы стэка

    /**
     * Передает значение в начало стэка.
     * @param value
     */
    public void push(int value){
        Node1 node = new Node1();
        node.value = value;
        node.next = head;
        head = node;
    }

    /**
     * Удаляет и возвращает последний элемент по принципу LIFO.
     * @return последний элемент стэка
     */
    public Integer pop(){
        Integer result = null;
        if (head != null){
            result = head.value;
            head = head.next;
        }
        return result;
    }

    // endregion

    // region Методы
    public void add(int value){
        Node1 node = new Node1();
        node.value = value;
        if (head == null){
            head = node;
        } else {
            Node1 tail = findLastNode();
            tail.next = node;
        }
    }

    private Node1 findLastNode(){
        Node1 currentNode = head;
        while (currentNode != null){
            if (currentNode.next == null){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public void delete(Node1 node){
        Node1 next = node.next;
        Node1 prevNode = findPrevNode(node.value);
        if (prevNode == null){
            head = next;
        } else if (next == null){
            prevNode.next = null;
        } else {
            prevNode.next = next;
        }
    }

    private Node1 findPrevNode(int value){
        Node1 prevNode = head;
        Node1 currentNode = prevNode.next;
        while (prevNode != null && currentNode != null){
            if (currentNode.value == value){
                return prevNode;
            }
            prevNode = prevNode.next;
            currentNode = currentNode.next;
        }
        return prevNode;
    }

    public void delete(int value){
        Node1 node = find(value);
        if (node != null){
            Node1 next = node.next;
            Node1 prevNode = findPrevNode(node.value);
            if (prevNode == null) {
                head = next;
            } else if (next == null) {
                prevNode.next = null;
            } else {
                prevNode.next = next;
            }
        }
    }

    public void showList(){
        Node1 currentNode = head;
        int counter = 1;
        while (currentNode != null){
            System.out.println(counter + "." + currentNode);
            counter++;
            currentNode = currentNode.next;
        }
    }

    public Node1 find(int value){
        Node1 currentNode = head;
        while (currentNode != null){
            if (currentNode.value == value){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public void revert(){
        if (head != null && head.next != null){
            Node1 temp = head;
            revert(head, head.next);
            temp.next = null;
        }
    }

    private void revert(Node1 currentNode, Node1 prevNode){
        if (currentNode.next == null){
            head = currentNode;
        } else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = prevNode;
    }
    // endregion

    // region Вложенные классы
    public static class Node1{
        int value;
        Node1 next;

        @Override
        public String toString() {
            return "node{" +
                    "value=" + value +
                    '}';
        }
    }
    // endregion
}
