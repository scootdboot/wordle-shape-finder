import java.util.Optional;

public class Shape {
    // remember that you should validate array and make sure
    // it's rectangular and 5 wide!
    public Shape(Color[][] shape, int width, int height) throws InvalidShapeException {

    }

    public Shape(Color[][] shape) throws InvalidShapeException {
        this(shape, 5, 6);
    }

    public Shape(String shapeString, int width, int height) throws InvalidShapeException {
        this(shapeStringToArray(shapeString, width, height), width, height);
    }

    public Shape(String shapeString) throws InvalidShapeException {
        this(shapeStringToArray(shapeString, 5, 6), 5, 6);
    }

    private static Color[][] shapeStringToArray(
            String shapeString, 
            int width, 
            int height) throws InvalidShapeException {
        final int rowCharacterCount = width * 2;

        // validation, ensure string is formatted correctly
        String[] rows = shapeString.split("\n");
        if (rows.length != height) {
            throw new InvalidShapeException("Incorrect number of rows");
        }
        for (String row : rows) {
            if (row.length() != rowCharacterCount) {
                throw new InvalidShapeException("Incorrect number of characters in one or more rows");
            }
        }
        
        Color[][] rtn = new Color[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                String currentString = rows[row].substring(col * 2, col * 2 + 2);
                Optional<Color> currentColorOptional = Color.fromText(currentString);
                if (currentColorOptional.isEmpty()) {
                    throw new InvalidShapeException("Invalid character present in String");
                }
                Color currentColor = currentColorOptional.get();
                rtn[row][col] = currentColor;
            }
        }

        return rtn;
    }

    public static class InvalidShapeException extends Exception {
        public InvalidShapeException(String m) {
            super(m);
        }
    }

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

    
}
