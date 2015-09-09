import utilities.ElementCount;

/**
 * Given an array of of size n and a number k, find all elements that appear more than n/k times.
 * @author sahil
 *
 */
public class MooreVotingAlgorithm {

	public static void main(String[] args) {
		int[] arr={3, 1, 2, 2, 2, 1, 4, 3, 3};
		int n=arr.length;
		int k=3;
		ElementCount[] temp=new ElementCount[k-1];
		int index;
		boolean noSpaceLeft = true;
		
		for (int i = 0; i < arr.length; i++) {
			if(isInTemp(temp,arr[i])!=-1){
				//if it's present increment the count of that element by 1
				index=isInTemp(temp, arr[i]);
				temp[index].setCount(temp[index].getCount()+1);
				
			}
			else{
				//Check if there's space left in the array, else decrease count of 
				//every elt by one
				for (int j = 0; j < temp.length; j++) {
					if(temp[j]==null||temp[j].getCount()==0){
						noSpaceLeft=false;
					}
				}
				
				if(noSpaceLeft){
					for (int j = 0; j < temp.length; j++) {
						temp[j].setCount(temp[j].getCount()-1);
					}					
				}
				else {
					for (int j = 0; j < temp.length; j++) {
						if(temp[j]==null||temp[j].getCount()==0){
							temp[j]=new ElementCount();
							temp[j].setElement(arr[i]);
							temp[j].setCount(1);
						}
					}
				}
			}
		}
		
		int count;
		for (int i = 0; i < temp.length; i++) {
			count=0;
			for (int j = 0; j < arr.length; j++) {
				if(temp[i].getElement()==arr[j]){
					count++;
				}
			}
			if(count>n/k){
				System.out.println(temp[i]);
			}
		}
	}

	/**
	 * Returns index of element if present else will return -1
	 * @param temp
	 * @param i
	 * @return
	 */
	private static int isInTemp(ElementCount[] temp, int x) {
		for (int j = 0; j < temp.length; j++) {
			if(temp[j]!=null&& x==temp[j].getElement()){
				return j;
			}
		}
		return -1;
	}

}
