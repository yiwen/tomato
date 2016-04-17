package leet;

import java.util.Arrays;

/**
 * Created by yiwengao on 12/22/15.
 */
public class BinarySearch {
    public int searchInsert(int[] A, int target) {
        //write your code here
        if (A.length == 0) {
            return -1;
        }
        int start = -1;
        int end = A.length;
        while (start + 1 < end) {

            int midPos = start + (end - start) / 2;
            int mid = A[midPos];
            if (mid == target) {
                return midPos;
            } else if (mid > target) {
                end = midPos;
            } else if (mid < target) {
                start = midPos;
            }
        }
        return start + 1;
    }


    public int binarySearch(int[] nums, int target) {
        //write your code here

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = -1;
        int end = nums.length;
        int mid;
        while (start + 1 < end) {
            mid = (end + start) / 2;


            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {

            return -1;
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // write your code here
        int sm = 0;
        int sn = -1;

        int m = matrix.length;
        int n = matrix[0].length;
        int em = m - 1;
        int en = n;
        int mPos;
        int nPos;
        int sPos = -1;
        int ePos = m * n;
        while (sPos + 1 < ePos) {

            int mid = (em * n + en + sm * n + sn) / 2;
            mPos = mid / n;
            nPos = mid - mPos * n - 1;
            if (matrix[mPos][nPos] < target) {
                sm = mPos;
                sn = nPos;
            } else {
                em = mPos;
                en = nPos;
            }

            sPos = sm * n + sn;
            ePos = em * n + en;

        }

        if (ePos != m * n && matrix[em][en] == target) {
            return true;
        } else {
            return false;
        }

    }

    public int sqrt(int x) {
        if (x < 0) {
            return -1;
        }

        // write your code here
        int start = 0;
        long end = (long) x + 1;

        while (start + 1 < end) {
            long mid = (long) (start + end) / 2;
            long tmp = mid * mid;
            if (tmp == x) {
                return (int) mid;
            }
            if (tmp > x) {
                end = (int) mid;
            } else {
                start = (int) mid;
            }
        }


        return start;


    }


    public int findMin(int[] num) {
        // write your code here
        int start = num[0];
        int end = num.length - 1;
        int target = end;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == num[mid]) {
                return mid;
            }
            if (target < num[mid]) {
                start = mid;
            }
            if (target >= num[mid]) {
                end = mid;
            }
        }
        if (num[start] <= num[end]) {
            return num[start];
        } else {
            return num[end];
        }
    }


    //rotate array
    public static int search(int[] A, int target) {
        if (A.length == 0) {
            return -1;
        }
        // write your code here
        int start = 0;
        int end = A.length - 1;
        int first = A[start];
        int last = A[end];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int m = A[mid];
            if (m == target) {
                return mid;
            }
            if (start < m) {
                if (target <= m && target >= first) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target >= m && target <= last) {
                    start = mid;
                } else {
                    end = mid;
                }
            }


        }
        if (A[start] == target) {
            return start;

        }
        if (A[end] == target) {
            return end;
        }

        return -1;


    }

    public int[] searchRange(int[] A, int target) {
        // write your code here
        int start = 0;
        int end = A.length - 1;
        int rangeStart;
        int rangeEnd;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] >= target) {
                end = mid;
            }
            if (A[mid] < target) {
                start = mid;
            }

        }
        if (A[start] == target) {
            rangeStart = start;
        } else if (A[end] == target) {
            rangeStart = end;
        } else {
            return new int[]{1, 1};
        }
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            }
            if (A[mid] > target) {
                end = mid;
            }


        }
        if (A[end] == target) {
            rangeEnd = end;
        } else if (A[start] == target) {
            rangeEnd = start;
        } else {
            return new int[]{1, 1};
        }
        return new int[]{rangeStart, rangeEnd};

    }


    public static int findFirstBadVersion(int n) {
        if (n <= 0) {
            return -1;
        }

        // write your code here
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }

        }
        if (SVNRepo.isBadVersion(start)) {
            return start;
        } else if (SVNRepo.isBadVersion(end)) {
            return end;
        }
        {

            return -1;
        }


    }

    class ArrayReader {
        // get the number at index, return -1 if not exists.
        public int get(int index) {
            return index;
        }
    }

    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here

        int start = 0;
        int index = 1;
        while (reader.get(index - 1) < target && reader.get(index - 1) != -1) {
            index = index * 2;
        }

        int end = index - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (target > reader.get(mid) && reader.get(mid) != -1) {
                start = mid;
            } else {
                end = mid;
            }

        }
        if (reader.get(start) == target) {
            return start;
        } else if (reader.get(end) == target) {
            return end;
        } else {
            return -1;
        }
    }


    public int totalOccurrence(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // Write your code here
        int start = 0;
        int end = A.length - 1;
        int total = 0;
        while (A[start] < target) {
            start++;
        }
        while (A[end] > target) {
            end--;
        }


        return end - start + 1;

    }

    public static int totalOccurrenceBST(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int starPos = 0;
        int endPos = end;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            }
            if (A[mid] > target) {
                end = mid;
            }

        }
        if (A[end] == target) {
            endPos = end;
        } else if (A[start] == target) {
            endPos = start;

        } else {
            return 0;
        }

        start = 0;
        end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            }
            if (A[mid] < target) {
                start = mid;
            }


        }
        if (A[start] == target) {
            starPos = start;


        } else if (A[end] == target) {
            starPos = end;


        }
        System.out.println("endpos:" + endPos);

        System.out.println("startpos:" + starPos);

        return endPos - starPos + 1;


    }

    public static void main(String[] args) {
        int[] A = {3, 3, 3};
        System.out.println(totalOccurrenceBST(A, 3));
    }


    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        // Write your code here
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] < target) {
                start = mid;
            }
            if (A[mid] > target) {
                end = mid;
            }
        }
        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return Math.abs(target - A[start]) < Math.abs(A[end] - target) ? start : end;
    }

    public int lastPosition(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // Write your code here
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            }
            if (A[mid] > target) {
                end = mid;
            }
        }
        if (A[end] == target) {
            return end;

        } else if (A[start] == target) {
            return start;
        } else {
            return 0;
        }
    }

    public int findPosition(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        // Write your code here
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] < target) {
                start = mid;
            }
            if (A[mid] > target) {
                end = mid;
            }
        }
        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        } else {
            return -1;
        }

    }

    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        if (A == null || A.length == 0 || k > A.length) {
            return new int[k];
        }
        if (k == 0) {
            return null;
        }
        int start = 0;
        int end = A.length - 1;
        int pos = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                pos = mid;
                break;
            }
            if (A[mid] < target) {
                start = mid;
            }
            if (A[mid] > target) {
                end = mid;
            }
        }
        if (pos == 0) {
            if (A[start] == target) {
                pos = start;
            } else if (A[end] == target) {
                pos = end;
            } else {
                pos = target - A[start] < A[end] - target ? start : end;
            }
        }

        int[] rst = new int[k];
        rst[0] = A[pos];
        int left = pos - 1;
        int right = pos + 1;
        int count = 1;
        int minDiff = Integer.MIN_VALUE;
        while (left >= 0 && right <= A.length - 1 && count < k) {

            while (left > 0 && target - A[left] <= A[right] - target && count < k) {
                count++;
                rst[count] = A[left];
                left--;

            }

            if (left == 0 && target - A[left] <= A[right] - target && count < k) {
                count++;
                rst[count] = A[0];
            }
            while (right < A.length - 1 && A[right] - target < target - A[left] && count < k) {
                count++;
                rst[count] = A[right];
                right++;

            }
            if (right == A.length - 1 && A[right] - target < target - A[left] && count < k) {
                count++;
                rst[count] = A[A.length - 1];
            }

        }

        if (left < 0) {
            while (right <= A.length - 1 && count < k) {
                count++;
                rst[count] = A[right];
                right++;

            }
        } else if (right > A.length - 1) {
            while (left >= 0 && count < k) {
                count++;
                rst[count] = A[left];
                left--;

            }
        }


        return rst;


    }

    public int findPeak(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid - 1]) {
                start = mid;
            } else if (A[mid] < A[mid + 1]) {
                end = mid;
            } else {
                end = mid;
            }
        }
        return A[start] > A[end] ? start : end;
    }

    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0 || k <= 0) {
            return 0;
        }
        Arrays.sort(L);
        int start = 1;
        int end = L[L.length - 1];
        int max = Integer.MIN_VALUE;
        while (start + 1 < end) {
            int len = start + (end - start) / 2;
            int totalCuts = getTotal(L, len);
            if (totalCuts >= k) {
                start = len;
            } else {
                end = len;
            }

        }
        if (getTotal(L, end) >= k) {
            return end;
        }
        if (getTotal(L, start) >= k) {
            return start;
        }
        return 0;


    }

    int getTotal(int[] L, int len) {
        int total = 0;
        for (int i = 0; i < L.length; i++) {
            total = L[i] / len + total;
        }
        return total;
    }


    public static int search_rotate(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target > A[start]) {
                if (A[mid] > target) {
                    end = mid;
                } else if (A[mid] > A[start]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                if (A[mid] < target) {
                    start = mid;
                } else if (A[mid] > A[start]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if(A[start]==target){
            return start;
        }else if(A[end]==target){
            return end;
        }else{
            return -1;
        }

    }
    public static int search_rotate_withDup(int[] num, int target) {
        int start = 0;
        int end = num.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(target==num[mid]){
                return mid;
            }else if (target > num[start]) {
                if (num[mid] > target) {
                    end = mid;
                } else if (num[mid] >= num[start]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                if (num[mid] < target) {
                    start = mid;
                } else if (num[mid] >= num[start]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if(num[start]==target){
            return start;
        }else if(num[end]==target){
            return end;
        }else{
            return -1;
        }

    }

    public int[] kClosestNumbers_2(int[] A, int target, int k) {
        if(k<0 || A==null ||A.length==0){
            return new int[]{};
        }
        int start = 0;
        int end = A.length-1;
        int posT = -1;
        while(start+1 < end){
            int mid = start + (end-start )/2;
            if (A[mid]==target){
                posT = mid;
            }
            if (A[mid] >target){
                end = mid;
            }else {
                start = mid;
            }
        }
        if (posT <0){
            posT = Math.abs(A[start] - target)< Math.abs(A[end] - target) ? start : end;
        }
        int[] rst = new int[k];
        rst[0] = A[posT];
        int count = 1;
        int left = posT-1;
        int right = posT +1;
        while(left >=0 && right<=A.length-1 && count<k){
            if(Math.abs(A[left] - target) <= Math.abs(A[right] - target)){

                rst[count]=A[left];

                left--;
            }else {
                rst[count]=A[right];

                right++;
            }
            count++;

        }
        if (left<0){
            while(count<k &&right<=A.length-1 ){
                rst[count]=A[right];
                right++;
                count++;
            }
        }
        if (right>A.length-1){
            while(count<k &&left>0 ){
                rst[count]=A[left];
                left--;
                count++;
            }
        }
        return rst;

    }

}