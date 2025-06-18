import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Shape {
    private final Row[] shapeArray;

    // i don't really like this naming convention for parameter vs instance
    // but i can't think of anything better
    public Shape(Row[] shapeArray) throws InvalidShapeException {
        if (shapeArray.length < 1) {
            throw new InvalidShapeException("Empty array passed to constructor");
        }
        int rowWidth = shapeArray[0].getLength();
        // if there's only one row, we don't need to check width is consistent
        if (shapeArray.length != 1) {
            for (Row row : shapeArray) {
                if (row.getLength() != rowWidth) {
                    throw new InvalidShapeException("Inconsistent row width in Shape");
                }
            }
        }

        this.shapeArray = shapeArray;
    }

    public Shape(String shapeArrayString) throws InvalidShapeException {
        this(stringToRowArray(shapeArrayString));
    }

    public Row[] getRowArray() {
        return shapeArray;
    }

    public Set<Row> getOptimizedSet() {
        List<Row> uniqueValues = new ArrayList<Row>();
        // loop through each row
        for (Row r : shapeArray) {
            boolean unique = true;
            // loop through everything already checked and make sure its unique
            for (Row uniqueR : uniqueValues) {
                // if it isn't unique, set the flag to false
                if (r.equals(uniqueR)) {
                    unique = false;
                }
            }

            if (unique) {
                uniqueValues.add(r);
            }
        }
        return Set.copyOf(uniqueValues);
    }

    /**
     * @param shapeArrayString Array representing the Shape you would like to create using ASCII characters
     * @return An array of Rows that represents the Shape that the shapeArrayString passed represented
     * @throws InvalidShapeException
     */
    public static Row[] stringToRowArray(String shapeArrayString) throws InvalidShapeException {
        String[] stringRows = shapeArrayString.split("\n");
        if (stringRows.length == 0) {
            throw new InvalidShapeException("String with 0 rows somehow attempted to be processed");
        }
        int width = stringRows[0].length();
        // if there is more than one row, go through and check they are all the same length
        if (stringRows.length > 1) {
            for (int i = 1; i < stringRows.length; i++) {
                if (stringRows[i].length() != width) { 
                    throw new InvalidShapeException("Inconsistent row width attempted to be processed");
                }
            }
        }

        // go through each ascii character in each String and convert to a Color, put in a row
        Row[] rtn = new Row[stringRows.length];
        // iterate through each row
        for (int rowIndex = 0; rowIndex < stringRows.length; rowIndex++) {
            char[] rowChars = stringRows[rowIndex].toCharArray();
            Color[] convertedColors = new Color[rowChars.length]; // convertedColors will have same length as rowChars
            // iterate through each character of each row
            for (int colIndex = 0; colIndex < rowChars.length; colIndex++) {
                Optional<Color> colorOptional = Color.fromCharacter(rowChars[colIndex]);
                if (colorOptional.isEmpty()) {
                    throw new InvalidShapeException("Invalid character attempted to be processed");
                }
                convertedColors[colIndex] = colorOptional.get();
            }
            Row currentRow = new Row(convertedColors);
            rtn[rowIndex] = currentRow;
        }

        return rtn;
    }

    public static class InvalidShapeException extends Exception {
        public InvalidShapeException(String m) {
            super(m);
        }
    }
}
