import java.util.Scanner;

public class HuffmanApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to encode and decode using Huffman Coding (up to 5000 characters): ");

        String input = scanner.nextLine();

        if (input.length() > 5000) {
            System.out.println("Input string is too long. Please enter a string with at most 5000 characters.");
            return;
        }

        String test = " Every great developer you know got there by solving problems they were unqualified to solve until they actually did it. ";

        int[] charFrequencies = new int[256];
        for (char c : input.toCharArray()) {
            charFrequencies[c]++;
        }

        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.buildTree(charFrequencies);
        HuffmanCoder huffmanCoder = new HuffmanCoder(huffmanTree);

        String encodedData = huffmanCoder.encode(input);
        System.out.println("Encoded Data: " + encodedData);

        String decodedData = huffmanCoder.decode(encodedData);
        System.out.println("Decoded Data: " + decodedData);
    }
}
