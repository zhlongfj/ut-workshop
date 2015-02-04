package GuessNumber;

/**
 * Created by zhl on 15/2/2.
 */
public class GuessNumber {
    public String getTips(String input, String answer) {
        int countsOfContainWithoutEqual = getCountsOfContain(input, answer) - getCountsOfEqual(input, answer);
        String tips = getCountsOfEqual(input, answer) + "A" + countsOfContainWithoutEqual + "B";
        return tips;
    }

    private int getCountsOfContain(String input, String answer) {
        int countsOfCotain = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (input.contains(String.valueOf(answer.charAt(i)))) {
                countsOfCotain++;
            }
        }
        return countsOfCotain;
    }

    private int getCountsOfEqual(String input, String answer) {
        int countsOfEuqal = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                countsOfEuqal++;
            }
        }
        return countsOfEuqal;
    }
}
