package dylan.main;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dylan on 08/05/2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Test");
        HashMap<String, Integer> uniqueMap = new HashMap();
        for(int i = 0; i < 1000; i++){
            RandomImage image = new RandomImage();
            image.generateRandomBinaryImage();

            if(!uniqueMap.containsKey(image.gridAsString)) {
                uniqueMap.put(image.gridAsString, RandomImage.id);
                image.writeImage();
            }
            else{
                System.out.println("DUPLICATE");
            }
        }

        for (Map.Entry<String, Integer> entry : uniqueMap.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

    }
}
