import java.util.Map;

public class HuffmanCoder {

    private HuffmanTree huffmanTree;

    public HuffmanCoder(HuffmanTree huffmanTree) {
        this.huffmanTree = huffmanTree;
    }

    public String encode(String data) {
        MyMap<Character, String> huffmanCodes = huffmanTree.getCodes();
        StringBuilder encodedData = new StringBuilder();
        for (char c : data.toCharArray()) {
            encodedData.append(huffmanCodes.get(c));
        }
        return encodedData.toString();
    }

    public String decode(String encodedData) {
        StringBuilder decodedData = new StringBuilder();
        HuffmanNode current = huffmanTree.getRoot();
        for (int i = 0; i < encodedData.length(); i++) {
            current = encodedData.charAt(i) == '0' ? current.left : current.right;
            if (current.left == null && current.right == null) {
                decodedData.append(current.data);
                current = huffmanTree.getRoot();
            }
        }
        return decodedData.toString();
    }


}
