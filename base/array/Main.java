package array;

import java.util.Arrays;

/**
 * @author xstoop
 */
public class Main {
    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;

        // 使用for循环遍历数组
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        // 使用for each遍历数组;无法获取到数组索引
        for (int item : a) {
            System.out.println(item);
        }

        // 使用Arrays.toString()直接打印数组
        System.out.println(Arrays.toString(a));

        int[] b = {12, 33, 44, 21, 2, 57, 98, 1, 65, 8, 41};
        System.out.println(Arrays.toString(b));

        // 冒泡排序
        for (int i = 0; i < b.length; i++) {
            for (int j = i; j < b.length; j++) {
                if (b[i] < b[j]) {
                    int temp = b[j];
                    b[j] = b[i];
                    b[i] = temp;
                }
            }
            System.out.println(Arrays.toString(b));
        }
        System.out.println(Arrays.toString(b));

        int[][] c = new int[3][];
        c[0] = new int[]{3, 2, 1};
        c[1] = new int[]{4, 5, 6};
        c[2] = new int[]{7, 8, 9};

        // 升序
        Arrays.sort(c[0]);
        System.out.println(Arrays.toString(c[0]));

        // 降序为啥Arrays不提供呢？？？ 使用MyComparator需要Integer包装类型对象
        // Arrays.sort(c[1], new MyComparator());
    }
}

