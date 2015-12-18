import java.io.*;

/**
 * Created by yiwengao on 4/25/15.
 */
public class ColorProblem {
    public static void main (String args[]) throws Exception {


           BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                   new FileOutputStream("result2.txt"), "utf-8"));
           FileInputStream fstream = new FileInputStream("/Users/yiwengao/tomato/src/main/resources/color-small.in");
           BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

           String strLine;
           int number = 1;
           br.readLine();
           //Read File Line By Line
           while ((strLine = br.readLine()) != null) {
               String[] splitted = strLine.split(" ");
               long k = Long.valueOf(splitted[0]);
               long v = Long.valueOf(splitted[1]);

               String output = output(number, k, v);

               System.out.println(output);
               writer.append(output);
               writer.newLine();
               number++;
           }

           //Close the input stream
           br.close();
           writer.close();
       }

       public static String output(int number, long k, long v){


           long total = 0;
           for (long i =0 ; i<=k ; i ++) {
           //    System.out.println("i :" + i);
               long j = 0;
               for (long ii = i; ii >= i - v && ii >= 0; ii--) {
                   j++;

               }
            //   System.out.println("j :" + j);

               if (j>1){
                   total = total+ j*j*3-2-3*(j-1);


               } else {
                   total = total +j;
               }
           }
           return "Case #" +number + ": " + total;

       }
}
