package cli;

import java.util.List;

public class CommandParser {

    private final List<String> validTypes = List.of("playing", "popular", "top", "upcoming");

    public String getType(String[] args) {
        for(int i = 0; i < args.length; i++) {
            if ("--type".equals(args[i]) && (i + 1) < args.length && isAValidType(args[i + 1])) {
                return args[i + 1];
            }
        }
        System.out.println("Invalid arguments. Searching for popular movies.");
        return "popular";
    }

    private boolean isAValidType(String type) {
        return validTypes.contains(type);
    }

}
