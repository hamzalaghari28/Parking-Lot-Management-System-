class CustomQueue {
    private String[] queue;
    private int front, rear, size;

    public CustomQueue(int capacity) {
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public void enqueue(String licenseNumber) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = licenseNumber;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        String license = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return license;
    }
}
