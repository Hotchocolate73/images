package dylan.main;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dylan on 08/05/2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Test");
        HashMap<int[][], Integer> uniqueMap = new HashMap();
        for(int i = 0; i < 10; i++){
            RandomImage image = new RandomImage();
            image.generateRandomBinaryImage();

            if(!uniqueMap.containsKey(image.grid)) {
                uniqueMap.put(image.grid, RandomImage.id);
                image.writeImage();
            }
        }

        for (Map.Entry<int[][], Integer> entry : uniqueMap.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

    }
}
