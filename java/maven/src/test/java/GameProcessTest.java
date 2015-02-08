import org.junit.Test;

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
}
