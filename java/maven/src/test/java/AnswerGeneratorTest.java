import GuessNumber.AnswerGenerator;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by zhl on 15/2/2.
 */
public class AnswerGeneratorTest {

    @Test
    public void generate_a_random_digit_without_repeat_test_lenght_is_4(){
        //given
        int expect = 4;

        //when
        AnswerGenerator answerGenerator = new AnswerGenerator();
        String digit = answerGenerator.generateARandomDigitWithoutRepeat();

        //then
        assertThat(digit.length()).isEqualTo(4);
    }

    @Test
    public void generate_a_random_digit_without_repeat_test_is_a_digit_string(){
        //given
        int number = 0;

        //when
        AnswerGenerator answerGenerator = new AnswerGenerator();
        String digit = answerGenerator.generateARandomDigitWithoutRepeat();

        //then
        boolean isDigit = true;
        for (int i = 0; i < digit.length(); i++) {
            if (!Character.isDigit(digit.charAt(i))) {
                isDigit = false;
                break;
            }
        }

        assertThat(isDigit).isEqualTo(true);
    }

}
