public class App {
    public static void main(String[] args) throws Exception {
        WordList wordList = new WordList("/Words.txt");
        System.out.println(wordList.getWords().get().get(0));
        System.out.println(wordList.getWords().get().get(4999));
        System.out.println(wordList.getWords().get().get(14853));
    }
}
