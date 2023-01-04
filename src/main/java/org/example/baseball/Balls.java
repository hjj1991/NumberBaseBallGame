package org.example.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Balls {
    private List<BaseBall> balls = new ArrayList<>();


    public Balls(List<Integer> balls) {
        for (int i = 0; i < balls.size(); i++) {
            this.balls.add(new BaseBall(i+1, balls.get(i)));
        }
    }


    public BallStatus checkStatus(BaseBall baseBall) {
        return balls.stream()
                .map(ball -> ball.playGame(baseBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public ResultValue playGame(List<Integer> balls) {
        ResultValue resultValue = new ResultValue();
        for (int i = 0; i < balls.size(); i++) {
            BaseBall baseBall = new BaseBall(i + 1, balls.get(i));
            BallStatus ballStatus = checkStatus(baseBall);
            resultValue.ballStatusCountAdd(ballStatus);
        }
        return resultValue;
    }



}
