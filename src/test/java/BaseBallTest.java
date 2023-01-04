import org.example.baseball.BaseBall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallTest {


    @Test
    @DisplayName("정답을 맞춘경우 정상 작동한다.")
    void isCollect_success() {

        // given
        BaseBall baseBall = new BaseBall();
        baseBall.getBaseBallValue().add(1);
        baseBall.getBaseBallValue().add(2);
        baseBall.getBaseBallValue().add(3);

        // when
        String[] inputNum = {"1", "2", "3"};

        // then
        Assertions.assertTrue(baseBall.isCollect(inputNum));

    }
}
