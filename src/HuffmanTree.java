public class HuffmanTree {

    private HuffmanNode root;
    private MyMap<Character, String> huffmanCodes;

    public HuffmanTree() {
        this.huffmanCodes = new MyMap<>();
    }

    public void buildTree(int[] charFrequencies) {
        MyPriorityQueue<HuffmanNode> PrimaryQueue = new MyPriorityQueue<>();
        MyPriorityQueue<HuffmanNode> SecondaryQueue = new MyPriorityQueue<>();

        for (char i = 0; i < 256; i++) {
            if (charFrequencies[i] > 0) {
                PrimaryQueue.add(new HuffmanNode(i, charFrequencies[i]));
            }
        }

        while (PrimaryQueue.size() + SecondaryQueue.size() > 1) {
            HuffmanNode first = extractMin(PrimaryQueue, SecondaryQueue);
            HuffmanNode second = extractMin(PrimaryQueue, SecondaryQueue);

            HuffmanNode merged = new HuffmanNode('-', first.frequency + second.frequency);
            merged.left = first;
            merged.right = second;
            SecondaryQueue.add(merged);
        }
        root = SecondaryQueue.poll();
        generateCodes(root, "");
    }

    private HuffmanNode extractMin(MyPriorityQueue<HuffmanNode> PrimaryQueue, MyPriorityQueue<HuffmanNode> SecondaryQueue) {
        if (PrimaryQueue.size() == 0) {
            return SecondaryQueue.poll();
        } else if (SecondaryQueue.size() == 0) {
            return PrimaryQueue.poll();
        } else {
            if (PrimaryQueue.peek().frequency < SecondaryQueue.peek().frequency) {
                return PrimaryQueue.poll();
            } else {
                return SecondaryQueue.poll();
            }
        }
    }

    private void generateCodes(HuffmanNode node, String s) {
        if (node != null) {
            if (node.left == null && node.right == null && node.data != '-') {
                huffmanCodes.put(node.data, s);
            }
            generateCodes(node.left, s + "0");
            generateCodes(node.right, s + "1");
        }
    }

    public MyMap<Character, String> getCodes() {
        return huffmanCodes;
    }

    public HuffmanNode getRoot() {
        return root;
    }


}