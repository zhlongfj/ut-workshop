import GuessNumber.AnswerGenerator;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by zhl on 15/2/2.
 */
public class AnswerGeneratorTest {

    @Test
    public void should_generate_4_digits_string(){
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator(new Random());

        //when
        String result = answerGenerator.generate();

        //then
        assertThat(result.length()).isEqualTo(4);
    }

    @Test
    public void should_generate_number(){
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator(new Random());

        //when
        String result = answerGenerator.generate();
        try {
            Integer.parseInt(result);
        } catch (NumberFormatException e) {
            fail("result should be number");
        }
    }

    @Test
    public void should_generate_no_duplicated_digits_string(){
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator(new Random());

        //when
        String result = answerGenerator.generate();

        //then
        for (int i = 0; i < result.length(); i++) {
            assertThat(result.indexOf(i)).isEqualTo(result.lastIndexOf(i));
        }
    }

    @Test
    public void should_no_repeat_3_times(){
        Random random = mock(Random.class);
        given(random.nextInt(10))
                .willReturn(1,2,3,4)
                .willReturn(1,2,3,4)
                .willReturn(2,3,4,5)
                .willReturn(5,6,7,8);

        AnswerGenerator answerGenerator = new AnswerGenerator(random);
        Set<String> result = new HashSet<String>();
        result.add(answerGenerator.generate());
        result.add(answerGenerator.generate());
        result.add(answerGenerator.generate());

        assertThat(result.size()).isEqualTo(3);
    }

}
