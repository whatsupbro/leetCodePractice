package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @description: 大顶堆 有待测试哦
 * @author: miao
 * @create: 2021-03-26
 **/

public class BigHeap extends Heap {
    public BigHeap(int k) {
        super(k);
    }

    public BigHeap() {
        super();
    }

    @Override
    public void add(int num) {
        if (size == MAX_SIZE) {
            //扩容
            MAX_SIZE = (int) (MAX_SIZE * 1.5);
            data = Arrays.copyOf(data, MAX_SIZE);
        }
        data[size++] = num;
        int i = size - 1;
        while (i > 0) {
            int father = i % 2 == 0 ? i / 2 - 1 : i / 2;
            if (data[father] >= data[i]) break;
            else {
                data[father] = data[i] + data[father];
                data[i] = data[father] - data[i];
                data[father] = data[father] - data[i];
                i = father;
            }
        }
    }

    @Override
    public void replace(int replaceNum) {
        data[0] = replaceNum;
        adjust(0);
    }

    @Override
    public int getTop() {
        return data[0];
    }

    private void adjust(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int change = -1;
        if (right < size && data[left] < data[right] && data[right] > data[index]) change = right;
        else if (right < size && data[right] < data[left] && data[left] > data[index]) change = left;
        else if (left < size && data[left] > data[index]) change = left;
        if (change != -1) {
            int cur = data[change];
            data[change] = data[index];
            data[index] = cur;
            adjust(change);
        }
    }

    public int[] getData() {
        return data;
    }

    public int getSize() {
        return size;
    }
}
