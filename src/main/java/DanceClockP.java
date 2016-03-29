import java.io.*;

/**
 * Created by ygao on 3/12/16.
 */
public class DanceClockP {

    public static void main(String args[]) {

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("small-dance.txt"), "utf-8"));
            FileInputStream fstream = new FileInputStream("/Users/ygao/tomato/src/main/resources/dance/small.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;
            int number = 1;
            br.readLine();
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                    String output = output(number, strLine);
                    System.out.println(output);
                    writer.append(output);
                    writer.newLine();

                number++;
            }

            //Close the input stream
            br.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    static class ListNode {
        int k;
        ListNode prev;
        ListNode next;

        public ListNode(int k, ListNode next, ListNode prev) {
            this.k = k;
            this.next = next;
            this.prev = prev;
        }
    }

    private static ListNode initList(int d) {
        ListNode dummy = new ListNode(0, null, null);
        ListNode head = new ListNode(1, null, null);
        ListNode tail = new ListNode(d, null, null);
        dummy.next = head;
        head.prev = dummy;
        tail.next = dummy;
        dummy.prev=tail;
        ListNode tmp = head;
        for (int i = 2; i < d; i++) {
            ListNode listNode = new ListNode(i, null, tmp);
            tmp.next = listNode;
            tmp = tmp.next;
        }
        tmp.next = tail;
        tail.prev = tmp;

        return head;


    }

    private static String output(int caseNo, String line) {
        String[] tmp = line.split(" ");
        int d = Integer.valueOf(tmp[0]);
        int k = Integer.valueOf(tmp[1]);
        int n = Integer.valueOf(tmp[2]);
        ListNode dummy = initList(d);
        int round = 1;
        while (round <= n) {
            if (round % 2 != 0) {
                swapWithNext(d / 2, dummy);
            } else {
                swapWithPrev(d / 2, dummy);
            }
            round++;

        }
        ListNode cur = dummy.next;
        while (cur.k != k) {
            cur = cur.next;
        }
        int left = cur.prev.k;
        int right = cur.next.k;
        String rstLine = "Case #" + caseNo + ": " + left + " " + right;
        return rstLine;


    }

    private static void swapWithNext(int pairs, ListNode dummy) {

        ListNode tmp = dummy.next;
        int count = 1;
        while (count <= pairs) {

            ListNode tmpPrev = tmp.prev;
            ListNode tmpNext = tmp.next;
            ListNode tmpNextNext = tmp.next.next;
            tmp.prev.next = tmpNext;
            tmp.next = tmpNextNext;
            tmpNext.next = tmp;
            tmpNextNext.prev = tmp;
            tmp.prev = tmpNext;
            tmpNext.prev = tmpPrev;
            count++;

        }

    }

    private static void swapWithPrev(int pairs, ListNode dummy) {

        ListNode tmp = dummy.prev;
        int count = 1;
        while (count <= pairs) {

            ListNode tmpPrev = tmp.prev;
            ListNode tmpNext = tmp.next;
            ListNode tmpPrevPrev = tmpPrev.prev;

            tmp.prev = tmpPrevPrev;
            tmpPrev.prev = tmp;
            tmpNext.prev = tmpPrev;
            tmpPrevPrev.next = tmp;
            tmp.next = tmpPrev;
            tmpPrev.next = tmpNext;
            count++;

        }


    }
}
