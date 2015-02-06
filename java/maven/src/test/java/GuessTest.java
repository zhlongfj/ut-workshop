import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zhl on 15/2/6.
 */
public class GuessTest {
    @Test
    public void should_return_0A4B_when_input_is_1234_mock_answer_is_4321() {
        String input = "1234";
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);

        when(answerGenerator.generate()).thenReturn("4321");
        Guess guess = new Guess();
        String result = guess.guessNumber(input, answerGenerator);

        assertThat(result).isEqualTo("0A4B");
    }

    @Test
    public void should_return_congratulations_when_input_is_1234_mock_answer_is_1234() {
        String input = "1234";

        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        Guess guess = new Guess();
        String result = guess.guessNumber(input, answerGenerator);

        assertThat(result).isEqualTo("Congratulations!");
    }

    @Test
    public void should_return_error_info_when_input_is_1223_mock_answer_is_1234() {
        String input = "1223";
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        Guess guess = new Guess();
        String result = guess.guessNumber(input, answerGenerator);

        assertThat(result).isEqualTo("Cannot input duplicate numbers!");
    }

    @Test
    public void should_return_error_info_when_input_is_12345_mock_answer_is_1234() {
        String input = "12345";
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        Guess guess = new Guess();
        String result = guess.guessNumber(input, answerGenerator);

        assertThat(result).isEqualTo("Please input 4 digits String!");
    }

    @Test
    public void should_return_error_info_when_input_is_123_mock_answer_is_1234() {
        String input = "123";
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        Guess guess = new Guess();
        String result = guess.guessNumber(input, answerGenerator);

        assertThat(result).isEqualTo("Must input 4 digits String!");
    }

    @Test
    public void should_return_error_info_when_input_is_123b_mock_answer_is_1234() {
        String input = "123b";
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        Guess guess = new Guess();
        String result = guess.guessNumber(input, answerGenerator);

        assertThat(result).isEqualTo("Must input 4 digits String!");
    }

    @Test
    public void should_return_game_over_when_input_error_in_6_times() {
        String input = "1235";
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        Guess guess = new Guess();
        String result = null;
        for (int i = 0; i < 6; i++) {
            result = guess.guessNumber(input, answerGenerator);
        }

        assertThat(result).isEqualTo("Game Over");
    }
}
