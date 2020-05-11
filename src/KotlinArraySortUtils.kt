/**
 * Class description.
 *
 * @author liuzixiang
 */
object KotlinArraySortUtils {
    /**
     * 直接插入排序。
     *
     * @param array 待排序的数组
     * @param desc  是否降序
     * @return 排序后的数组
     */
    fun insertSort(array: IntArray, desc: Boolean): IntArray {
        val len = array.size
        var insertNumber: Int
        for (i in 1 until len) {
            var j = i - 1
            insertNumber = array[i]
            while (j >= 0 && if (desc) array[j] < insertNumber else array[j] > insertNumber) {
                array[j + 1] = array[j]
                j--
            }
            array[j + 1] = insertNumber
        }
        return array
    }

    /**
     * 希尔排序。
     *
     * @param array 待排序的数组
     * @param desc  是否降序
     * @return 排序后的数组
     */
    fun sheelSort(array: IntArray, desc: Boolean): IntArray {
        var len = array.size
        while (len != 0) {
            len = len / 2
            for (i in 0 until len) {
                var j = i + len
                while (j < array.size) {
                    var k = j - len
                    val insertNumber = array[j]
                    while (k >= 0 && if (desc) array[k] < insertNumber else array[k] > insertNumber) {
                        array[k + len] = array[k]
                        k -= len
                    }
                    array[k + len] = insertNumber
                    j += len
                }
            }
        }
        return array
    }

    /**
     * 冒泡排序。
     *
     * @param array 待排序的数组
     * @param desc  是否降序
     * @return 排序后的数组
     */
    fun bubbleSort(array: IntArray, desc: Boolean): IntArray {
        val len = array.size
        for (i in 0 until len) {
            for (j in 0 until len - 1 - i) {
                if (if (desc) array[j] < array[j + 1] else array[j] > array[j + 1]) {
                    swap(array, j, j + 1)
                }
            }
        }
        return array
    }

    /**
     * 交换排序。
     *
     * @param array 待排序的数组
     * @param desc  是否降序
     * @return 排序后的数组
     */
    fun swapSort(array: IntArray, desc: Boolean): IntArray {
        val len = array.size
        for (i in 0 until len) {
            for (j in i + 1 until len) {
                if (if (desc) array[i] < array[j] else array[i] > array[j]) {
                    swap(array, i, j)
                }
            }
        }
        return array
    }

    /**
     * 简单选择排序。
     *
     * @param array 待排序的数组
     * @param desc  是否降序
     * @return 排序后的数组
     */
    fun selectSort(array: IntArray, desc: Boolean): IntArray {
        val len = array.size
        for (i in 0 until len) {
            var temp = i
            for (j in i + 1 until len) {
                if (if (desc) array[i] < array[j] else array[i] > array[j]) {
                    temp = j
                }
            }
            if (i != temp) {
                swap(array, i, temp)
            }
        }
        return array
    }

    /**
     * 堆排序。
     *
     * @param array 待排序的数组
     * @param desc  是否降序
     * @return 排序后的数组
     */
    fun heapSort(array: IntArray, desc: Boolean): IntArray {
        val len = array.size
        for (i in 0 until len) {
            heapAdjust(array, len - 1 - i, desc)
            swap(array, 0, len - 1 - i)
        }
        return array
    }

    /**
     * 快速排序。
     *
     * @param array 待排序的数组
     * @param desc  是否降序
     * @return 排序后的数组
     */
    fun quickSort(array: IntArray, desc: Boolean): IntArray {
        return quickSort(array, 0, array.size - 1, desc)
    }

    private fun quickSort(array: IntArray, start: Int, end: Int, desc: Boolean): IntArray {
        if (start < end) {
            var i = start
            var j = end
            val base = array[start]
            do {
                while (i < end && if (desc) array[i] > base else array[i] < base) {
                    i++
                }
                while (j > start && if (desc) array[j] < base else array[j] > base) {
                    j--
                }
                if (i <= j) {
                    swap(array, i, j)
                    i++
                    j--
                }
            } while (i <= j)
            if (start < j) {
                quickSort(array, start, j, desc)
            }
            if (i < end) {
                quickSort(array, i, end, desc)
            }
        }
        return array
    }

    /**
     * 构建大根堆/小根堆
     *
     * @param array 待排序的数组
     * @param lastIndex 待建堆得数组的LastIndex
     * @param desc 是否小根堆
     */
    private fun heapAdjust(array: IntArray, lastIndex: Int, desc: Boolean) {
        val root = (lastIndex - 1) / 2
        for (i in root downTo 0) {
            var k = i
            while (2 * k + 1 <= lastIndex) {
                var index = 2 * k + 1
                if (index + 1 <= lastIndex
                        && if (desc) array[index] > array[index + 1] else array[index] < array[index + 1]) {
                    index++
                }
                k = if (if (desc) array[k] > array[index] else array[k] < array[index]) {
                    swap(array, k, index)
                    index
                } else {
                    break
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
    private fun swap(array: IntArray, m: Int, n: Int) {
        val temp = array[m]
        array[m] = array[n]
        array[n] = temp
    }
}
