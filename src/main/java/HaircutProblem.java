import java.io.*;

/**
 * Created by yiwengao on 4/27/15.
 */
public class HaircutProblem {
    public static void main (String args[]) throws Exception {


        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
              new FileOutputStream("result-hair.txt"), "utf-8"));
        FileInputStream fstream = new FileInputStream("/Users/yiwengao/tomato/src/main/resources/hari-small.in");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        int number = 1;
        br.readLine();
        //Read File Line By Line
        while ((strLine = br.readLine()) != null) {
          String[] firstline = strLine.split(" ");
          int bcount = Integer.valueOf(firstline[0]);
          int pos = Integer.valueOf(firstline[1]);
            strLine = br.readLine();
          String[] btimeStr = strLine.split(" ");
          int[] btime = new int[bcount];
            for (int i = 0; i<bcount;i++){
                btime[i]=Integer.valueOf(btimeStr[i]);
            }
          String output = output(number,bcount, btime, pos);

          System.out.println(output);
          writer.append(output);
          writer.newLine();
          number++;
        }

        //Close the input stream
        br.close();
        writer.close();
    }

    public static String output(int number, int bcount, int[] btime, int pos){
        long[] sum = new long[bcount];
        for (int i = 0; i<bcount;i++){
            sum[i]=0;
        }
        int current = 0;
        int chosen = 0;
        while(current<pos) {
            chosen = chooseB(sum, bcount);
            sum[chosen] = sum[chosen] + btime[chosen];
            current++;

        }
        return  "Case #" +number + ": " + (chosen+1);


    }

    public static int chooseB(long[] sum, int bcount){
        long min = sum[0];
        int minIndex = 0;
        for (int i = 0; i < bcount; i ++){
            if (sum[i] < min){
                min = sum[i];
                minIndex= i;
            }
        }
        return minIndex;

    }

}
