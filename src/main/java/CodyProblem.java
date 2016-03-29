import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ygao on 3/12/16.
 */
public class CodyProblem {

    public static void main(String args[]) {

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("small-output.txt"), "utf-8"));
            FileInputStream fstream = new FileInputStream("/Users/ygao/tomato/src/main/resources/cody/small-input.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;
            int number = 1;
            br.readLine();
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                if (number%2==0) {
                    String output = output(number, strLine);
                    System.out.println(output);
                    writer.append(output);
                    writer.newLine();
                }
                number++;
            }

            //Close the input stream
            br.close();
            writer.close();
        } catch (Exception e) {

        }

    }

    static class Item {
        int val;
        boolean isOrigin;
        boolean isChecked;

        public Item(int val, boolean isOrigin, boolean isChecked) {
            this.val = val;
            this.isOrigin = isOrigin;
            this.isChecked = isChecked;
        }
    }

    private static String output(int caseNo, String line) {
        String[] tmp = line.split(" ");
        List<Item> items = new ArrayList<Item>();
        for (int i = 0; i < tmp.length; i++) {
            items.add(new Item(Integer.valueOf(tmp[i]), false, false));
        }
        items.get(items.size() - 1).isOrigin=true;
        items.get(items.size() - 1).isChecked=false;

        int sp = 0;

        int op = items.size() - 1;

        while (sp <op) {
            if (!items.get(sp).isOrigin && !items.get(sp).isChecked) {
                int originPrice = (int) (items.get(sp).val / 0.75);
                findOrigin(items, sp + 1, originPrice);
                items.get(sp).isChecked=true;
                items.get(sp).isOrigin=false;

            }
            sp++;

            if (items.get(op).isOrigin && !items.get(op).isChecked) {
                int salep = (int) (items.get(op).val * 0.75);
                findSale(items, op - 1, salep);
                items.get(op).isChecked=true;
                items.get(op).isOrigin=true;

            }
            op--;


        }
        String rstLine = "Case #:" + caseNo/2;
        for (Item el : items){
            if(!el.isOrigin){
                rstLine = rstLine + " " + el.val;
            }

        }
        return rstLine;
    }
    private static void findOrigin(List<Item> items, int pos, int val){
        for (int i = pos;i<items.size();i++){
            if(items.get(i).val ==val && !items.get(i).isChecked){
                items.get(i).isOrigin=true;
                items.get(i).isChecked=true;

                return;
            }
        }

    }
    private static void findSale(List<Item> items, int pos, int val){
        for (int i = pos;i>=0;i--){
            if(items.get(i).val ==val  && !items.get(i).isChecked){
                items.get(i).isOrigin=false;
                items.get(i).isChecked=true;
                return;
            }
        }

    }



}

