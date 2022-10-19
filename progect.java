package GBtask.Java.HeapSort;
/**
 * Aлгоритм пирамидальной сортировки (HeapSort)
 */
public class progect {
    public void sort(int arr[]) {
    
        int lenghtArray = arr.length;

        // Выстраиваем массив в виде сортирующего дерева (двоичной кучи)
        for (int i = lenghtArray / 2 - 1; i >= 0; i--)
            heapify(arr, lenghtArray, i);

        // Один за другим извлекаем элементы из кучи   
        for (int i = lenghtArray-1; i>=0; i--)
        {
            // Меняем корень (максимальный элемент) с последним элементом кучи
            swap(arr, 0, i);

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    void swap(int arr[], int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    // Процедура для преобразования в двоичную кучу от родительского узла i вниз до листьев
     void heapify(int arr[], int n, int i) {
    
        int indexLargestValue = i; // считаем родительский элемент как наибольший
        int leftChildIndex = 2*i + 1; // левый дочерний = 2*i + 1
        int rightChildIndex = 2*i + 2; // правый дочерний = 2*i + 2

           // Проверка наличия левого дочернго элемента и сравнение с родительским элементом
        if (leftChildIndex < n && arr[leftChildIndex] > arr[indexLargestValue])
        indexLargestValue = leftChildIndex;

          // Проверка наличия правого дочернго элемента и сравнение с родительским элементом
        if (rightChildIndex < n && arr[rightChildIndex] > arr[indexLargestValue])
        indexLargestValue = rightChildIndex;
       // Если самый большой элемент не родительский элемент
        if (indexLargestValue != i)
        {
            swap(arr, i, indexLargestValue);
            // printArray(arr);
            heapify(arr, n, indexLargestValue);  // Рекурсивно преобразуем затронутое поддерево в двоичную кучу
        }
    }

    static void printArray(int arr[]) {
    
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[]) {
    
        int arr[] = {12, 16, 13, 17, 22, 19};
        printArray(arr);
        progect object = new progect();
        object.sort(arr);
        System.out.println("Sorted array: ");
        printArray(arr);
    }
}
