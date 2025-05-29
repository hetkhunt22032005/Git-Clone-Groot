
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: groot <command>");
            return;
        }

        String command = args[0];

        switch (command) {
            case "init":
                Groot.init();
                break;
            case "remove":
                Groot.removeRepo();
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}
