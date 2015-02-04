package GuessNumber;

/**
 * Created by zhl on 15/2/2.
 */
public class GuessNumber {
    public String getTips(String input, String answer) {
        String tips = getCountsOfEqual(input, answer) + "A" + countsOfContainWithoutEqual(input, answer) + "B";
        return tips;
    }

    private int countsOfContainWithoutEqual(String input, String answer) {
        return getCountsOfContain(input, answer) - getCountsOfEqual(input, answer);
    }

    private int getCountsOfContain(String input, String answer) {
        int countsOfContain = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (input.contains(String.valueOf(answer.charAt(i)))) {
                countsOfContain++;
            }
        }
        return countsOfContain;
    }

    private int getCountsOfEqual(String input, String answer) {
        int countsOfEqual = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                countsOfEqual++;
            }
        }
        return countsOfEqual;
    }
}
