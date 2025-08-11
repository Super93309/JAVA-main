public class LinkedList{

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    public void addLast(int value){
        var node = new Node(value);

        if(head == null)
            head = tail = node;
        else{
            tail.next = node;
            tail = node;
        }
    }

    public void addFirst(int value){
        var node = new Node(value);
        if(head == null){
            addLast(value);
        }
        else {
            node.next = head;
            head = node;
        }
    }



    public int indexOf(int value){
        int index = 0;
        var current = head;
        while(current != null){
            if(current.value == value) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contain(int value){
        return indexOf(value) != -1;
    }

    public void removeFirst(){
        if(head == null){
            System.out.println("List is empty");
        }
        if(head == tail){
            head = tail = null;
         }
        var secound = head.next;
        head.next = null;
        head = secound;
    }

    public void removeLast(){
        if(head == null){
            System.out.println("List is empty");
        }
        if(head == tail){
            head = tail = null;
            return;
        }
        var previous = getPrevious(tail);
        tail = previous;
        tail.next = null;
    }

    private Node getPrevious(Node node){
        var current = head;
        while (current != null){
            if(current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public void print(){
        var current = head;
        while(current != null){
            System.out.print(current.value+" ");
            current = current.next;
        }
    }

    public static void main(String[] args){
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(50);
        list.addFirst(5);
        list.removeFirst();
        list.removeLast();
        list.print();
        System.out.println();
        System.out.println(list.contain(10));
        System.out.println(list.indexOf(20));
    }

}

