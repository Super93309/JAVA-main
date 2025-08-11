public class Stack {

    private int[] stack = new int[5];
    private int top = 0;

    public void push(int value){
        stack[top] = value;
        top++;
    }

    public int peek(){
        return stack[top-1];
    }

    public void pop(){
        top--;
        stack[top] = 0;
    }

    public void print(){
        for(int i =0; i<top;i++){
            System.out.print(stack[i] + " ");
        }
    }

    public int size(){
        return top;
    }

    public boolean isEmpty(){
        return top<0;
    }

    public static void main(String[] args){
        Stack s = new Stack();
        System.out.println(s.isEmpty());
        s.push(10);
        s.push(2);
        s.push(20);
        s.push(55);
        s.push(55);
        s.pop();
        s.print();
        System.out.println();
        System.out.println(s.peek());
        System.out.println(s.size());
        System.out.println(s.isEmpty());
    }
}
