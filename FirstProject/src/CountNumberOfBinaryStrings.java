/**
 * Count number of binary strings without consecutive 1’s
 * @author sahil
 */
public class CountNumberOfBinaryStrings {

	public static void main(String[] args) {
		int n=2;
		int a[]=new int[n];
		int b[]=new int[n];
		
		a[0]=1;b[0]=1;
		int i=1;
		while(i<n){
			a[i]=a[i-1]+b[i-1];
			b[i]=a[i-1];
			i++;
		}
		System.out.println(a[n-1]+b[n-1]);
	}

}
