package BinSearch;
//找局部最小值的索引
public class getLessIndex {
    public int getLessIndex1(int[] arr) {
        if (arr == null || arr.length == 0){
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]){
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]){
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        while (left < right){
            int mid = left + (right - left)/2;  //mid是变化的,所以要放进循环里面.
            //必须是先从mid>mid-1开始.因为最后要的是left,这样子是最快的,往左缩.
            if (arr[mid] > arr[mid-1]){     //mid左侧是一个值往下走的过程,最左侧边缘是上升的,所以必有局部最小值.
                right = mid - 1;
            }else if (arr[mid] > arr[mid+1]){
                left = mid + 1;
            }else {
                return mid;  //因为题意说相邻两数不相等,所以可以不考虑相当的情况.
            }
        }
        return left;
    }
}