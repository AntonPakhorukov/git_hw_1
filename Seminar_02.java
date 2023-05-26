package Algoritmy_Semiar_01;
import java.util.Random;

public class Seminar_02 {
    public static void main(String[] args) {
        int[] array = FillArray(10, 0, 10);

        for (int i : array) {
            System.out.print(i);
        }
        System.out.println();
        QuickSort(array, 0, array.length - 1);
        System.out.println();
        //array = InsertSort(array);
        for (int i : array) {
            System.out.print(i);
        }
        // System.out.println();
        // System.out.println("Index: " + BinSearch2(array, 8));
        // System.out.println();
        // array = BubbleSort(array);
        // for (int i : array) {
        //     System.out.print(i);
        // }
    }

    public static int[] BubbleSort(int[] array) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return array;
    }

    public static int[] FillArray(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(min, max);
        }
        return array;
    }

    public static int[] InsertSort (int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }

// public static int[] PreQuickSort(int[] array, int leftBorder, int rightBorder) {
//     int pivot = array[3];
//     return QuickSort(array, leftBorder, rightBorder, pivot);
// }

    public static void QuickSort(int[] array, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder; 
        int pivot = array[(leftMarker + rightMarker) / 2];
        do {
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            while (array[rightMarker] > pivot) {
                rightMarker--;
            }
            if(leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int temp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = temp;
                }
                leftMarker++;
                rightMarker--;
            }
        } 
        while (leftMarker <= rightMarker); 
            if (leftMarker < rightBorder) {
                QuickSort(array, leftMarker, rightBorder);
            }
            if (leftBorder < rightMarker) {
                QuickSort(array, leftBorder, rightMarker);
            }
        
    }

    public static int BinSearch(int[] array, int key) {
        int left = 0, right = array.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            } else if (array[mid] < key) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        
        return -1;
    }

    public static int BinSearch2(int[] array, int key) {
        int left = 0, right = array.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid;
            } else if (array[mid] < key) {
                left = mid;
            } else {
                return mid;
            }
            if (right - left == 1) {
                if (Math.abs(array[left] - key) < Math.abs(array[right] - key)) {
                    if (array[left] != key)
                        System.out.print("Найдено ближайшее число: ");
                    return left;
                } 
                    if (array[right] != key) {
                        System.out.print("Найдено ближайшее число: ");
                    return right;
                }
            }
        }
        return -1;
    }
}

