
public class General implements Listener {
    // Constructor
    public General() {
        // Randomly generate a key satisfying: 1 <= key <= 25
        this.key = (byte) Math.floor(Math.random() * 25 + 1);
        // Assume the encryption/decryption type of "shifting characters"
        decryption = Decryptor.getDecryptionByName("shift");
    }
    
    // Register itself to the encryptor that is provided
    public void registerSelf(Encryptor encryptor) {
        // Tell the encryptor that General uses the character shifting encryption
        Encryption selectedEncryption = Encryptor.getEncrpytionByName("shift");
        // Register itself
        encryptor.register(selectedEncryption, key, this);
    }
    
    // Accept encrypted text from the Encryptor
    @Override
    public void update(String encryptedText) {
        // Decrpyt the given text
        String decryptedText = decryption.decrypt(encryptedText, key);
        
        // Log the result on the console
        System.out.println("General received decrypted text into: ");
        System.out.println(decryptedText);
    }
    
    // Selected decryption type
    private Decryption decryption;
    // Randomly generated key
    private byte key;
}
