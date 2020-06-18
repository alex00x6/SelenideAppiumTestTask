package android.data;

public class Jokes {

    public static String ribbedCondoms() {
        return "Chuck Norris uses ribbed condoms inside out, so he gets the pleasure.";
    }

    public static String ribbedCondoms(String firstName, String lastName) {
        return String.format("%s %s uses ribbed condoms inside out, so he gets the pleasure.", firstName, lastName);
    }
}
