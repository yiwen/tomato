package leet;

/**
 * Created by ygao on 12/21/15.
 */
public class HashMapProblems {

    public static int hashCode(char[] key,int HASH_SIZE) {
        long v = 0;
        // write your code here
        for (int i = key.length -1; i>=0;i--) {
            int av = (int)key[i];
            v= v + av * power33(key.length-1-i);

        }
        return (int)v%HASH_SIZE;

    }

    private static  long power33(int i){
        int j = 1;
        for (int m=1; m<=i;m++){
            j=j*33;
        }
        return j;
    }

    public static void main(String[] args){
        hashCode("ubuntu".toCharArray(), 1007);
    }
}
