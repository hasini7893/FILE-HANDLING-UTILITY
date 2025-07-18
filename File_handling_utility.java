package Internship;
 import java.io.*;
import java.util.*;

public class FileHandlingUtility {

    // Method to write content to a file
    public static void writeFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("✅ File written successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    // Method to read content from a file
    public static void readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("📄 File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading the file: " + e.getMessage());
        }
    }

    // Method to modify file (example: append text to it)
    public static void modifyFile(String filename, String newContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.newLine(); // add new line
            writer.write(newContent);
            System.out.println("🛠️ File modified successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error modifying the file: " + e.getMessage());
        }
    }

    // Main method to demonstrate all file operations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "internship_note.txt";

        // Initial content
        String initialContent = """
                CODTECH INTERNSHIP
                COMPLETION CERTIFICATE WILL BE ISSUED ON YOUR INTERNSHIP END DATE.
                """;

        // Write to file
        writeFile(filename, initialContent);

        // Read the file
        readFile(filename);

        // Modify the file (append a new line)
        System.out.print("\nEnter additional note to append to file: ");
        String additionalNote = scanner.nextLine();
        modifyFile(filename, additionalNote);

        // Read again to show updated content
        System.out.println("\n📘 Updated File Content:");
        readFile(filename);

        scanner.close();
    }
}
