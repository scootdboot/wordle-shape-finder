public class Row {
    private final Color[] colorArray;

    public Row(Color[] colorArray) {
        this.colorArray = colorArray;
    }

    public Color[] asArray() {
        return colorArray.clone();
    }

    public int getLength() {
        return colorArray.length;
    }

    public boolean equals(Row other) {
        if (other.equals(null)) {
            return false;
        }
        Color[] otherColorArray = other.asArray();
        if (colorArray.length != otherColorArray.length) {
            return false;
        }
        for (int i = 0; i < colorArray.length; i++) {
            if (colorArray[i] != otherColorArray[i]) {
                return false;
            }
        }
        return true;
    }
}
