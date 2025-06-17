import java.util.Optional;

public enum Color {
    GRAY("⬛️"),
    YELLOW("🟨"),
    GREEN("🟩");

    public final String textRepresentation;

    private Color(String s) {
        textRepresentation = s;
    }

    // even though this takes a String, it should really just
    // be an emoji (1 char in human terms)! don't be fooled!
    public static Optional<Color> fromText(String s) {
        // loop through colors and if there is a matching character
        // return the correct color
        for (Color color : Color.values()) {
            if (color.textRepresentation.equals(s)) {
                return Optional.of(color);
            }
        }

        // if there is not a matching color, empty Optional
        return Optional.empty();
    }
}