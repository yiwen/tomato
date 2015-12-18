import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by yiwengao on 6/30/15.
 */
public class TestRobotWalk {

    @DataProvider(name = "testData")
    public Object[][] getData(){
        return new Object[][]{
                {null,"[0,0]" },
                {"","[0,0]" },
                {" ","[0,0]" },
                {"   ","[0,0]" },

                {"x","[0,0]" },

                {"R", "[0,0]"},
                {"L", "[0,0]"},
                {"F", "[0,1]"},
                {"X", "[0,0]"},

                {"RRLxLRRLL", "[0,0]"},
                {"RRLLRRLL", "[0,0]"},

                {"FxF", "[0,1]"},
                {"FF", "[0,2]"},
                {"FFRRLLRRLL", "[0,2]"},

                {"LLLFFRRLFFLRRFF", "[0,-2]"},
                {"LLLFFRLRFFLFF", "[4,-2]"},
                {"LFFFRFFFRRFFF", "[-3,0]"},
                {"LFFFRFFFRRFFFRL", "[-3,0]"},
                {"FFFRRFFFRRFFFRL", "[0,3]"},
                {"RLRLLFFFRFFFRRFFFRL", "[-3,0]"},
                {"RRFFFoRFFFRRFFFRL", "[0,-3]"},
                {"RRFFFRFFoFRRFFFRL", "[-2,-3]"},

        };
    }

    @Test(dataProvider = "testData")
    public void test(String instruction, String expected){
        String destination = RobotWalk.getPosition(instruction);
        Assert.assertEquals(destination, expected);
    }
}
