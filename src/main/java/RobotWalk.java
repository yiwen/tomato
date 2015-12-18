import java.util.*;

/**
 * Created by yiwengao on 6/30/15.
 *
 *
 */
public class RobotWalk {

    /** This method takes instruction as input, and generates the position on a grid
     * these instructions, such as LFFFRFFFRRFFF,
     * where "L" is a "turn 90 degrees left", "R" is a "turn 90 degrees right", and "F" is "go forward one space,
     * the method returns the appropriate-and-correct destination under the instruction
     *
     * the start point is [x,y] = [0,0], with x is the horizontal grid, y is the vertical grid.
     *
     * when instruction has character other than F, L ,R
     * it returns the final position before encountering the invalid step
     * and log the invalid step ( in the code, the implementation is to print to standard.out
     *
     * @param instruction  a string with only characters of F, L, R
     * @return  the position of the end point
     */

    public static String getPosition(String instruction){
        if(instruction == null || instruction.trim().length()==0){
            return "[0,0]";
        }
        char[] steps = instruction.toCharArray();
        List<Character> list = new ArrayList<Character>();
        for (char c : steps){
            list.add(Character.valueOf(c));
        }
        Iterator<Character> iterator = list.iterator();
        int x = 0;
        int y= 0;
        // the degree counter for recording the turnning direction
        int degree =0;
        int netDegree = 0;
        boolean end=false ;
        while(iterator.hasNext()){
            char c = iterator.next();
            if ( c != 'L' && c != 'R'  && c != 'F') {
                System.out.println("Encounter invalid step: (" + c + ")");
                break;
            }
            // looping for the direction , L or R step
            while (!end && c!= 'F') {
                if (c == 'L') {
                    degree = degree - 90;
                } else if (c == 'R') {
                    degree = degree + 90;
                } else {
                    System.out.println("Encounter invalid step: (" + c + ")");
                    end = true;
                    break;
                }
                if (iterator.hasNext()) {
                    c = iterator.next();
                } else {
                    end=true;
                    break;
                }

                // calculate the net degree based on the degree
                netDegree = degree % 360 >=0 ? degree % 360 : 360 + degree % 360;

            }
            // if not encounter invalid char or not the end of the instruction
            if (!end) {

                if (netDegree == 0 ) {
                    y++;
                } else if (netDegree == 90) {
                    x++;
                } else if (netDegree == 180) {
                    y--;
                } else if (netDegree == 270) {
                    x--;
                }
            }

        }
        return "["+ x + "," +y + "]";
    }

}
