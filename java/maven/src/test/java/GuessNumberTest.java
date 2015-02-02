import GuessNumber.GuessNumber;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by zhl on 15/2/2.
 */
public class GuessNumberTest {
    @Test
    public void get_tips_test_return_4A0B_when_input_is_1234_and_answer_is_1234(){
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

    @Test
    public void get_tips_test_return_0A4B_when_input_is_1234_and_answer_is_4321(){
        //given
        String input = "1234";
        String answer = "4321";
        String tipsExpect = "0A4B";

        //when
        GuessNumber guessNumber = new GuessNumber();
        String tips = guessNumber.getTips(input, answer);

        //then
        assertThat(tips).isEqualTo(tipsExpect);
    }
}
