import java.io.*;

/**
 * Created by yiwengao on 4/25/15.
 */
public class IOProblem {
    public static void main (String args[]) throws Exception {


        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("result.txt"), "utf-8"));
        FileInputStream fstream = new FileInputStream("/Users/yiwengao/tomato/src/main/resources/IO-small.in");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        int number = 1;
        br.readLine();
        //Read File Line By Line
        while ((strLine = br.readLine()) != null) {
            int count = Integer.valueOf(strLine);
            String io = br.readLine();
            String output = output(number, count, io);

            System.out.println(output);
            writer.append(output);
            writer.newLine();
            number++;
        }

        //Close the input stream
        br.close();
        writer.close();
    }

    public static String output(int number, int count, String io){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Case #"+number + ": ");
        String replaced = io.replaceAll("I", "1");
        replaced = replaced.replaceAll("O", "0");

        for(int i =0; i <count; i++ ){
            String str =  replaced.substring(i*8, (i+1)*8);
            int v= Integer.parseInt(str, 2);
            stringBuilder.append(String.valueOf(Character.toChars(v)));
        }
        return stringBuilder.toString();

    }


}
