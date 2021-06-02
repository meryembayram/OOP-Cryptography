
public class Main {
    public static void main(String[] args) {
        // Initialize static lists
        Encryptor.InitializeEncryptions();
        Decryptor.InitializeDecryptions();
        
        // Create a new encryptor
        Encryptor encryptor = new Encryptor();
        
        // Create listeners and make them register themselves to the encryptor
        new General().registerSelf(encryptor);
        new General().registerSelf(encryptor);
        new Spy().registerSelf(encryptor);
        new Spy().registerSelf(encryptor);
        
        // Listen to user input
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        while (true) {
            // Take a file name and give it to the encryptor
            System.out.print("Enter a file to read: ");
            encryptor.readFile(scanner.nextLine());
        }
    }
    
}
