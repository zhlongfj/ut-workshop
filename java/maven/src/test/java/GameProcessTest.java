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
    public void should_print_please_input_the_same_chance_just_once() throws IOException {
        game.start();
        verify(out, atMost(1)).println("Please input your number(6): ");
        verify(out, atMost(1)).println("Please input your number(5): ");
        verify(out, atMost(1)).println("Please input your number(4): ");
        verify(out, atMost(1)).println("Please input your number(3): ");
        verify(out, atMost(1)).println("Please input your number(2): ");
        verify(out, atMost(1)).println("Please input your number(1): ");
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

    @Test
    public void should_print_congratulation_when_guess_right() throws IOException {
        given(read.readLine()).willReturn("4321");

        game.start();
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6): ");
        inOrder.verify(out, never()).println("4A0B");
        inOrder.verify(out).println("Congratulations!");
    }

    @Test
    public void should_print_congratulation_when_input_is_right_in_last_round() throws IOException {
        given(read.readLine())
                .willReturn("1234", "1234", "1234", "1234", "1234")
                .willReturn("4321");

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
        inOrder.verify(out, never()).println("4A0B");
        inOrder.verify(out).println("Congratulations!");
    }
}
