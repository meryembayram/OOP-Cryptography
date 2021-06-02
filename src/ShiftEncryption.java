
public class ShiftEncryption implements Encryption {
    // Return the encryption name
    @Override
    public String getName() {
        return "shift";
    }
    
    // Encrypt a given text using the key with the character shifting algorithm
    @Override
    public String encrypt(String plainText, byte key) {
        // Convert string to an array of characters
        char[] charArray = plainText.toLowerCase().toCharArray();
        
        for (int i = 0; i < charArray.length; i++) {
            // If the character is an alphabet character...
            if (charArray[i] >= 97 && charArray[i] <= 122) {
                // Shift characters to the left
                charArray[i] = (char) ((((charArray[i] - 97) + key) % 26) + 97);
            }
        }
        
        String encryptedText = String.copyValueOf(charArray);
        return encryptedText;
    }
}
