package Home_work;

import java.util.Random;

public class Home_work_02 {
    public static void main(String[] args) {

        int[] array = CreateArray(10, -20, 20);
        printArray(array);
        System.out.println();
        heapSort(array); 
        printArray(array);       
    }

    public static void printArray (int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static int[] CreateArray (int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(min, max);
        }
        return array;
    }
    
    public static void heapSort (int[] array) {
        int size = array.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxNumberInHeap(array, i, size); // отвечает за построение дерева. Нулевой элемент будет самый максимальный
        }
        for (int j = size - 1; j >= 0; j--) { // делаем саму сортировку 
            int temp = array[j];   
            array[j] = array[0]; // на последний элемент ставим наш максимальный элемент
            array[0] = temp; // а на нулевой элемент ставим тот, который стоял на последнем элементе
            maxNumberInHeap(array, 0, j);
        }
    }

    public static void maxNumberInHeap (int[] array, int i, int size) {
        int left = 2 * i + 1; // устанавливаем левого наследника
        int right = 2 * i + 2; // устанавливаем правого наследника
        int largest = i; // устанавливаем максимальное значение и пока приравниваем к родителю
        if (left < size && array[left] > array[largest]) { // если левый наследник больше максимального значения
            largest = left; // то в максимальное значение записываем значение левого наследника
        }
        if (right < size && array[right] > array[largest]) { // если правый наследник больше максимального значения
            largest = right; // то в максимальное значение записываем значение правого наследника
        }
        if (i != largest) { // если значение родителя не равно максимальному значению, то меняем их местами
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxNumberInHeap(array, largest, size); // и запускаем проверку, чтобы если есть дети детей, то тоже поменялись 
        }
    }
}
