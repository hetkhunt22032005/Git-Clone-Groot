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

    public static void removeRepo() {
        File dir = new File(".groot");
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Error: No such repository or Directory Exist.");
            return;
        }
        System.out.println("Removing .groot repository...");
        if (deleteDir(dir)) {
            System.out.println(".groot repository successfully removed.");
        } else {
            System.out.println("Error: Failed to remove repository");
        }
    }

    public static boolean deleteDir(File dir) {
        if (!dir.exists()) {
            return false;
        }
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (!deleteDir(file)) { // recursively delete subdirectory
                        return false;
                    }
                } else {
                    if (!file.delete()) { // delete file
                        return false;
                    }
                }
            }
        }
        return dir.delete();
    }
}
