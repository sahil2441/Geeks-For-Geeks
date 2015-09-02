/**
 * Find k closest elements to a given value
 * Given a sorted array arr[] and a value X, find the k closest elements to X in arr[]. 
 * @author sahil
 */

public class FindKClosestElements {

	public static void main(String[] args) {
		int k = 4, x = 35;
		int arr[] = {12, 16, 22, 30, 35, 39, 42, 
			               45, 48, 50, 53, 55, 56};
		findKClosest(arr,k,x);
	}
	private static void findKClosest(int[] arr, int k, int x) {
		int indexOfX=-1;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==x){
				indexOfX=i;
				break;
			}
		}
		if(indexOfX==-1){
			return;
		}
		else{
			int i=indexOfX-1,j=indexOfX+1,count=0;
			while(i>=0&&j<arr.length&&count<k){
				if(Math.abs(arr[i]-x) < Math.abs(arr[j]-x)){
					System.out.println(arr[i]);
					i--;
					count++;
				}
				else{
					System.out.println(arr[j]);
					j++;
					count++;
				}
			}
			while(i>=0&&count<k){
				System.out.println(arr[i]);
				i--;
				count++;	
			}
			while(j<arr.length&&count<k){
				System.out.println(arr[j]);
				j++;
				count++;
			}
		}
	}
}
