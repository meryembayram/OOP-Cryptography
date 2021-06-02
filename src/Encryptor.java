
public class Encryptor {
    // Initialize the list of encryptions available
    public static void InitializeEncryptions() {
        encryptionList = new java.util.ArrayList<>();
        encryptionList.add(new ShiftEncryption());
        encryptionList.add(new BinaryEncryption());
    }
    
    // Constructor
    public Encryptor() {
        listenerList = new java.util.ArrayList<>();
    }
    
    // Register a listener into the list
    public void register(Encryption encryption, byte key, Listener listener) {
        // Pack listner's information into an array of Objects
        Object[] listenerInfo = new Object[3];
        listenerInfo[0] = encryption;
        listenerInfo[1] = key;
        listenerInfo[2] = listener;
        
        // Add it to the list
        listenerList.add(listenerInfo);
    }
    
    // Read the contents of the given file;
    // and for every listener, encrypt the content
    // using the method of that listener and send the
    // encrypted text to the listener
    public void readFile(String fileName) {
        String content = "";
        
        // Read file contents into a string
        try {
            content = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(fileName)));
        } 
        
        catch (java.io.IOException e) {
            System.err.println(e.getMessage());
        }
        
        // Traverse all listeners
        for (Object[] listenerInfo : listenerList) {
            // Remember what encryption that listener needs
            Encryption encryption = (Encryption) listenerInfo[0];
            // Remember its key
            byte key = (Byte) listenerInfo[1];
            // Remember the listener itself
            Listener listener = (Listener) listenerInfo[2];
            
            // Encrpyt the file content with that encryption
            String encryptedText = encryption.encrypt(content, key);
            // Send it to the listener
            listener.update(encryptedText);
        }
    }
    
    // Find the encryption from the list by its name
    public static Encryption getEncrpytionByName(String name) {
        for (Encryption enc : encryptionList) {
            if (enc.getName().equals(name)) {
                return enc;
            }
        }
        
        return null;
    }
    
    // A list of encryption this encryptor supports (static)
    private static java.util.List<Encryption> encryptionList;
    // A list of listeners that registered themselves
    private java.util.List<Object[]> listenerList;
}
