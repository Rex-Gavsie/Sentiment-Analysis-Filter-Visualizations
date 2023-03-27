
import java.io.IOException;
import java.nio.file.*;
import java.awt.image.BufferedImage;

/**
 * PREPROCESSOR GOALS
 * 
 * The preprocessor will be an object so that way, it can store it's
 * own data regarding where things are and you don't just have a static wall
 * 
 * 
 */

public class Preprocessor {

    // Fields
    Path outputPath;
    int imageSize;

    /**
     * Initializes a text preprocessor
     * 
     * @param outputPath is the desired output path
     * @param imageSize  in pixels
     * 
     */
    public Preprocessor(String outputPath, int imageSize) throws InvalidPathException {
        try {
            verifyPathIsValid(outputPath);
        } catch (Exception e) {
            throw new InvalidPathException(outputPath, "Initialization Failed. Cause: " + e.getMessage());
        }
        this.outputPath = Paths.get(outputPath);
        this.imageSize = imageSize;
    }

    /* DATA VALIDATION */

    /**
     * Checks that the path exists, is a folder, and is writeable
     * 
     * @deprecated THIS SHOULD BE DONE ON THE INPUT SIDE
     * 
     * @param inputPath
     */
    private void verifyPathIsValid(String inputPath) {
        Path checkPath = Paths.get("C:\\");
        try {
            checkPath = Paths.get(inputPath);
        } catch (InvalidPathException e) {
            throw new InvalidPathException(inputPath, "Invalid Path");
        }
        if (!Files.isDirectory(checkPath)) {
            throw new InvalidPathException(inputPath, "Not A Directory");
        } else if (!Files.isWritable(checkPath)) {
            throw new InvalidPathException(inputPath, "Directory Is Not Writeable");
        }
    }

    /* PROCESSING */
    /**
     * 
     * @param inputText
     * 
     * @return info regarding this process, idk
     */
    public void processString(String inputText) {

    }

    /* GETTERS AND SETTERS */
    public void setOutputPath(String newPath) throws InvalidPathException {
        try {
            verifyPathIsValid(newPath);
        } catch (Exception e) {
            throw new InvalidPathException(newPath, "changeOutputPath Failed. Cause:  " + e.getMessage());
        }
        this.outputPath = Paths.get(newPath);
    }

    public Path getOutputPath() {
        return outputPath;
    }

    public int getImageSize() {
        return this.imageSize;
    }

    public void setImageSize(int imageSize) {
        this.imageSize = imageSize;
    }

}
