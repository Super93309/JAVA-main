import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Sorting {
    // Bubble Sort
    public static int[] bubbleSort(int[] nums){
        int temp;
        for(int i=0; i<nums.length;i++){
            for(int j=0; j<nums.length-i-1;j++){
                if(nums[j] > nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
    // Selection Sort
    public static int[] selectionSort(int[] nums){
        int minIndex;
        int temp;
        for(int i=0; i<nums.length-1;i++){
            minIndex = i;
            for(int j = i+1; j<nums.length; j++){
                if(nums[minIndex] > nums[j]){
                    minIndex = j;
                }
            }
            temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
    // Insertion Sort
    public static int[] insertionSort(int[] nums){
        int value;
        int j;
        for(int i=1; i<nums.length;i++){
            value = nums[i];
            j = i;
            while(j>0 && nums[j-1]>value){
                nums[j] = nums[j-1];
                j = j-1;
            }
            nums[j] = value;
        }
        return nums;
    }

    // Quick Sort
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the elements of the array");
        for(int i =0; i<size;i++){
            nums[i] = sc.nextInt();
        }
        int[] sortedArray = insertionSort(nums);
        System.out.println("Sorted Array");
        for(int i =0; i<sortedArray.length;i++){
            System.out.print(sortedArray[i]+" ");
        }
    }
}
