import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by zhl on 15/2/8.
 */
public class GameProcess {
    private PrintStream out;
    private final BufferedReader read;
    private final AnswerGenerator answerGenerator;
    private final GuessNumber guessNumber;

    public GameProcess(PrintStream out, BufferedReader read, AnswerGenerator answerGenerator, GuessNumber guessNumber) {

        this.out = out;
        this.read = read;
        this.answerGenerator = answerGenerator;
        this.guessNumber = guessNumber;
    }

    public void start() throws IOException {
        out.println("Welcome!");
        int roundCount = 6;
        String tips = "";
        while (roundCount > 0) {
            out.println("Please input your number(" + roundCount + "): ");
            String answer = answerGenerator.generate();
            String input = read.readLine();
            tips = guessNumber.getTips(input, answer);

            if ("4A0B".equals(tips)) {
                break;
            }
            out.println(tips);
            roundCount--;
        }

        if ("4A0B".equals(tips)) {
            out.println("Congratulations!");
            return ;
        }

        out.println("Game Over");

    }
}
