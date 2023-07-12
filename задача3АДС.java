BubbleSort

public static void bubbleSort(int[] sortArr){
    for (int i = 0; i < sortArr.length - 1; i++) {
        for(int j = 0; j < sortArr.length - i - 1; j++) {
            if(sortArr[j + 1] < sortArr[j]) {
                int swap = sortArr[j];
                sortArr[j] = sortArr[j + 1];
                sortArr[j + 1] = swap;
            }
        }
    }
 

public static void main(String args[]) {
    int[] sortArr = {12, 6, 4, 1, 15, 10};
    bubbleSort(sortArr);
    for(int i = 0; i < sortArr.length; i++){
        System.out.print(sortArr[i] + "\n");
    }
}

QuickSort

public static void quickSort(int[] sortArr, int low, int high) {
    if (sortArr.length == 0 || low >= high) return;
    int middle = low + (high - low) / 2;
    int border = sortArr[middle];
    int i = low, j = high;
    while (i <= j) {
        while ( i<=j, quickSort, i,high)
            for (i>=j),Sort Arr, j,low);
        }
        }
    }
    if (low < j) quickSort(sortArr, low, j);
    if (high > i) quickSort(sortArr, i, high);
}

public static void main(String args[]) {
    int[] sortArr = {12, 6, 4, 1, 15, 10};
    quickSort(sortArr, 0, sortArr.length - 1);
    for(int i = 0; i < sortArr.length; i++){
        System.out.print(sortArr[i] + "\n");
    }
}

 MergeSort

import java.util.Arrays;

public class Main {
    public static int[] mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }

    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        //уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        //слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
    public static void main(String args[]) {
        int[] sortArr = {12, 6, 4, 1, 15, 10};
        int[] result = mergeSort(sortArr);
        System.out.println(Arrays.toString(result));
    }
}

HeapSort

//вернуть левого потомка `A[i]`
private static int LEFT(int i) {
    return (2 * i + 1);
}

//вернуть правого потомка `A[i]`
private static int RIGHT(int i) {
    return (2 * i + 2);
}

//вспомогательная функция для замены двух индексов в массиве
private static void swap(int[] sortArr, int i, int j) {
    int swap = sortArr[i];
    sortArr[i] = sortArr[j];
    sortArr[j] = swap;
}

//рекурсивный алгоритм heapify-down. Узел с индексом `i` и 2 его прямых потомка нарушают свойство кучи
private static void heapify(int[] sortArr, int i, int size) {
    // получить левый и правый потомки узла с индексом `i`
    int left = LEFT(i);
    int right = RIGHT(i);
    int largest = i;

    //сравниваем `A[i]` с его левым и правым дочерними элементами и находим наибольшее значение
        if (left < size && sortArr[left] > sortArr[i]) largest = left;
        if (right < size && sortArr[right] > sortArr[largest]) largest = right;

    //поменяться местами с потомком, имеющим большее значение и вызовите heapify-down для дочернего элемента
    if (largest != i) {
        swap(sortArr, i, largest);
        heapify(sortArr, largest, size);
    }
}

//функция для удаления элемента с наивысшим приоритетом (присутствует в корне)
public static int pop(int[] sortArr, int size) {
    //если в куче нет элементов
    if (size <= 0) {
        return -1;
    }
    int top = sortArr[0];

    //заменяем корень кучи последним элементом массива
    sortArr[0] = sortArr[size-1];
    //вызовите heapify-down на корневом узле
    heapify(sortArr, 0, size - 1);
    return top;
}

//функция для выполнения пирамидальной сортировки массива `A` размера `n`
public static void heapSort(int[] sortArr) {
    //строим приоритетную очередь и инициализируем ее заданным массивом
    int n = sortArr.length;

    //build-heap: вызывать heapify, начиная с последнего внутреннего
    //узел до корневого узла
    int i = (n - 2) / 2;
    while (i >= 0) {
        heapify(sortArr, i--, n);
    }

    //несколько раз извлекаем из кучи, пока она не станет пустой
    while (n > 0) {
        sortArr[n - 1] = pop(sortArr, n);
        n--;
    }
}

public static void main(String args[]) {
    int[] sortArr = {12, 6, 4, 1, 15, 10};
    heapSort(sortArr);
    for(int i = 0; i < sortArr.length; i++){
        System.out.print(sortArr[i] + "\n");
    }
}

