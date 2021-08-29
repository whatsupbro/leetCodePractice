//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 
// 👍 532 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder mf = new FindMedianFromDataStream().new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        PriorityQueue<Integer> queueMin;
        PriorityQueue<Integer> queueMax;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            //queueMax 存放了后半段数据
            queueMax = new PriorityQueue<>((a, b) -> (b - a));
            //queueMin 存放了前半段数据
            queueMin = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (queueMin.size() == 0) {
                queueMin.add(num);
            } else {
                if (num >= queueMin.peek()) {
                    queueMin.add(num);
                } else {
                    queueMax.add(num);
                }
                if (queueMax.size() > queueMin.size() + 1) {
                    queueMin.add(queueMax.poll());
                } else if (queueMin.size() > queueMax.size() + 1) {
                    queueMax.add(queueMin.poll());
                }
            }
        }

        public double findMedian() {
            if (queueMin.size() > queueMax.size()) return queueMin.peek();
            else if (queueMin.size() < queueMax.size()) return queueMax.peek();
            else return ((double) queueMin.peek() + (double) queueMax.peek()) / 2.0;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}