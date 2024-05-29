class MyPriorityQueue<T extends Comparable<T>> {
    private HuffmanNode[] heap;
    private int size;

    public MyPriorityQueue() {
        heap = new HuffmanNode[256];
        size = 0;
    }

    public void add(HuffmanNode value) {
        heap[size] = value;
        siftUp(size);
        size++;
    }

    public HuffmanNode poll() {
        if (size == 0) {
            return null;
        }
        HuffmanNode result = heap[0];
        heap[0] = heap[--size];
        siftDown(0);
        return result;
    }

    public HuffmanNode peek() {
        return size == 0 ? null : heap[0];
    }

    public int size() {
        return size;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap[index].frequency >= heap[parentIndex].frequency) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void siftDown(int index) {
        int leftChild;
        int rightChild;
        int smallestChild;

        while ((leftChild = 2 * index + 1) < size) {
            rightChild = leftChild + 1;
            smallestChild = (rightChild < size && heap[rightChild].frequency < heap[leftChild].frequency) ? rightChild : leftChild;

            if (heap[index].frequency <= heap[smallestChild].frequency) {
                break;
            }
            swap(index, smallestChild);
            index = smallestChild;
        }
    }

    private void swap(int i, int j) {
        HuffmanNode temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
