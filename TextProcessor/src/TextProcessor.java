public class TextProcessor {
    public static int countWords(String sentence){
        if (sentence == null) return 0;
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }
    public static String replaceWord(String text, String oldWord, String newWord) {
        return text.replace(oldWord, newWord);
    }
    public static void main(String[] args) {
        String sentence = "Java is fun and Java is powerful";

        int wordCount = countWords(sentence);
        System.out.println("Word count: " + wordCount);
        String replaced = replaceWord(sentence, "Java", "Programming");
        System.out.println("After replacement: " + replaced);
    }
}
