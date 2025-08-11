import java.util.Scanner;
public class MergeSort {
public static void mergeSort(int[] nums, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            mergeSort(nums,low,mid);
            mergeSort(nums,mid+1,high);
            merge(nums,low,mid,high);
        }
    }
    public static void merge(int[] nums, int low, int mid, int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(int i = 0; i<n1;i++){
            left[i] = nums[low+i];
        }
        for(int i = 0; i<n2;i++){
            right[i] = nums[mid+1+i];
        }
        int i = 0, j = 0;
        int k = low;
        while(i<n1 && j<n2){
            if(left[i] <= right[j]){
                nums[k] = left[i];
                i++;
            }
            else{
                nums[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            nums[k] = left[i];
            i++;
            k++;
        }
        while(j<n2){
            nums[k] = right[j];
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
        mergeSort(nums,0,nums.length-1);
        System.out.println("Sorted Array");
        for(int i =0; i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
