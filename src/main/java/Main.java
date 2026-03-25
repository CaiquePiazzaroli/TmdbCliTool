import cli.CommandParser;

public class Main {
    public static void main(String[] args) {

        CommandParser parser = new CommandParser();
        String type = parser.getType(args);

        System.out.println(type);
    }
}
