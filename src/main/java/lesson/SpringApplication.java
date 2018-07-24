package lesson;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.*;

@SpringBootApplication
public class SpringApplication {

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class);

    }


    public boolean isNStraightHand(int[] hand, int W) {

        if (hand.length % W != 0)
            return false;

        if (hand.length == 1)
            return true;

        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int number : hand) {
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        while (!countMap.isEmpty()) {
            int min = ((TreeMap<Integer, Integer>) countMap).firstKey();
            for (int i = 0; i < W; i++) {
                if (!countMap.containsKey(min + i))
                    return false;

                int temp = countMap.get(min + i) - 1;
                if (temp == 0)
                    countMap.remove(min + i);
                else
                    countMap.put(min + i, temp);
            }
        }

        return true;

    }





    private class Car {
        private int position;
        private int speed;

        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }

}
