import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPatternclass {


    public static void main(String[] args) {
        String text = "Reduce your credit card utilisation from @{utilisation}% to @{utilisation-20 <  25 ? 25 : utilisation-20}%";

        // Define the regex pattern to match @{ and capture the text inside the braces
        String regex = "@\\{([^}]*)\\}";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher for the input text
        Matcher matcher = pattern.matcher(text);

        // Check if a match is found
        while (matcher.find()) {
            // Extract the text inside the braces
            String extractedText = matcher.group(1);
            String replacedText = matcher.group(0);

            System.out.println("Extracted text: " + extractedText);
            text = text.replace(replacedText, extractedText);

        }
        System.out.println(text);
    }
}

