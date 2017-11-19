// This code is written for 1D array O(logn)
public class FindPeak {
	
	public int peak(int[] arr, int i, int j, int n){
		if(i == j ) return arr[i];
		else {
			int middle  = (i+j)/2;
			if(middle == 0 && arr[0] >= arr[1]) return arr[0];
			if(middle == n && arr[n] >= arr[n-1]) return arr[n];
			if(arr[middle-1] <= arr[middle] && arr[middle]>= arr[middle+1]){
				return arr[middle];
			} else if(arr[middle-1] > arr[middle]) {
				return peak(arr, i, middle, n);
			} else {
				return peak(arr, middle+1, j, n);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPeak f = new FindPeak();
		int[] arr = {1, 3, 20, 4, 1, 0};
		//int[] arr = {5, 4, 3, 2, 1, 0};
		//int[] arr = {1, 2, 3, 4};
		int n = arr.length-1;
		System.out.println(f.peak(arr, 0, n, n));
	}

}
