package Preprocessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileProcessing {
    

    /**
     * Takes and processes a .txt file
     * 
     * @param filePath
     * @return
     */
    public static ArrayList<String[]> processTXT(Preprocessor processor, String filePath) throws InvalidPathException, IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path) || Files.isDirectory(path) || !Files.isReadable(path) || !filePath.contains(".txt")) {
            throw new InvalidPathException(filePath, "no");
        } 
        String text = Files.readString(path);
        return processor.processString(text);
    } 

    /**
     * Reads and processes data from a .txt
     * 
     * @param processor
     * @param filePath
     * @param column 
     * 
     * @return
     */
    public static ArrayList<String[]> processCSV(Preprocessor processor, String filePath, int column) {
        return null;
    }
}
