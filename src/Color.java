import java.util.Optional;

public enum Color {
    GRAY('_', "⬛️"),
    YELLOW('Y', "🟨"),
    GREEN('G', "🟩");

    public final char asciiRepresentation;
    public final String emojiRepresentation;

    private Color(char c, String emoji) {
        asciiRepresentation = c;
        emojiRepresentation = emoji;
    }

    // even though this takes a String, it should really just
    // be an emoji (1 char in human terms)! don't be fooled!
    public static Optional<Color> fromCharacter(char c) {
        for (Color color : Color.values()) {
            if (c == color.asciiRepresentation) {
                return Optional.of(color);
            }
        }

        return Optional.empty();
    }
}