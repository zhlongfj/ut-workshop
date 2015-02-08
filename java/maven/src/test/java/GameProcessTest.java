import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Created by zhl on 15/2/7.
 */
public class GameProcessTest {

    private PrintStream out;
    private GameProcess game;
    private BufferedReader read;
    private AnswerGenerator answerGenerator;

    @Before
    public void setUp() throws Exception {
        out = mock(PrintStream.class);
        read = mock(BufferedReader.class);
        answerGenerator = mock(AnswerGenerator.class);
        GuessNumber guessNumber = new GuessNumber();
        game = new GameProcess(out, read, answerGenerator, guessNumber);

        given(read.readLine()).willReturn("1234");
        given(answerGenerator.generate()).willReturn("4321");
    }

    @Test
    public void should_print_welcome_when_game_start() throws IOException {
        verify(out, never()).println("Welcome!");
        game.start();
        verify(out).println("Welcome!");
    }

    @Test
    public void should_print_please_input_after_game_start() throws IOException {

        game.start();
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6): ");
    }

    @Test
    public void should_reduce_one_chance_when_guess_wrong() throws IOException {

        game.start();
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6): ");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(5): ");

    }

    @Test
    public void should_reduce_chances_one_by_one_until_game_over() throws IOException {
        game.start();
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6): ");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(5): ");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(4): ");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(3): ");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(2): ");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(1): ");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Game Over");
    }
}
