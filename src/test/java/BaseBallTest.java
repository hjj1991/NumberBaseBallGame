import org.assertj.core.api.Assertions;
import org.example.baseball.BallStatus;
import org.example.baseball.BaseBall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseBallTest {

    private BaseBall ball;

    @BeforeEach
    void setUp(){
        ball = new BaseBall(1, 2);
    }


    @Test
    void strike() {
        BallStatus ballStatus = ball.playGame(new BaseBall(1, 2));
        Assertions.assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        BallStatus ballStatus = ball.playGame(new BaseBall(2, 2));
        Assertions.assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        BallStatus ballStatus = ball.playGame(new BaseBall(1, 3));
        Assertions.assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
