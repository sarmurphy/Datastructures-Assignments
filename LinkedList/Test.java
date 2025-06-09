package LinkedList;

public class Test {
    public static void main(String[] args) {
        DeleteLinkedList list = new DeleteLinkedList();
        list.createSingleLinkedlist(5);
        list.insertLinkedList(10, 1);
        list.insertLinkedList(15, 2);
        list.insertLinkedList(20, 3);

        System.out.println("Complete list before deletion:");
        list.traverseLinkedList();

        // Deleting the first node:
        System.out.println("First Node:");
        list.delete(0);
        list.traverseLinkedList();

        // Deleting the last node:
        System.out.println("Last Node:");
        list.delete(list.size - 1);
        list.traverseLinkedList();

        // Deleting the node at index 2:
        System.out.println("Anywhere (index 2):");
        list.delete(2);
        list.traverseLinkedList();
    }
}
