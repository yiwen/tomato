package leet;


import java.util.*;

public class IntervalProblem {

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


    public static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args){
        Interval i1 = new Interval(2,3);
        Interval i2= new Interval(2,2);
        Interval i3= new Interval(3,3);
        Interval i4= new Interval(1,3);
        Interval i5= new Interval(5,7);
        Interval i6= new Interval(2,2);
        Interval i7= new Interval(4,6);

        List<Interval> intervals = Arrays.asList(i1, i2, i3, i4, i5, i6, i7);

        merge(intervals);


    }
    private static void print(List<Interval> intervals) {
        System.out.print("[");

        for(Interval interval : intervals){
            System.out.print("[" +interval.start  +","+interval.end+ "],");
        }
        System.out.println("]");

    }
    public static List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals == null){
            return null;
        }
        if (intervals.size()<=1){
            return intervals;
        }
        Collections.sort(intervals, new IntervalComparator());
        print(intervals);
        List<Interval> rst = new ArrayList<Interval>();
        Interval cur = intervals.get(0);

       for (int j = 1; j < intervals.size() ; j++){
           Interval next = intervals.get(j);
           if(cur.end <next.start) {
              rst.add(cur);
              cur = next;
               continue;


          }
           cur.end = Math.max(next.end, cur.end);


       }

      rst.add(cur);

        return rst;


    }

    public static class IntervalComparator implements Comparator<Interval>{

        public int compare(Interval interval1, Interval interval2) {
            if(interval1==null || interval2==null){
                      return 0;
          }
          if (interval1.start ==interval2.start){
              return 0;
          }

          if (interval1.start > interval2.start){
              return 1;
          } else {
              return -1;

          }

        }
    }

}
