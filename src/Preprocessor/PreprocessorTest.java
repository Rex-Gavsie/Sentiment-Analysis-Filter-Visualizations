package Preprocessor;

import java.io.IOException;
import java.util.Scanner;

public class PreprocessorTest {
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Preprocessor preprocessor = new Preprocessor("C:\\Users\\Rex\\Documents\\VS Code General Projects\\Sentiment Analysis Filter Visualizations\\Preprocessor Results\\", 10, true);
        while (true) {
            String[] returns = preprocessor.processString(scanner.nextLine());
            System.out.println(returns[0]);
            System.out.println(returns[1]);
            System.out.println(returns[2]);
        }    
    }
}
