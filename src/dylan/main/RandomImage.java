package dylan.main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dylan on 08/05/2017.
 */
public class RandomImage {

    public static int id = 0;
    public static int writeId = 0;
    int a, r, g, b;
    int width = 2, height = 2;
    BufferedImage img;
    int[][] grid = new int[height][width];
    String gridAsString = "";

    public RandomImage(){
        id++;
    }

    public void generateRandomColourImage(){
        System.out.println("Creating random colour image with id " + id);
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        File f = null;

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                a = (int)(Math.random()*256);
                r = (int)(Math.random()*256);
                g = (int)(Math.random()*256);
                b = (int)(Math.random()*256);
                int p = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(x, y, p);
            }
        }

        writeImage();
        System.out.println("Creating random colour image with id " + id + " COMPLETE");
    }

    public void generateRandomBinaryImage(){
        System.out.println("Creating binary image with id " + id);
        img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);

        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (Math.random() < 0.5) {
                    img.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    img.setRGB(x, y, Color.BLACK.getRGB());
                }

                grid[y][x] = img.getRGB(x, y);
                gridAsString += grid[y][x];
            }
        }

        System.out.println("Creating binary image with id " + id + " COMPLETE");
    }

    public void writeImage(){
        writeId++;
        File f = null;

        try{
            f = new File("D:\\Users\\Dylan\\Desktop\\images\\output" + writeId + "(" + id + ").png");
            ImageIO.write(img, "png", f);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
