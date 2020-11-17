package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/meeting-rooms/
 * 
 * @author fabiano
 *
 */
public class MeetingRooms {

    /**
     * 
     * 
     * Time complexity : O(nlog⁡n). The time complexity is dominated by sorting.
     * Once the array has been sorted, only O(n) time is taken to go through the
     * array and determine if there is any overlap.
     * 
     * Space complexity : O(1). Since no additional space is allocated.
     * 
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Comparator<int[]> comp = new Comparator<int[]>() {
            public int compare(int[] ob1, int[] ob2) {
                return ob1[0] - ob2[0];
            }
        };
        Arrays.sort(intervals, comp);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }

    public boolean canAttendMeetingsWithLambda(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] { { 5, 10 }, { 0, 4 }, { 15, 20 } };
        boolean response = new MeetingRooms().canAttendMeetings(intervals);
        System.out.println(response);
    }
}
