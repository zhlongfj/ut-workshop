import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by zhl on 15/2/7.
 */
public class GameProcessTest {
    @Test
    public void should_print_welcome_when_game_start() {
        PrintStream out = mock(PrintStream.class);
        GameProcess game = new GameProcess(out);

        verify(out, never()).print("Welcome!");
        game.start();
        verify(out).print("Welcome!");
    }

    @Test
    public void should_print_please_input_after_game_start() {
        PrintStream out = mock(PrintStream.class);
        GameProcess game = new GameProcess(out);

        game.start();
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6): ");

    }
}
