
public interface Encryption {
    // Return the encryption name
    public String getName();
    // Encrypt a given text using the implemented algorithm
    public String encrypt(String plainText, byte key);
}
