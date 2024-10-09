package util;

import java.security.SecureRandom;
import java.util.Random;

public class Utility {
    private static final String[] WORDS = {
            "quick", "brown", "fox", "jumps", "over", "lazy", "dog",
            "apple", "banana", "cherry", "grape", "orange", "pear",
            "mountain", "river", "ocean", "forest", "field", "sky",
            "happy", "sad", "angry", "excited", "calm", "relaxed"
    };

    public static String generateRandomGmail() {
        Random random = new Random();
        StringBuilder email = new StringBuilder();

        // Generate a random word for the username
        int wordIndex = random.nextInt(WORDS.length);
        email.append(WORDS[wordIndex]);

        // Add a random number to the username
        int randomNumber = random.nextInt(10000);
        email.append(randomNumber);

        // Append the Gmail domain
        email.append("@gmail.com");

        return email.toString();
    }

    private static final String[] FIRST_NAMES = {
            "Alice", "Bob", "Charlie", "David",
            "Eve", "Frank",
            "Grace", "Henry", "Ivy", "Jack", "Kate", "Leo",
            "Mary", "Noah", "Olivia", "Paul", "Quinn", "Riley",
            "Sarah", "Thomas", "Ursula", "Victor", "Wendy", "Xavier"
};

    public static String generateRandomFirstName() {
    Random random = new Random();
    int index = random.nextInt(FIRST_NAMES.length);
    return FIRST_NAMES[index];
}
    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Williams", "Jones", "Brown",
            "Davis", "Miller", "Wilson", "Moore", "Anderson",
            "Taylor", "Thomas", "Jackson", "White", "Harris",
            "Martin", "Thompson", "Garcia", "Martinez", "Clark"
    };

    public static String generateRandomLastName() {
        Random random = new Random();
        int index = random.nextInt(LAST_NAMES.length);
        return LAST_NAMES[index];
    }
    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max
                - min + 1) + min;
    }

    public static void main(String[] args) {
        int randomNumber = generateRandomNumber(1,
                100);
    }
    public static String generateRandomPassword(int length)
    {
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be positive.");
        }

        SecureRandom random = new SecureRandom();

        byte[] bytes = new byte[length];
        random.nextBytes(bytes);

        StringBuilder password = new StringBuilder();
        for (byte b : bytes) {
            password.append((char) (Math.abs(b) % 128));
        }

        return password.toString();
    }



}


