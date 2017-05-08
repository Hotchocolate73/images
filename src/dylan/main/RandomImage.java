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
    int a, r, g, b;
    int width = 10, height = 10;

    public RandomImage(){
        id++;
    }

    public void generateRandomColourImage(){
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
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

        try{
            f = new File("D:\\Users\\Dylan\\Desktop\\images\\output" + id + ".png");
            ImageIO.write(img, "png", f);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public void generateRandomBinaryImage(){
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        File f = null;

        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (Math.random() < 0.5) {
                    img.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    img.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }

        try{
            f = new File("D:\\Users\\Dylan\\Desktop\\images\\output" + id + ".png");
            ImageIO.write(img, "png", f);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
