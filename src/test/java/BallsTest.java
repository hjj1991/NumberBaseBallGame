import org.assertj.core.api.Assertions;
import org.example.baseball.BallStatus;
import org.example.baseball.Balls;
import org.example.baseball.BaseBall;
import org.example.baseball.ResultValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BallsTest {

    private Balls balls;

    @BeforeEach
    void setUp(){
        balls = new Balls(List.of(1, 2, 3));
    }

    @Test
    void endGame(){
        ResultValue resultValue = balls.playGame(List.of(1, 2, 3));

        Assertions.assertThat(resultValue.isEndGame()).isTrue();
    }

    @Test
    void stk1_ball2(){
        ResultValue resultValue = balls.playGame(List.of(1, 3, 2));

        Assertions.assertThat(resultValue.getStrike()).isEqualTo(1);
        Assertions.assertThat(resultValue.getBall()).isEqualTo(2);
    }

    @Test
    void stk0_ball3(){
        ResultValue resultValue = balls.playGame(List.of(3, 1, 2));

        Assertions.assertThat(resultValue.getStrike()).isEqualTo(0);
        Assertions.assertThat(resultValue.getBall()).isEqualTo(3);
    }

    @Test
    void strike(){
        BaseBall baseBall = new BaseBall(1, 1);
        BallStatus ballStatus = balls.checkStatus(baseBall);

        Assertions.assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }


    @Test
    void ball(){
        BaseBall baseBall = new BaseBall(1, 2);
        BallStatus ballStatus = balls.checkStatus(baseBall);

        Assertions.assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing(){
        BaseBall baseBall = new BaseBall(1, 4);
        BallStatus ballStatus = balls.checkStatus(baseBall);

        Assertions.assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
