

public class Decryptor {
    // Initialize the list of encryptions available
    public static void InitializeDecryptions() {
        decryptionList = new java.util.ArrayList<>();
        decryptionList.add(new ShiftDecryption());
        decryptionList.add(new BinaryDecryption());
    }
    
    // Find the decryption from the list by its name
    public static Decryption getDecryptionByName(String name) {
        for (Decryption dec : decryptionList) {
            if (dec.getName().equals(name)) {
                return dec;
            }
        }
        
        return null;
    }
    
    // A list of encryption this encryptor supports (static)
    private static java.util.List<Decryption> decryptionList;
}
