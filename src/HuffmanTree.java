import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {

    private HuffmanNode root;
    private Map<Character, String> huffmanCodes;

    public HuffmanTree() {
        this.huffmanCodes = new HashMap<>();
    }

    public void buildTree(int[] charFrequencies) {
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>();
        for (char i = 0; i < 256; i++) {
            if (charFrequencies[i] > 0) {
                queue.add(new HuffmanNode(i, charFrequencies[i]));
            }
        }

        while (queue.size() > 1) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();
            HuffmanNode sum = new HuffmanNode('-', left.frequency + right.frequency);
            sum.left = left;
            sum.right = right;
            queue.add(sum);
        }
        root = queue.poll();
        generateCodes(root, "");
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

    public Map<Character, String> getCodes() {
        return huffmanCodes;
    }

    public HuffmanNode getRoot() {
        return root;
    }


}