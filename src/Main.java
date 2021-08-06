
public class Main 
{

	public static void main(String[] args) 
	{
		int[] array = { 99, 12, 1, 10, 50, 5, 15, 45 , 1, 3, 55};
		mergeSort(array);
		
		for(int i : array)
		{
			System.out.print(i + " ");
		}
	}

	//helper function
	public static void mergeSort(int[] array) 
	{
		if(array == null) {return;}
		mergeSort(array, array.length);
	}

	public static void mergeSort(int[] arr, int len) 
	{
		// base case
		if (len < 2) {return;}

		// split array into two
		int mid = len / 2;
		int[] left = new int[mid];
		int[] right = new int[len - mid];
		
		//copy over elements from source
		System.arraycopy(arr, 0, left, 0, mid);
		System.arraycopy(arr, mid, right, 0, len-mid);

		// recursively sort left and right
		mergeSort(left, mid);
		mergeSort(right, len - mid);

		// call the merge on subdivisions
		merge(left, right, arr);
	}

	public static void merge(int[] left, int[] right, int[] arr) 
	{
		int left_size = left.length;
		int right_size = right.length;
		int i = 0, l = 0, r = 0;
		
		// The while loops check the conditions for merging
		while (l < left_size && r < right_size) 
		{
			if (left[l] < right[r]) 
			{
				arr[i++] = left[l++];
			} 
			else 
			{
				arr[i++] = right[r++];
			}
		}
		while (l < left_size) 
		{
			arr[i++] = left[l++];
		}
		while (r < right_size) 
		{
			arr[i++] = right[r++];
		}
	}

}
