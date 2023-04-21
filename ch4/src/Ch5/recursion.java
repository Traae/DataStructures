package Ch5;

public class recursion {
    public static int binarySearch(int[] data, int target, int low, int high) {
        if (low > high) { return -1;}
        else {
            int mid = (low + high) /2;
            if (target == data[mid]) {return mid;}
            else if (target<data[mid]){ return binarySearch(data,target,low,mid-1); }
            else { return binarySearch(data,target,mid+1,high);}
        }
    }
    public static int binarySearch(int[] data, int target) {
        return binarySearch(data, target, 0, data.length-1);
    }
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7,8,9,13,24,25,56,78};
        System.out.println(binarySearch(num, 24));
    }


}
