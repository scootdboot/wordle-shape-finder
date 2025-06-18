public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println(Color.fromText("⬛️").isPresent());
        // System.out.println(Color.fromText("⬛️").get().textRepresentation);

        // WordList wordList = new WordList("Words.txt");
        // System.out.println(wordList.getWords().get().get(0));
        // System.out.println(wordList.getWords().get().get(4999));
        // System.out.println(wordList.getWords().get().get(14853));

        String shapeString = "_G_Y_\nGGG__\nGGG__\nGGG_Y\nGGGGG\n_____";
        Shape shape = new Shape(shapeString);
        Color[][] shapeArray = shape.getColorArray();
        System.out.println("balls");
    }
}
