import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by zhl on 15/2/6.
 */
public class GuessTest {
    @Test
    public void should_return_0A4B_when_input_is_1234_mock_answer_is_4321() {
        String input = "1234";
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("4321");
        Guess guess = new Guess(answerGenerator, new GuessNumber());

        String result = guess.guessNumber(input);

        assertThat(result).isEqualTo("0A4B");
    }

    @Test
    public void should_return_congratulations_when_input_is_1234_mock_answer_is_1234() {
        String input = "1234";
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        Guess guess = new Guess(answerGenerator, new GuessNumber());

        String result = guess.guessNumber(input);

        assertThat(result).isEqualTo("Congratulations!");
    }

    @Test
    public void should_return_error_info_when_input_is_1223_mock_answer_is_1234() {
        String input = "1223";
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        Guess guess = new Guess(answerGenerator, new GuessNumber());

        String result = guess.guessNumber(input);

        assertThat(result).isEqualTo("Cannot input duplicate numbers!");
    }

    @Test
    public void should_return_error_info_when_input_is_12345_mock_answer_is_1234() {
        String input = "12345";
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        Guess guess = new Guess(answerGenerator, new GuessNumber());

        String result = guess.guessNumber(input);

        assertThat(result).isEqualTo("Must input 4 digits String!");
    }

    @Test
    public void should_return_error_info_when_input_is_123_mock_answer_is_1234() {
        String input = "123";
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        Guess guess = new Guess(answerGenerator, new GuessNumber());

        String result = guess.guessNumber(input);

        assertThat(result).isEqualTo("Must input 4 digits String!");
    }

    @Test
    public void should_return_error_info_when_input_is_123b_mock_answer_is_1234() {
        String input = "123b";
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        Guess guess = new Guess(answerGenerator, new GuessNumber());

        String result = guess.guessNumber(input);

        assertThat(result).isEqualTo("Must input 4 digits String!");
    }

    @Test
    public void should_return_game_over_when_input_error_in_6_times() {
        String input = "1235";
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        Guess guess = new Guess(answerGenerator, new GuessNumber());

        String result = null;
        for (int i = 0; i < 6; i++) {
            result = guess.guessNumber(input);
        }

        assertThat(result).isEqualTo("Game Over");
    }

    @Test
    public void should_return_1A1B_when_input_is_1356_and_answer_is_1234_called_twice() {
        String input = "1356";
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234", "1357");
        Guess guess = new Guess(answerGenerator, new GuessNumber());

        String result = guess.guessNumber(input);
        assertThat(result).isEqualTo("1A1B");
        assertThat(result).isEqualTo("1A1B");
    }

    @Test
    public void should_generate_called_once() {
        String input = "1235";
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        Guess guess = new Guess(answerGenerator, new GuessNumber());

        for (int i = 0; i < 6; i++) {
            guess.guessNumber(input);
        }

        verify(answerGenerator, atLeastOnce()).generate();
        verify(answerGenerator, atMost(1)).generate();
    }

    
}
