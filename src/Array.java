import javax.swing.plaf.IconUIResource;

public class Array{
    private int[] nums;
    private int size;

    public Array(int capcity){
        nums = new int[capcity];
        size = 0;
    }

    public void insertAtStart(int value){
        ensureCapacity();
        for(int i = size; i>0; i--){
            nums[i] = nums[i-1];
        }
        nums[0] = value;
        size++;
    }

    public void insertAtEnd(int value){
        ensureCapacity();
        nums[size] = value;
        size++;
    }

    public void print(){
        for(int i = 0; i<size;i++){
            System.out.print(nums[i]+" ");
        }
    }

    public void insertAtIndex(int value, int index){
        ensureCapacity();
        if(index < 0 || index > size){
            System.out.println("Insertion at the index "+index+" is not possible");
        }
        else{
            for(int i=size; i>index;i--){
                nums[i] = nums[i-1];
            }
            nums[index] = value;
            size++;
        }
    }

    public void deleteAtStart(){
        if(size == 0){
            System.out.println("Array is empty");
        }
        for(int i=0; i<size-1;i++){
            nums[i] = nums[i+1];
        }
        size--;
    }

    public void deleteAtEnd(){
        if(size==0){
            System.out.println("Array is empty");
        }
        size--;
    }

    public void deleteAtIndex(int index){
        if(index<0 || index>size){
            System.out.println("Deletion not possible");
        }
        for(int i = index; i<size-1;i++){
            nums[i] = nums[i+1];
        }
        size--;
    }

    public void deleteValue(int value){
        int index = -1;
        for(int i=0; i<size;i++){
            if(nums[i]==value){
                index = i;
                break;
            }
        }
        if(index != -1){
            for(int i = index; i<size-1;i++){
                nums[i] = nums[i+1];
            }
            size--;
        }
        else{
            System.out.println(value+" not found in array");
        }
    }

    public void ensureCapacity(){
        if(size == nums.length){
            int [] newNums = new int[nums.length*2];
            for(int i = 0;  i< nums.length;i++){
                newNums[i] = nums[i];
            }
            nums = newNums;
        }
    }



    public static void main(String[] args){
        Array arr = new Array(3);
        arr.insertAtStart(1);
        arr.insertAtEnd(2);
        arr.insertAtIndex(10,2);
        arr.insertAtIndex(11,3);
        arr.insertAtIndex(12,4);
        arr.insertAtIndex(13,0);
        arr.deleteAtStart();
        arr.deleteAtIndex(0);
        arr.deleteAtIndex(3);
        arr.deleteValue(2);
        arr.deleteValue(10);
        arr.print();
    }
}