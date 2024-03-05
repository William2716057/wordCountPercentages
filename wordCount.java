import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class wordCount {
    public static void main(String[] args) {

        File file = new File("input.txt"); //replace with own file

        //Map to store frequencies
        Map<String, Integer> wordFreq = new HashMap<>();

        try {
            //initialise scanner
            Scanner scanner = new Scanner(file);

            //Particles to be excluded from count
            List<String> particles = Arrays.asList("the", "and", "or", "but", "of", "in", "on", "at");

            //Total word count
            int totalWords = 0;

            //Read each line
            while (scanner.hasNextLine()) {
                //Split line into words
                String[] words = scanner.nextLine().split("\\s+");

                //Count frequencies
                for (String word : words) {
                    //Convert words to lowercase
                    word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");

                    //Check if word is not a particle
                    if (!particles.contains(word) && !word.isEmpty()) {
                        wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
                        totalWords++;
                    }
                }
            }


            scanner.close();

            //Display results
            System.out.println("Most used words:");
            for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
                double percentage = (double) entry.getValue() / totalWords * 100;
                System.out.printf("%s: %.2f%%\n", entry.getKey(), percentage);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}
