package Preprocessor;

import java.io.IOException;
import java.util.Scanner;

public class PreprocessorTest {
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Preprocessor preprocessor = new Preprocessor("C:\\Users\\Rex\\Documents\\VS Code General Projects\\Sentiment Analysis Filter Visualizations\\Preprocessor Results\\", 200, true);
        
        /* CONSOLE TESTER */
        // while (true) {
        //     String[] returns = preprocessor.processString(scanner.nextLine());
        //     System.out.println(returns[0]);
        //     System.out.println(returns[1]);
        //     System.out.println(returns[2]);
        // }    
        
        /* SPECIFIC TESTER */
        System.out.println(Heatmap.getColorForChar('?'));
        // preprocessor.processString("Construction equipment is undoubtedly one of the coolest things that human beings have ever created. The sheer size, power, and versatility of these machines are awe-inspiring and make them essential in various construction projects. One of the coolest things about construction equipment is the diversity of the machines available. There are excavators, bulldozers, loaders, backhoes, cranes, and many others, each with its unique purpose and capabilities. These machines come in different sizes, ranging from compact models for small projects to massive machines used in large-scale construction projects. Another impressive aspect of construction equipment is the technology behind them. With advancements in engineering, construction equipment has become increasingly efficient, safer, and more environmentally friendly. Today's equipment is equipped with sophisticated control systems, sensors, and GPS technology that allow operators to monitor and control every aspect of the machine's operation, making construction projects more efficient and accurate. The power of construction equipment is another feature that makes them incredibly cool. The bulldozers and excavators can move tons of earth and rocks with ease, while cranes can lift and move heavy loads, making it possible to construct skyscrapers and other tall buildings. The sheer power and strength of these machines are incredible to watch, making them a sight to behold. Construction equipment also has a significant impact on society. Without them, it would be impossible to construct the buildings, bridges, roads, and other infrastructure we use every day. These machines have revolutionized the construction industry, making it possible to complete projects faster and more efficiently than ever before. In conclusion, construction equipment is incredibly cool for many reasons. From their sheer size and power to their versatility and impact on society, these machines are truly amazing. It is no wonder that many people are fascinated by them, and the construction industry continues to evolve to meet the needs of society.");
        FileProcessing.processTXT(preprocessor, "C:\\Users\\Rex\\Documents\\VS Code General Projects\\Sentiment Analysis Filter Visualizations\\testDoc.txt");
    }
}
