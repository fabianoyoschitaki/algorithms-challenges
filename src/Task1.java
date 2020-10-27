import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(solution("ABDCA", new int[] {2,-1,-4,-3,3}, new int[] {2,-2,4,1,-3}));
    }
    
    public static int solution(String S, int[] X, int[] Y) {
        List<Tag> tags = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            tags.add(new Tag(S.charAt(i), getDistanceFromCenter(X[i], Y[i])));
        }
        Collections.sort(tags);
        int result = 0;
        Map<Character, Double> answer = new HashMap<>();
        for (Tag tag : tags) {
            if (!answer.containsKey(tag.getValue())) {
                answer.put(tag.getValue(), tag.getDistance());
                result++;
            } else {
                if (answer.get(tag.getValue()).equals(tag.getDistance())) {
                    return result-1;
                } else {
                    return result;
                }
            }
        }
        return result;
    }
    
    public static double getDistanceFromCenter(int x, int y) {
        return Math.sqrt(y * y + x * x);
    }
}

class Tag implements Comparable<Tag> {
    private Character value;
    private Double distance;
    
    public Tag(Character value, Double distance) {
        super();
        this.value = value;
        this.distance = distance;
    }
    public Character getValue() {
        return value;
    }
    public void setValue(Character value) {
        this.value = value;
    }
    public Double getDistance() {
        return distance;
    }
    public void setDistance(Double distance) {
        this.distance = distance;
    }
    @Override
    public int compareTo(Tag o) {
        return this.getDistance().compareTo(o.getDistance());
    }
}
