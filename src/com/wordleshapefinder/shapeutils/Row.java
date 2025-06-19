package com.wordleshapefinder.shapeutils;

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

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Row)) {
            return false;
        }
        if (other.equals(null)) {
            return false;
        }
        Row otherRow = (Row) other;
        Color[] otherColorArray = otherRow.asArray();
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
