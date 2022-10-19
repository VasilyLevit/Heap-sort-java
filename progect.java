package GBtask.Java.HeapSort;
/**
 * Aлгоритм пирамидальной сортировки (HeapSort)
 */
public class progect {
    public void sort(int arr[])
    {
        int lenghtArray = arr.length;

        // Выстариваем массив в виде сортирующего дерева (двоичной кучи)
        for (int i = lenghtArray / 2 - 1; i >= 0; i--)
            heapify(arr, lenghtArray, i);

        // Один за другим извлекаем элементы из кучи   
        for (int i=lenghtArray-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    
    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
    // индексом в arr[]. n - размер кучи
     void heapify(int arr[], int n, int i)
    {
        int max = i; // Инициализируем наибольший элемент как корень
        int leftChild = 2*i + 1; // левый = 2*i + 1
        int rightChild = 2*i + 2; // правый = 2*i + 2

           // Проверка наличия левого дочернго элемента и сравнение с родительским элементом
        if (leftChild < n && arr[leftChild] > arr[max])
            max = leftChild;

          // Проверка наличия правого дочернго элемента и сравнение с родительским элементом
        if (rightChild < n && arr[rightChild] > arr[max])
            max = rightChild;
       // Если самый большой элемент не корень
        if (max != i)
        {
            int swap = arr[i];
            arr[i] = arr[max];
            arr[max] = swap;

          // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, max);
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 9};
        
        progect object = new progect();
        object.sort(arr);
                
        System.out.println("Sorted array is");
        printArray(arr);
    }
}
