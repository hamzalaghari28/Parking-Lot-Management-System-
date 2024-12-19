class CustomStack {
    private String[] stack;
    private int top;

    public CustomStack(int capacity) {
        stack = new String[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(String licenseNumber) {
        if (top == stack.length - 1) {
            System.out.println("Stack is full. Cannot push.");
            return;
        }
        stack[++top] = licenseNumber;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        return stack[top--];
    }
}

