public class HuffmanApp {
    public static void main(String[] args) {
        String test = " Every great developer you know got there by solving problems they were unqualified to solve until they actually did it. ";
        int[] charFrequencies = new int[256];
        for (char c : test.toCharArray()) {
            charFrequencies[c]++;
        }

        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.buildTree(charFrequencies);
        HuffmanCoder huffmanCoder = new HuffmanCoder(huffmanTree);

        String encodedData = huffmanCoder.encode(test);
        System.out.println("Encoded Data: " + encodedData);

        String decodedData = huffmanCoder.decode(encodedData);
        System.out.println("Decoded Data: " + decodedData);
    }
}
