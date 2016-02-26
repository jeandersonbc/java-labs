import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 10, 0, 1000000, -123123, -99999999};
        for (int value : values) {
            System.out.printf("%-10d - %x\n", value, value);
        }
        System.out.println(String.format("Hi, my name is %s.", "Jeanderson"));

        // Exercise 7 - regex
        String[] phrases = {
            "Hi, my name is Jeanderson Candido :)",
            "starting with lower case yayy more tx",
            "starting 123 ?T^&*() &^9 w lwr cs",
            "Starting 123 ?T^&*() &^9 wh lo case.",
            "This is the 5678990 proper sentence.",
        };
        for (String phrase : phrases) {
            System.out.printf("Phrase: %s\t\t(%s)\n", phrase,
                    isFormatted(phrase) ? "matches" : "not matches");
        }
        // Exercise 9 - regex (modified)
        System.out.println("\n* Replacing all vowels by underscores *\n");
        for (String phrase : phrases) {
            System.out.printf("Original: %s\t\tModified: %s\n", phrase,
                    phrase.replaceAll("[aeiouAEIOU]", "_"));
        }
    }
    private static boolean isFormatted(String phrase) {
        Pattern pattern = Pattern.compile("[A-Z](.)*\\.");
        return pattern.matcher(phrase).matches();
    }
}
