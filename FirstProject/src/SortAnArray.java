import java.util.Arrays;


public class SortAnArray {
	public static void main(String[] args) {
		 int[] A1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
	     int[] A2 = {2, 1, 8, 3};
	     int[] temp={2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
	     Arrays.sort(temp);
	     printArray(A1);
	     System.out.println("After..");
	     sortArray(A1,A2,temp);
	     printArray(A1);
	}

	private static void printArray(int[] a1) {
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i]+" ");
		}
		
	}

	private static void sortArray(int[] a1, int[] a2, int[] temp) {
		int indexOfMainArray=0;
		int numberOfOccurances;
		boolean[] visited=new boolean[a1.length];
		
		for (int i = 0; i < visited.length; i++) {
			visited[i]=false;
		}
		
		for (int i = 0; i < a2.length; i++) {				
			int firstOccurance=findFirstOccurance(temp,a2[i]);
			int lastOccurance=findLastOccurance(temp,a2[i]);
			if(firstOccurance!=-1&&lastOccurance!=-1){
				markVisitedArray(visited,firstOccurance,lastOccurance);
				numberOfOccurances=lastOccurance-firstOccurance+1;
				indexOfMainArray=updateMainArray(a1,numberOfOccurances,indexOfMainArray,a2[i]);
			}
		}
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i]){
				a1[indexOfMainArray]=temp[i];
				indexOfMainArray++;
			}
		}
	}

	private static int updateMainArray(int[] a1, int numberOfOccurances,
			int indexOfMainArray, int x) {
		int count=0;
		while(count<numberOfOccurances){
			a1[indexOfMainArray]=x;
			indexOfMainArray++;
			count++;
		}
		indexOfMainArray--;
		return indexOfMainArray;
	}

	private static void markVisitedArray(boolean[] visited, int firstOccurance,
			int lastOccurance) {
		for (int i = firstOccurance; i <=lastOccurance; i++) {
			visited[i]=true;
		}
	}

	private static int findLastOccurance(int[] temp, int x) {
		int index=-1;
		int left=0, right=temp.length,mid;
		while(left<=right){
			mid=(left+right)/2;
			if(temp[mid]==x){
				index=mid;
				break;
			}
			else if(temp[mid]>x){
				right=mid-1;				
			}
			else{
				left=mid+1;
			}
		}
		//check index
		if(index!=-1){
			while(!(temp[index+1]>temp[index])){
				index++;			
			}
		}
		return index;
	}

	private static int findFirstOccurance(int[] temp, int x) {
		int index=-1;
		int left=0, right=temp.length,mid;
		while(left<=right){
			mid=(left+right)/2;
			if(temp[mid]==x){
				index=mid;
				break;
			}
			else if(temp[mid]>x){
				right=mid-1;				
			}
			else{
				left=mid+1;
			}
		}
		//check index
		if(index!=-1&&index>0){
			while(!(temp[index-1]<temp[index])){
				index--;			
			}
		}
		return index;
	}
}










