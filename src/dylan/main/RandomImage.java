package dylan.main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dylan on 08/05/2017.
 */
public class RandomImage {

    public static int id = 0;
    public RandomImage(){
        int width = 100;
        int height = 100;

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        File f = null;

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int a = (int)(Math.random()*256);
                int r = (int)(Math.random()*256);
                int g = (int)(Math.random()*256);
                int b = (int)(Math.random()*256);

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
        id++;
    }
}
