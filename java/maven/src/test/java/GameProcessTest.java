import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by zhl on 15/2/7.
 */
public class GameProcessTest {

    private PrintStream out;
    private GameProcess game;

    @Before
    public void setUp() throws Exception {
        out = mock(PrintStream.class);
        game = new GameProcess(out);
    }

    @Test
    public void should_print_welcome_when_game_start() {
        verify(out, never()).println("Welcome!");
        game.start();
        verify(out).println("Welcome!");
    }

    @Test
    public void should_print_please_input_after_game_start() {
        game.start();
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6): ");
    }

    @Test
    public void should_() {

    }
}
