package leet;


import java.util.ArrayList;

public class IntervalProblem {
    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
            ArrayList<Interval> result = new ArrayList<Interval>();
            if (intervals.isEmpty()) {
                result.add(newInterval);
                return result;
            }
            if (newInterval.end < intervals.get(0).start) {
                result.add(newInterval);
                result.addAll(intervals);
                return result;
            }

            if (newInterval.start > intervals.get(intervals.size() - 1).end) {
                result.addAll(intervals);
                result.add(newInterval);
                return result;
            }


            int insertPos = 0;
            for (Interval interval : intervals) {
                if (interval.start > newInterval.end) {
                    result.add(interval);
                } else if (interval.end < newInterval.start) {
                    result.add(interval);
                    insertPos++;
                } else {
                    newInterval.end = Math.max(newInterval.end, interval.end);
                    newInterval.start = Math.min(newInterval.start, interval.start);
                }

            }


            result.add(insertPos, newInterval);

            return result;

        }

    }
}
