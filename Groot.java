import java.io.File;

public class Groot {
    public static void init() {
        File grootDir = new File(".groot");

        if (grootDir.exists()) {
            System.out.println("Repository already initialized.");
            return;
        }

        if (grootDir.mkdir()) {
            new File(".groot/commits").mkdir();
            new File(".groot/objects").mkdir();

            try {
                new File(".groot/HEAD").createNewFile();
                new File(".groot/index").createNewFile();
                System.out.println("Initialized empty Groot repository in " + grootDir.getAbsolutePath());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Failed to create .groot directory.");
        }
    }
}
