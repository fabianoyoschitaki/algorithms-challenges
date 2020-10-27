package hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        return grades.stream().map(grade -> {
            if (grade >= 38 && grade % 5 >= 3){
                return grade + 5 - grade % 5;
            }
            return grade; 
        }).collect(Collectors.toList());
    }

}

public class GradingStudents {
    public static void main(String[] args) throws IOException {
        List<Integer> result = Result.gradingStudents(Arrays.asList(73, 67, 38, 33));
        for (Integer grade : result) {
            System.out.println(grade);
        }
    }
}
