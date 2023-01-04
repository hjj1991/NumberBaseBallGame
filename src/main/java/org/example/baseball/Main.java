package org.example.baseball;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        boolean isStart = true;

        while (isStart) {
            isStart = InputView.gameStart();
        }
    }


}
