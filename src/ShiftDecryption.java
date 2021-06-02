

public class ShiftDecryption implements Decryption {
    // Return the decryption name
    @Override
    public String getName() {
        return "shift";
    }
    
    // Decrypt a given text using the key with the character shifting algorithm
    @Override
    public String decrypt(String encryptedText, byte key) {
        // Convert string to an array of characters
        char[] charArray = encryptedText.toCharArray();
        
        for (int i = 0; i < charArray.length; i++) {
            // If the character is an alphabet character...
            if (charArray[i] >= 97 && charArray[i] <= 122) {
                // Shift characters to the left
                charArray[i] = (char) ((((charArray[i] - 97) - key + 26) % 26) + 97);
            }
        }
        
        String decryptedText = String.copyValueOf(charArray);
        return decryptedText;
    }
}
