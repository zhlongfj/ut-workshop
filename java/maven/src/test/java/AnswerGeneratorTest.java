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
        boolean isDigitExpect = true;

        //when
        AnswerGenerator answerGenerator = new AnswerGenerator();
        String digit = answerGenerator.generateARandomDigitWithoutRepeat();
        boolean isDigit = isDigit(digit);

        //then
        assertThat(isDigit).isEqualTo(isDigitExpect);
    }

    private boolean isDigit(String digit) {
        boolean isDigit = true;
        for (int i = 0; i < digit.length(); i++) {
            if (!Character.isDigit(digit.charAt(i))) {
                isDigit = false;
                break;
            }
        }
        return isDigit;
    }

    @Test
    public void generate_a_random_digit_without_repeat_test_is_a_string_without_repeat(){
        //given
        boolean isRepeatExpect = false;

        //when
        AnswerGenerator answerGenerator = new AnswerGenerator();
        String digit = answerGenerator.generateARandomDigitWithoutRepeat();
        boolean isRepeat = isRepeat(digit);

        //then
        assertThat(isRepeat).isEqualTo(isRepeatExpect);
    }

    private boolean isRepeat(String digit) {
        boolean isRepeat = false;
        String tmp = "";
        for (int i = 0; i < digit.length(); i++) {
            if (tmp.contains(String.valueOf(digit.charAt(i)))) {
                isRepeat = true;
                break;
            }

            tmp += digit.charAt(i);
        }
        return isRepeat;
    }

}
