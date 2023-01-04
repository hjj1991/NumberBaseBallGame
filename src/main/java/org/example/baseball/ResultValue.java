package org.example.baseball;

public class ResultValue {
    private int strike = 0;
    private int ball = 0;


    public void ballStatusCountAdd(BallStatus ballStatus){
        if(BallStatus.STRIKE == ballStatus){
            strike++;
        }

        if(BallStatus.BALL == ballStatus){
            ball++;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isEndGame() {
        return strike == 3;
    }
}
