/**
 * Implememt an application that support undo/redo functionality. Use a linked list to maintain a sequence of states.\
 * Each state change is stored as a node in the list, allowing for easy navigation
 * 1<>2<>3<>4<>5
 */

public class UndoRedo<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;

        private Node(T state) {
            this.state = state;
        }
    }

    private Node currentState;
    private int size;

    // Undo functionality
    public T undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("Unable to undo.");
            return null;
        }
        currentState = currentState.prev;
        return currentState.state;
    }

    public void addState(T newState) {
        if (currentState != null && currentState.next != null) {
            currentState.next = null;
        }
        Node newNode = new Node(newState);
        if (currentState == null) {
            currentState = newNode;
        } else {
            currentState.next = newNode;
            newNode.prev = currentState;
            currentState = newNode;
        }
        size++;
    }

    // Redo functionality
    public T redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("Unable to redo.");
            return null;
        }
        currentState = currentState.next;
        return currentState.state;
    }

    // Testing undo/redo functionality
    public static void main(String[] args) {
        UndoRedo<String> undoRedo = new UndoRedo<>();

        System.out.println("Adding to list...");
        undoRedo.addState("1");
        undoRedo.addState("2");
        undoRedo.addState("3");
        undoRedo.addState("4");
        undoRedo.addState("5");

        // Printing list after additions
        System.out.println("Current state: " + undoRedo.currentState.state);

        // Testing undo operation
        System.out.println("Undo Operation:");
        System.out.println("UNDO - Current state: " + undoRedo.undo());
        System.out.println("UNDO - Current state: " + undoRedo.undo());
        System.out.println("UNDO - Current state: " + undoRedo.undo());
        System.out.println("UNDO - Current state: " + undoRedo.undo());
        System.out.println("UNDO - " + undoRedo.undo()); // Nothing left in list

        // Testing redo operation
        System.out.println("Redo Operation:");
        System.out.println("REDO - Current state: " + undoRedo.redo());
        System.out.println("REDO - Current state: " + undoRedo.redo());
        System.out.println("REDO - Current state: " + undoRedo.redo());
        System.out.println("REDO - Current state: " + undoRedo.redo());
        System.out.println("REDO - " + undoRedo.redo()); // Nothing left to redo
    }
}