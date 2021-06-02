
public interface Decryption {
    // Return the decryption name
    public String getName();
    // Decrypt a given text using the implemented algorithm
    public String decrypt(String encryptedText, byte key);
}
