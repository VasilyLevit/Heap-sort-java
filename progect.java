package GBtask.Java.HeapSort;
/**
 * Aлгоритм пирамидальной сортировки (HeapSort)
 */
public class progect {
    public void sort(int arr[]) {
    
        int lenghtArray = arr.length;

        // Выстариваем массив в виде сортирующего дерева (двоичной кучи)
        for (int i = lenghtArray / 2 - 1; i >= 0; i--)
            heapify(arr, lenghtArray, i);

        // Один за другим извлекаем элементы из кучи   
        for (int i=lenghtArray-1; i>=0; i--)
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

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
    // индексом в arr[]. n - размер кучи
     void heapify(int arr[], int n, int i) {
    
        int indexMaxValue = i; // Инициализируем корень как наибольший элемент
        int leftChildIndex = 2*i + 1; // левый = 2*i + 1
        int rightChildIndex = 2*i + 2; // правый = 2*i + 2

           // Проверка наличия левого дочернго элемента и сравнение с родительским элементом
        if (leftChildIndex < n && arr[leftChildIndex] > arr[indexMaxValue])
        indexMaxValue = leftChildIndex;

          // Проверка наличия правого дочернго элемента и сравнение с родительским элементом
        if (rightChildIndex < n && arr[rightChildIndex] > arr[indexMaxValue])
        indexMaxValue = rightChildIndex;
       // Если самый большой элемент не родительский элемент
        if (indexMaxValue != i)
        {
            swap(arr, i, indexMaxValue);
            
            heapify(arr, n, indexMaxValue);  // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
        }
    }

    static void printArray(int arr[]) {
    
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[]) {
    
        int arr[] = {12, 11, 13, 5, 6, 9};
        
        progect object = new progect();
        object.sort(arr);
                
        System.out.println("Sorted array is");
        printArray(arr);
    }
}
