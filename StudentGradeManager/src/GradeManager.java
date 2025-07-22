import java.util.ArrayList;
import java.util.Arrays;

public class GradeManager {
    public static String[] reverseStudentNames(String[] names){
        String[] reversed = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            String reversedName = "";
            for (int j = name.length() - 1; j >= 0; j--) {
                reversedName += name.charAt(j);
            }
            reversed[i] = reversedName;
        }
        return reversed;
    }
    public static char getLetterGrade(int score){
        if(score<=100 && score>=90)
            return 'A';
        else if (score<=89 && score>=80)
            return 'B';
        else if(score<=79 && score>=70)
            return 'C';
        else if(score<=69 && score>=60)
            return 'D';
        else
            return 'F';
    }
    public static String[] findFailingStudents(String[] names, int[] scores){
        ArrayList<String> failing = new ArrayList<>();
        for (int i = 0; i <scores.length; i++) {
            if (scores[i]<60) {
                failing.add(names[i]);
            }
        }
        return failing.toArray(new String[0]);
    }
    public static void main(String[] args){
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};

        System.out.println(Arrays.toString(reverseStudentNames(students)));
        System.out.println(students[1]+" : "+getLetterGrade(scores[1]));
        System.out.println("Failing students: "+Arrays.toString(findFailingStudents(students, scores)));
    }


}
