import java.util.Scanner;

public class QuickSort {

    public static void quickSort(int[] nums, int low, int high){
        if(low < high){
            int pi = partitions(nums,low,high);
            quickSort(nums, low, pi-1);
            quickSort(nums,pi+1,high);
        }
    }

    public static int partitions(int[] nums, int low, int high){
        int piviot = nums[high];
        int i = low -1;
        for(int j = low; j<high;j++){
            if(nums[j] < piviot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i+1];
        nums[i+1] = nums[high];
        nums[high] = temp;
        return i+1;

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
        quickSort(nums,0,nums.length-1);
        System.out.println("Sorted Array");
        for(int i =0; i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
