package leetcode.editor.cn;

/**
 * @description:
 * @author: miao
 * @create: 2021-03-26
 **/

public abstract class Heap {
    protected int[] data;
    protected int MAX_SIZE;
    protected int DEFAULT_SIZE = 32;
    protected int size = 0;

    public Heap(int size) {
        this.data = new int[size];
        this.MAX_SIZE = size;
    }

    public Heap() {
        this.MAX_SIZE = DEFAULT_SIZE;
        this.data = new int[MAX_SIZE];
    }

    /**
     * 添加元素
     * */
    public abstract void add(int index);

    /**
     * 取代堆顶的元素
     */
    public abstract void replace(int replaceNum);

    public abstract int getTop();
}
