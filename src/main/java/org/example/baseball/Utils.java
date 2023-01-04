package org.example.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {

    public static Balls initRandBalls(){
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3){
            int randValue = random.nextInt(8) + 1;
            notExistsAdd(list, randValue);
        }

        return new Balls(list);
    }

    private static void notExistsAdd(List<Integer> list, int val){
        if(!list.contains(val)){
            list.add(val);
        }
    }
}
