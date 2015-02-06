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

        //when
        GuessNumber guessNumber = new GuessNumber();
        String tips = guessNumber.getTips(input, answer);

        //then
        assertThat(tips).isEqualTo("4A0B");
    }

    @Test
    public void get_tips_test_return_0A4B_when_input_is_1234_and_answer_is_4321(){
        //given
        String input = "1234";
        String answer = "4321";

        //when
        GuessNumber guessNumber = new GuessNumber();
        String tips = guessNumber.getTips(input, answer);

        //then
        assertThat(tips).isEqualTo("0A4B");
    }

    @Test
    public void get_tips_test_return_0A4B_when_input_is_1234_and_answer_is_5678(){
        //given
        String input = "1234";
        String answer = "5678";

        //when
        GuessNumber guessNumber = new GuessNumber();
        String tips = guessNumber.getTips(input, answer);

        //then
        assertThat(tips).isEqualTo("0A0B");
    }

    @Test
    public void get_tips_test_return_2A2B_when_input_is_1234_and_answer_is_1324(){
        //given
        String input = "1234";
        String answer = "1324";

        //when
        GuessNumber guessNumber = new GuessNumber();
        String tips = guessNumber.getTips(input, answer);

        //then
        assertThat(tips).isEqualTo("2A2B");
    }
}
