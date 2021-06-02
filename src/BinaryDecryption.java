
public class BinaryDecryption implements Decryption {
    // Return the decryption name
    @Override
    public String getName() {
        return "binary";
    }
    
    // Decrypt a given text using the key with the XOR algorithm
    @Override
    public String decrypt(String encryptedText, byte key) {
        // Convert string to an array of characters
        char[] charArray = encryptedText.toCharArray();
        
        for (int i = 0; i < charArray.length; i++) {
            // XOR the bits back
            charArray[i] = (char) (charArray[i] ^ key);
        }
        
        String decryptedText = String.copyValueOf(charArray);
        return decryptedText;
    }
}
