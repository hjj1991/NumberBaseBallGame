package org.example.baseball;

import java.util.LinkedHashSet;
import java.util.List;

public class BaseBall {
    LinkedHashSet<Integer> baseBallValue = new LinkedHashSet<>();

    public void setBaseBallValue(){
        while (baseBallValue.size() < 3) {
            baseBallValue.add((int) (Math.random() * (9 - 2)) + 1);
        }
    }

    public LinkedHashSet<Integer> getBaseBallValue(){
        return baseBallValue;
    }

    public boolean isCollect(String[] number) {
        int strikeCnt = getStrike(number);
        if (strikeCnt == 3) {
            return true;
        }

        int ballCnt = getBall(number) - strikeCnt;
        if (ballCnt > 0) {
            ResultView.ballCnt(ballCnt);
        }

        if (strikeCnt > 0) {
            ResultView.strikeCnt(strikeCnt);
        }

        if (ballCnt == 0 && strikeCnt == 0) {
            ResultView.nothing();
        }

        System.out.println();

        return false;
    }

    public int getStrike(String[] inputNum) {
        List<Integer> integerList = baseBallValue.stream().toList();
        int strike = 0;
        for (int i = 0; i < inputNum.length; i++) {
            strike += isStrike(integerList.get(i), Integer.parseInt(inputNum[i]));
        }

        return strike;
    }

    public int getBall(String[] inputNum) {
        int ball = 0;
        for (int i = 0; i < inputNum.length; i++) {
            ball += isBall(Integer.parseInt(inputNum[i]));
        }

        return ball;
    }

    public int isStrike(int a, int b) {
        if (a == b) {
            return 1;
        }
        return 0;
    }

    public int isBall(int num) {
        if (baseBallValue.contains(num)) {
            return 1;
        }

        return 0;
    }
}
