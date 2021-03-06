/**
 * @author sahil
 * Rearrange array in alternating positive & negative items with O(1) extra space
 */
public class RearrangeArray {

	public static void main(String[] args) {
		 int[] arr= {1,2,3,-4,1,-3};
		 printArray(arr);
		 rearrangeArray(arr);
		 System.out.println("After rearranging..");
		 printArray(arr);
	}
	private static void rearrangeArray(int[] arr) {
		int indexOfFirstNegativeNumber=-1,indexOfFirstPositiveNumber=-1;
		for (int i = 0; i < arr.length; i++) {
			if(i%2==0&&arr[i]>0){
				indexOfFirstNegativeNumber=findIndexOfNegative(arr,i);
				if(indexOfFirstNegativeNumber!=-1){
					rightShiftArray(arr,i,indexOfFirstNegativeNumber);					
				}
				
			}else if (i%2==1&&arr[i]<0) {
				indexOfFirstPositiveNumber=findIndexOfPositive(arr, i);
				if(indexOfFirstPositiveNumber!=-1){
					rightShiftArray(arr, i, indexOfFirstPositiveNumber);					
				}
			}
		}
		
	}
	private static int findIndexOfPositive(int[] arr, int i) {
		int index=-1;
		i++;
		while(i<arr.length){
			if(arr[i]>0){
				index=i;
				break;
			}
			i++;
		}
		return index;
	}
	
	private static void rightShiftArray(int[] arr, int firstIndex,
			int lastIndex) {
		int temp=arr[lastIndex];
		for (int i = lastIndex; i > firstIndex; i--) {
			arr[i]=arr[i-1];
		}
		arr[firstIndex]=temp;
	}
	
	private static int findIndexOfNegative(int[] arr, int i) {
		int index=-1;
		i++;
		while(i<arr.length){
			if(arr[i]<0){
				index=i;
				break;
			}
			i++;
		}
		return index;
	}
	
	private static void printArray(int[] a1) {
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i]+" ");
		}
	}

}
