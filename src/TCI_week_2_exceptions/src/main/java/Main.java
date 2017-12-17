import java.util.Date;

/**
 * Created by lore on 25-7-17.
 */
final class Main {
    /**
     * Application entry class.
     */
    private Main() {

    }

    /**
     * Main entry point for the application.
     *
     * @param args application arguments.
     */
    public static void main(final String[] args) {
        final School school = new School("Fontys", new Date());
    }
}
