

public class Spy implements Listener {
    // Constructor
    public Spy() {
        // Randomly generate a key satisfying: -128 <= key <= 127
        this.key = (byte) Math.floor(Math.random() * 256 - 128);
        // Assume the encryption/decryption type of "xor'ing bits"
        decryption = Decryptor.getDecryptionByName("binary");
    }
    
    // Register itself to the encryptor that is provided
    public void registerSelf(Encryptor encryptor) {
        // Tell the encryptor that Spy uses the bit xor'ing encryption
        Encryption selectedEncryption = Encryptor.getEncrpytionByName("binary");
        // Register itself
        encryptor.register(selectedEncryption, key, this);
    }
    
    // Accept encrypted text from the Encryptor
    @Override
    public void update(String encryptedText) {
         // Decrpyt the given text
        String decryptedText = decryption.decrypt(encryptedText, key);
        
        // Log the result on the console
        System.out.println("Spy received decrypted text into: ");
        System.out.println(decryptedText);
    }
    
    // Selected decryption type
    private Decryption decryption;
    // Randomly generated key
    private byte key;
}
