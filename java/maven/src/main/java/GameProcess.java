import java.io.PrintStream;

/**
 * Created by zhl on 15/2/8.
 */
public class GameProcess {
    private PrintStream out;

    public GameProcess(PrintStream out) {

        this.out = out;
    }

    public void start() {
        out.println("Welcome!");
        out.println("Please input your number(6): ");
    }
}
