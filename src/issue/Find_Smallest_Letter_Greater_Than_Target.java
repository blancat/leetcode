package issue;

/**
 * Created by sendo on 20/01/2018.
 */
public class Find_Smallest_Letter_Greater_Than_Target {

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'c';
        char result =  nextGreatestLetter(letters, target);
        System.out.print(result);
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        for (char c : letters) {
            if (c > target) return c;
        }
        return letters[0];
    }
}
