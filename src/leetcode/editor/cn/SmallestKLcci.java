//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 堆 排序 分治算法 
// 👍 47 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class SmallestKLcci {
    public static void main(String[] args) {
        Solution solution = new SmallestKLcci().new Solution();
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        solution.smallestK(arr, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] smallestK1(int[] arr, int k) {
            if (k > arr.length) return null;
            if (k == arr.length) return arr;
            BigHeap heap = new BigHeap(k);
            for (int i = 0; i < k; i++) heap.add(arr[i]);
            for (int i = k; i < arr.length; i++) if (arr[i] < heap.getTop()) heap.replace(arr[i]);
            return heap.data;
        }

        public int[] smallestK(int[] arr, int k) {
            if (k > arr.length) return null;
            if (k == arr.length) return arr;
            int left = 0;
            int right = arr.length - 1;
            while (k > 0) {
                //得到cur 其左边为最小的arr.len-cur个
                int cur = fastSort(arr, left, right);
                //0-cur 和 0-cur-1 均为最小的
                if (cur == k - 1 || cur == k) break;
                    //需要在左边的数组里面继续寻找，缩小右边界
                else if (cur > k) right = cur - 1;
                    //需要在右边的数组继续找，缩小左边界
                else left = cur + 1;
            }
            return Arrays.copyOfRange(arr, 0, k);
        }

        //快排返回中间的值
        public int fastSort(int[] arr, int start, int end) {
            int left = start;
            int right = end;
            //待排序的第一个元素作为基准值
            int key = arr[left];

            //从左右两边交替扫描，直到left = right
            while (left < right) {
                while (right > left && arr[right] >= key) {
                    //从右往左扫描，找到第一个比基准值小的元素
                    right--;
                }

                //找到这种元素将arr[right]放入arr[left]中
                arr[left] = arr[right];

                while (left < right && arr[left] <= key) {
                    //从左往右扫描，找到第一个比基准值大的元素
                    left++;
                }

                //找到这种元素将arr[left]放入arr[right]中
                arr[right] = arr[left];
            }
            //基准值归位
            arr[left] = key;
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}