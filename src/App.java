public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println(Color.fromText("⬛️").isPresent());
        // System.out.println(Color.fromText("⬛️").get().textRepresentation);

        // WordList wordList = new WordList("Words.txt");
        // System.out.println(wordList.getWords().get().get(0));
        // System.out.println(wordList.getWords().get().get(4999));
        // System.out.println(wordList.getWords().get().get(14853));

        String shapeString = "⬛🟩⬛🟨⬛\n🟩🟩🟩⬛⬛\n🟩🟩🟩⬛⬛\n🟩🟩🟩⬛🟨\n🟩🟩🟩🟩🟩\n⬛⬛⬛⬛⬛";
        Shape shape = new Shape(shapeString);
    }
}
