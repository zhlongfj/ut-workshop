import GuessNumber.GuessNumber;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by zhl on 15/2/2.
 */
public class GuessNumberTest {
    @Test
    public void hello_world_test(){
        //given
        String input = "1234";
        String answer = "1234";
        String tipsExpect = "4A0B";

        //when
        GuessNumber guessNumber = new GuessNumber();
        String tips = guessNumber.getTips(input, answer);

        //then
        assertThat(tips).isEqualTo(tipsExpect);
    }
}
