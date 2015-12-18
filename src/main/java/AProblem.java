import java.io.*;

/**
 * Created by yiwengao on 4/23/15.
 */
public class AProblem {

    public static void main (String args[]) {

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                                  new FileOutputStream("small-output.txt"), "utf-8"));
            FileInputStream fstream = new FileInputStream("/Users/yiwengao/tomato/src/main/resources/a-problem/large-input.txt");
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
        } catch (Exception e){

        }

    }


    private static String output(int number, String line){
        String[] data = line.split(" ");
        int top = Integer.valueOf(data[0]);

        String input = data[1];

        int totalInvited = 0;
        int totalStandUp = Integer.valueOf(String.valueOf(input.charAt(0)));

        for (int i=1; i<=top; i++){
            if (Integer.valueOf(String.valueOf(input.charAt(i))) > 0 && totalStandUp < i){
                totalInvited = totalInvited + (i- totalStandUp);
                totalStandUp = i + Integer.valueOf(String.valueOf(input.charAt(i)));

            } else if (totalStandUp >=i){
                totalStandUp = totalStandUp + Integer.valueOf(String.valueOf(input.charAt(i)));
            }

        }
        return "Case #" + number + ": " + totalInvited;
    }
}
