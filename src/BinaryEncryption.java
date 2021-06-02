
public class BinaryEncryption implements Encryption {
    // Return the encryption name
    @Override
    public String getName() {
        return "binary";
    }
    
    // Encrypt a given text using the key with the XOR algorithm
    @Override
    public String encrypt(String plainText, byte key) {
        // Convert string to an array of characters
        char[] charArray = plainText.toLowerCase().toCharArray();
        
        for (int i = 0; i < charArray.length; i++) {
            // XOR the bits to encrypt
            charArray[i] = (char) (charArray[i] ^ key);
        }
        
        String encryptedText = String.copyValueOf(charArray);
        return encryptedText;
    }
}
