import java.util.Optional;

public enum Color {
    GRAY('_'),
    YELLOW('Y'),
    GREEN('G');

    public final char charRepresentation;

    private Color(char c) {
        charRepresentation = c;
    }

    // even though this takes a String, it should really just
    // be an emoji (1 char in human terms)! don't be fooled!
    public static Optional<Color> fromCharacter(char c) {
        for (Color color : Color.values()) {
            if (c == color.charRepresentation) {
                return Optional.of(color);
            }
        }

        return Optional.empty();
    }
}