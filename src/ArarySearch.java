import java.util.Scanner;

public class ArarySearch {

    //Linear Search
    public static int linearSearch(int[] nums, int target){
        for(int i =0; i< nums.length;i++){
            if(target == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    //Binary Search
    public static int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]< target){
                left = right+1;
            }
            else{
                right = mid -1;
            }
        }
        return -1;
    }

    //Binary Search Reccursive call
    public static int binarySearchReccurive(int[] nums, int target, int left, int right){
        if(left<right){
            int mid = (left + right)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid] < target){
                return binarySearchReccurive(nums,target,mid+1,right);
            }
            else{
                return binarySearchReccurive(nums, target, left, mid-1);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the elements in the array");
        for(int i =0; i<size; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter the number that you want to search");
        int target = sc.nextInt();
        int result = binarySearchReccurive(nums,target,0,nums.length);
        if(result == -1){
            System.out.println("Not found");
        }
        else{
            System.out.println("Element found at "+result+" index of array");
        }
    }
}
