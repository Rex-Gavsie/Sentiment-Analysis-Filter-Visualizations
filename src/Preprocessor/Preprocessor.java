package Preprocessor;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.sql.Time;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.Color;

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
    private Path outputPath;
    private int imageSize, filesProcessed;
    private Boolean inRGB;
    private final String PROCESSORNAME;

    /**
     * Initializes a text preprocessor
     * 
     * @param outputPath is the desired output path
     * @param imageSize  in pixels
     * 
     */
    public Preprocessor(String outputPath, int imageSize, boolean convertToRGB) throws InvalidPathException, IOException {
        try {
            verifyPathIsValid(outputPath);
        } catch (Exception e) {
            throw new InvalidPathException(outputPath, "Initialization Failed. Cause: " + e.getMessage());
        }
        this.imageSize = imageSize;
        this.inRGB = convertToRGB;
        this.filesProcessed = 0;

        //Set processor name to avoid duplicates, I'm sure there's a better way to do this but I sadly
        //do not care
        int i = 0;
        while (Files.exists(Paths.get(outputPath, "Processor " + i))) {
            i++;
        }
        this.PROCESSORNAME = "Processor " + i;
        this.outputPath = Paths.get(outputPath, PROCESSORNAME, "/");
        createPreprocessorFolder();
        
    }

    /* DATA VALIDATION */   

    /**
     * Checks that the path exists, is a folder, and is writeable
     * 
     * Should probably be on the input side
     * 
     * @param inputPath
     */
    public static void verifyPathIsValid(String inputPath) {
        Path checkPath = null;
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

    /**
     * Creates the folders for the preprocessor
     * 
     * @throws IOException
     */
    private void createPreprocessorFolder() throws IOException {
        try {
            Files.createDirectories(outputPath);
        } catch (UnsupportedOperationException uoe) {
            throw new IOException("Unsupported Operation");
        }
    }

    /* PROCESSING */
    /**
     * 
     * @param inputText
     * 
     * @return info regarding this process, idk
     */
    public ArrayList<String[]> processString(String inputText) throws IOException {
        
        ArrayList<String[]> alStoreResults = new ArrayList<>();
        alStoreResults.add(processSmallString(inputText));
        boolean mostRecentSplit = Boolean.getBoolean(alStoreResults.get(0)[1]);
        int i = 0;
        while (mostRecentSplit) {
            inputText = inputText.substring(Integer.parseInt(alStoreResults.get(i)[2]));
            i++;
        }
    }

    /**
     * 
     * @param inputText
     * 
     * @return info regarding this process, idk
     */
    private String[] processSmallString(String inputText) throws IOException {
        BufferedImage buffImage = null;
        Double mod = 1.;
        if (inRGB) {
            buffImage = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_3BYTE_BGR);
        } else {
            buffImage = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_BYTE_GRAY);
        }
        char[] textArray = inputText.toCharArray();
        int index = 0, x = 0, y = 0, splitIndex = 0;
        boolean willBeSplit = false;
        while (index < textArray.length) {
            buffImage.setRGB(x, y, Heatmap.getColorForChar(textArray[index]).getRGB());
            index++;
            x++;
            if (x == imageSize) {
                x = 0;
                y++;
            }
            if (y == imageSize) {
                willBeSplit = true;
                splitIndex = index;
                break;
            }
        }
        String[] returnInfo = new String[3]; //Path, willBeSplit, splitIndex
        writeMap(buffImage);
        returnInfo[0] = outputPath.toString();
        returnInfo[1] = String.valueOf(willBeSplit);
        returnInfo[2] = Integer.toString(splitIndex);
        
        return returnInfo;
    }

    /**
     * Just writes the heatmap to the desired place
     * 
     * @param completedBuffer
     */
    private void writeMap(BufferedImage completedBuffer) throws IOException {
        File newImageFile = new File(outputPath.toString() + "\\Image" + filesProcessed + ".png");
        try {
            Files.createDirectories(outputPath.getParent());
            ImageIO.write(completedBuffer, "png", newImageFile);   
        } catch (IOException e) {
            throw e;
        }
        filesProcessed++;
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

    public Boolean getRGB() {
        return this.inRGB;
    }

    public void setRGB(Boolean convertToRGB) {
        this.inRGB = convertToRGB;
    }

}
