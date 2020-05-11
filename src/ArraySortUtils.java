/**
 * Class description.
 *
 * @author liuzixiang
 */
public class ArraySortUtils {

    /**
     * 直接插入排序。
     *
     * @param array 待排序的数组
     * @param desc  是否降序
     * @return 排序后的数组
     */
    public static int[] insertSort(int[] array, boolean desc) {
        int len = array.length;
        int insertNumber;
        for (int i = 1; i < len; i++) {
            int j = i - 1;
            insertNumber = array[i];
            while (j >= 0 && (desc ? array[j] < insertNumber : array[j] > insertNumber)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = insertNumber;
        }
        return array;
    }

    /**
     * 希尔排序。
     *
     * @param array 待排序的数组
     * @param desc  是否降序
     * @return 排序后的数组
     */
    public static int[] sheelSort(int[] array, boolean desc) {
        int len = array.length;
        while (len != 0) {
            len = len / 2;
            for (int i = 0; i < len; i++) {
                for (int j = i + len; j < array.length; j += len) {
                    int k = j - len;
                    int insertNumber = array[j];
                    while (k >= 0 && (desc ? array[k] < insertNumber : array[k] > insertNumber)) {
                        array[k + len] = array[k];
                        k -= len;
                    }
                    array[k + len] = insertNumber;
                }
            }
        }
        return array;
    }

    /**
     * 冒泡排序。
     *
     * @param array 待排序的数组
     * @param desc  是否降序
     * @return 排序后的数组
     */
    public static int[] bubbleSort(int[] array, boolean desc) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (desc ? array[j] < array[j + 1] : array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    /**
     * 交换排序。
     *
     * @param array 待排序的数组
     * @param desc  是否降序
     * @return 排序后的数组
     */
    public static int[] swapSort(int[] array, boolean desc) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (desc ? array[i] < array[j] : array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
        return array;
    }

    /**
     * 简单选择排序。
     *
     * @param array 待排序的数组
     * @param desc  是否降序
     * @return 排序后的数组
     */
    public static int[] selectSort(int[] array, boolean desc) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int temp = i;
            for (int j = i + 1; j < len; j++) {
                if (desc ? array[i] < array[j] : array[i] > array[j]) {
                    temp = j;
                }
            }
            if (i != temp) {
                swap(array, i, temp);
            }
        }
        return array;
    }

    /**
     * 堆排序。
     *
     * @param array 待排序的数组
     * @param desc  是否降序
     * @return 排序后的数组
     */
    public static int[] heapSort(int[] array, boolean desc) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            heapAdjust(array, len - 1 - i, desc);
            swap(array, 0, len - 1 - i);
        }
        return array;
    }

    /**
     * 快速排序。
     *
     * @param array 待排序的数组
     * @param desc  是否降序
     * @return 排序后的数组
     */
    public static int[] quickSort(int[] array, boolean desc) {
        return quickSort(array, 0, array.length - 1, desc);
    }

    private static int[] quickSort(int[] array, int start, int end, boolean desc) {
        if (start < end) {
            int i = start,
                j = end,
                base = array[start];
            do {
                while( i < end && (desc ? array[i] > base : array[i] < base)) {
                    i++;
                }
                while( j > start && (desc ? array[j] < base : array[j] > base)) {
                    j--;
                }
                if (i <= j) {
                    swap(array, i, j);
                    i ++;
                    j --;
                }

            } while (i <= j);
            if(start < j) {
                quickSort(array, start, j, desc);
            }
            if (i < end) {
                quickSort(array, i, end, desc);
            }
        }
        return array;
    }

    /**
     * 构建大根堆/小根堆
     *
     * @param array 待排序的数组
     * @param lastIndex 待建堆得数组的LastIndex
     * @param desc 是否小根堆
     */
    private static void heapAdjust(int[] array, int lastIndex, boolean desc) {
        int root = (lastIndex - 1) / 2;
        for (int i = root; i >=0 ; i--) {
            int k = i;
            while ((2 * k + 1) <= lastIndex) {
                int index = 2 * k + 1;
                if (index + 1 <= lastIndex
                        && (desc ? array[index] > array[index + 1] : array[index] < array[index + 1])) {
                    index ++;
                }
                if (desc ? array[k] > array[index] : array[k] < array[index]) {
                    swap(array, k, index);
                    k = index;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 数组元素位置交换。
     *
     * @param array 数组
     * @param m 交换位置1
     * @param n 交换位置2
     */
    private static void swap(int[] array, int m, int n) {
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }
}
