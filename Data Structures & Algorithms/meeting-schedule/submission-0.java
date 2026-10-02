/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (i1, i2) -> {
            Interval tmp1 = (Interval) i1;
            Interval tmp2 = (Interval) i2;

            if (tmp1.start > tmp2.start) return 1;
            if (tmp1.start < tmp2.start) return -1;
            return 0;
        });

        int end = -1;
        for (Interval interval : intervals) {
            System.out.print(interval.start);
            System.out.println(interval.end);
            if (end == -1) {
                end = interval.end;
                continue;
            }
            if (interval.start < end) return false;
            end = interval.end;
        }
        return true;
    }
}
