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
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (Interval interval : intervals) {
            if (heap.isEmpty()) heap.add(interval);
        }
    }
}
