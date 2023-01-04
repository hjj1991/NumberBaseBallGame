package org.example.baseball;

import java.util.Objects;

public class BaseBall {

    private int index;
    private int number;

    public BaseBall(int index, int number) {
        validateNumber(number);
        this.index = index;
        this.number = number;
    }

    public BallStatus playGame(BaseBall ball) {

        if(this.equals(ball)){
            return BallStatus.STRIKE;
        }

        if(ball.isBall(number)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }


    private boolean isBall(int number){
        return this.number == number;
    }

    private void validateNumber(int number){
        if(number < 1 || number > 9){
            throw new IllegalArgumentException("숫자의 범위가 잘못되었습니다.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBall baseBall = (BaseBall) o;
        return index == baseBall.index && number == baseBall.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, number);
    }
}
