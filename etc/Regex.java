import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.regex.Pattern;
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        System.out.println("Enter REGEX and Test string");
        while (in.hasNext()) {
            String regex = in.nextLine();
            String test = in.nextLine();
            System.out.printf("%s\n", Pattern.matches(regex, test));
        }
    }
}
