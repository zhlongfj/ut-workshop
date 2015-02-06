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
}
