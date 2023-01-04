package org.example.baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static void startMsg(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void inputNumberMsg(){
        System.out.print("숫자를 입력해주세요 : ");
    }


    public static boolean gameStart() throws IOException {
        startMsg();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input.equals("2")){
            return false;
        }


        Balls balls = Utils.initRandBalls();
        boolean isGameContinue = true;
        while (isGameContinue){
            inputNumberMsg();
            List<Integer> integers = inputNumber();
            ResultValue resultValue = balls.playGame(integers);

            isGameContinue = !ResultView.view(resultValue);
            System.out.println();
        }


        return true;
    }

    public static List<Integer> inputNumber() throws IOException {
        String input = "";
        while (input.length() != 3){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine();
        }
        return Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
