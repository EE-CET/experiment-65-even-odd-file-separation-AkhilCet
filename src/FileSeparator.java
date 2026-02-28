import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSeparator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("numbers.txt"));
             PrintWriter evenWriter = new PrintWriter("even.txt");
             PrintWriter oddWriter = new PrintWriter("odd.txt")) {
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number % 2 == 0) {
                    evenWriter.print(number + " ");
                } else {
                    oddWriter.print(number + " ");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error processing files.");
        }

        System.out.print("Even File: ");
        try (Scanner fileReader = new Scanner(new File("even.txt"))) {
            while (fileReader.hasNext()) {
                System.out.print(fileReader.next() + " ");
            }
        } catch (FileNotFoundException e) {
        }
        System.out.println();

        System.out.print("Odd File: ");
        try (Scanner fileReader = new Scanner(new File("odd.txt"))) {
            while (fileReader.hasNext()) {
                System.out.print(fileReader.next() + " ");
            }
        } catch (FileNotFoundException e) {
        }
        System.out.println();
    }
}
