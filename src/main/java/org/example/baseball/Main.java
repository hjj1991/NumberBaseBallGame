package org.example.baseball;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        playGame();
    }

    private static void playGame() {
        Main main = new Main();
        boolean gameContinue = true;
        while (gameContinue) {
            InputView.startInfo();
            String input = main.inputText();

            gameContinue = isGameContinue(input);

        }
    }

    private static boolean isGameContinue(String inputGameStatus) {
        if (inputGameStatus.equals("2")) {
            return false;
        }


        BaseBall baseBall = new BaseBall();

        baseBall.setBaseBallValue();

        checkBall(baseBall);

        return true;
    }

    private static void checkBall(BaseBall baseBall) {
        boolean isCollect = false;
        while (!isCollect) {
            InputView.inputNumber();
            Main main = new Main();
            String answer = main.inputText();


            numberValidate(answer);

            String[] split = answer.split("");


            isCollect = baseBall.isCollect(split);
        }
    }

    private String inputText() {
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }

    private static void numberValidate(String number) {
        if (number.length() != 3 || number.contains("0")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

}
