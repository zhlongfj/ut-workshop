import GuessNumber.AnswerGenerator;
import org.junit.Test;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by zhl on 15/2/2.
 */
public class AnswerGeneratorTest {



    @Test
    public void generate_a_random_digit_without_repeat_test_lenght_is_4(){
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator();

        //when
        String digit = answerGenerator.generateARandomDigitWithoutRepeat();

        //then
        assertThat(digit.length()).isEqualTo(4);
    }

    @Test
    public void generate_a_random_digit_without_repeat_test_is_a_digit_string(){
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator();

        //when
        String digit = answerGenerator.generateARandomDigitWithoutRepeat();
        boolean isDigit = isDigit(digit);

        //then
        assertThat(isDigit).isEqualTo(true);
    }

    private boolean isDigit(String digit) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isDigit = pattern.matcher(digit);
        return isDigit.matches();
    }

    @Test
    public void generate_a_random_digit_without_repeat_test_is_a_string_without_repeat(){
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator();

        //when
        String digit = answerGenerator.generateARandomDigitWithoutRepeat();
        boolean isRepeat = isRepeat(digit);

        //then
        assertThat(isRepeat).isEqualTo(false);
    }

    private boolean isRepeat(String digit) {
        HashSet<Character> number = new HashSet<Character>();
        for (int i = 0; i < digit.length(); i++) {
            number.add(digit.charAt(i));
        }
        int n = number.size();
        boolean isRepeat = (number.size() < digit.length()) ? true : false;
        return isRepeat;
    }

}
