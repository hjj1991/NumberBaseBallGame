package org.example.baseball;

public class ResultView {

    public static void ballCnt(int ballCnt){
        System.out.print(ballCnt + "볼 ");
    }

    public static void strikeCnt(int strikeCnt) {
        System.out.println(strikeCnt + "스트라이크");
    }

    public static void nothing(){
        System.out.print("낫싱");
    }


    public static boolean view(ResultValue resultValue){

        if(resultValue.isEndGame()){
            strikeCnt(resultValue.getStrike());
            return true;
        }

        if(resultValue.getBall() > 0 && resultValue.getStrike() > 0){
            ballCnt(resultValue.getBall());
            strikeCnt(resultValue.getStrike());
            return false;
        }

        if(resultValue.getBall() > 0 ){
            ballCnt(resultValue.getBall());
            return false;
        }

        if(resultValue.getStrike() > 0){
            strikeCnt(resultValue.getStrike());
            return false;
        }

        nothing();
        return false;

    }
}
