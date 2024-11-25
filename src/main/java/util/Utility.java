package util;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.P06_CheckOutPage;

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

//    private static final String[] FIRST_NAMES = {
//            "Alice", "Bob", "Charlie", "David",
//            "Eve", "Frank",
//            "Grace", "Henry", "Ivy", "Jack", "Kate", "Leo",
//            "Mary", "Noah", "Olivia", "Paul", "Quinn", "Riley",
//            "Sarah", "Thomas", "Ursula", "Victor", "Wendy", "Xavier"
//};

    public static String generateRandomFirstName() {
    Random random = new Random();
    int index = random.nextInt(FIRST_NAMES.length);
    return FIRST_NAMES[index];
}
//    private static final String[] LAST_NAMES = {
//            "Smith", "Johnson", "Williams", "Jones", "Brown",
//            "Davis", "Miller", "Wilson", "Moore", "Anderson",
//            "Taylor", "Thomas", "Jackson", "White", "Harris",
//            "Martin", "Thompson", "Garcia", "Martinez", "Clark"
//    };



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
    private static final String[] adjectives = {
            "Amazing", "Awesome", "Best", "Cool", "Fantastic", "Incredible", "Lovely",
            "Marvelous", "Superb", "Wonderful"
    };

    private static final String[] nouns = {
            "Gadget", "Gizmo", "Device", "Tool", "Machine", "Appliance", "System",
            "Utility", "Instrument", "Equipment"
    };
    public static String getRandomSearchValue() {
        // Define the array of search values
        String[] searchValues = {"MacBook", "iPhone", "iPod Touch", "iPod Classic"};

        // Create a Random object
        Random random = new Random();

        // Generate a random index from 0 to the length of the array - 1
        int randomIndex = random.nextInt(searchValues.length);

        // Return the value at the randomly selected index
        return searchValues[randomIndex];
    }
    //6-  RandomMethodsForBillingDetails
    // Arrays for random selection of names, companies, cities, etc.
    private static final String[] FIRST_NAMES = {"John", "Alice", "Robert", "Jessica", "Michael", "Sarah", "David", "Emily"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Brown", "Williams", "Jones", "Garcia", "Miller", "Davis"};
    private static final String[] COMPANIES = {"TechCorp", "InnoSolutions", "Webify", "DataMasters", "CloudSphere", "FastTrack", "CodeCraft", "Visionary"};
    private static final String[] CITIES = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "San Diego", "Austin", "Dallas"};
    private static final Random random = new Random();

    // Method to get a random first name
    public static String getFirstName() {
        return FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
    }

    // Method to get a random last name
    public static String getLastName() {
        return LAST_NAMES[random.nextInt(LAST_NAMES.length)];
    }

    // Method to get a random company
    public static String getCompany() {
        return COMPANIES[random.nextInt(COMPANIES.length)];
    }

    // Method to get a random address
    public static String getAddress() {
        return (random.nextInt(900) + 100) + " " + getRandomStreetName() + " St";
    }
    // Helper method to get a random street name
    public static String getRandomStreetName() {
        String[] streetNames = {"Main", "Oak", "Pine", "Maple", "Elm", "Cedar", "Washington", "2nd"};
        return streetNames[random.nextInt(streetNames.length)];
    }
    // Method to get a random city
    public static String getCity() {
        return CITIES[random.nextInt(CITIES.length)];
    }
    // Method to get a random postal code
    public static String getPostCode() {
        return String.format("%05d", random.nextInt(100000));
    }
    //7- Generate random comments for delivery methods


    // Method to generate random text with a specific length
    public static String generateRandomText(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ";
        StringBuilder randomText = new StringBuilder();
        Random random = new Random();

        // Generate random text of the specified length
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            randomText.append(characters.charAt(randomIndex));
        }

        return randomText.toString();
    }

    // Overloaded method to generate random text with a default length (e.g., 20 characters)
    public static String generateRandomText() {
        return generateRandomText(20); // Default length of 20 characters
    }
    public static String[] generateRandomRegisterData() {
        String[] userData = new String[6];
        // Random object for generating random values
        Random rand = new Random();
        // Array of first names
        String[] firstNames = {"John", "Jane", "David", "Emily", "Michael", "Sarah", "Christopher", "Jessica"};
        // Array of last names
        String[] lastNames = {"Doe", "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis"};
        // Generate random first name
        userData[0] = firstNames[rand.nextInt(firstNames.length)];
        // Generate random last name
        userData[1] = lastNames[rand.nextInt(lastNames.length)];
        // Generate timestamp-based unique identifier (example)
        long timestamp = System.currentTimeMillis();
        String uniqueId = String.valueOf(timestamp); // or use a random number generator

        // Generate email address with unique identifier
        userData[2] = userData[0].toLowerCase() + "." + userData[1].toLowerCase() + "+" + uniqueId + "@example.com";
        // Generate random phone number (11 digits starting with 011, 010, 012, or 015)
        String[] prefixes = {"011", "010", "012", "015"};
        String prefix = prefixes[rand.nextInt(prefixes.length)];
        userData[3] = prefix + String.format("%08d", rand.nextInt(100000000));
        // Generate random password (8 characters)
        userData[4] = generateRandomPassword(8);
        // Confirm password (same as generated password)
        userData[5] = userData[4];
        return userData;
    }










}


