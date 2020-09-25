import java.util.ArrayList;
import java.util.List;

public class Klists2 {
	public double [] mergeKLists (double [][] outerarray) {

		if (outerarray.length == 0 || outerarray[0].length == 0) { // check for empty arrays
			double array[] = {};
			return array;
		}

		int i = 0, j = 0, k = 0;
		int total = 0;

		total = outerarray[0].length + outerarray[1].length;

		double [] myArray = new double [total];

		int length_1 = outerarray[0].length;
		int length_2 = outerarray[1].length;

		while (i < length_1 && j < length_2) {
			if(outerarray[0][i] <= outerarray[1][j]) {
				myArray[k++] = outerarray[0][i++];
			}
			else {
				myArray[k++] = outerarray[1][j++];
			}
		}
		while (i < length_1) {
			myArray[k++] = outerarray[0][i++];
		}
		while (j< length_2) {
			myArray[k++] = outerarray[1][j++];
		}

		int outerarray_index = outerarray.length;
		int x = 2;

		while (x < outerarray_index) {
			myArray = merge(myArray, outerarray, x);
			x++;
		}

		return myArray;
	}
	public double[] merge (double[] a, double [][] outerarray, int index) {
		int length_1 = a.length;
		int length_2 = outerarray[index].length;
		int i = 0, j = 0, k = 0;

		int total = outerarray[index].length + a.length;

		double [] arr = new double[total];

		while (i < length_1 && j < length_2) {
			if(a[i] <= outerarray[index][j]) {
				arr[k++] = a[i++];
			}
			else {
				arr[k++] = outerarray[index][j++];
			}
		}
		while (i < length_1) {
			arr[k++] = a[i++];
		}
		while (j< length_2) {
			arr[k++] = outerarray[index][j++];
		}
		return arr;
	}

	public static void main(String[] args) {
		double[][] a = {
			{1.1, 4.4, 5.5}, 
			{1.1, 3.3, 4.4},
			{2.2, 6.6},
		};
		Klists2 s = new Klists2();

		double [] finalArray = s.mergeKLists(a);

		if (finalArray.length == 0){
			System.out.println("[]");
		}		
		for(int t =0; t < finalArray.length; t++) {
			System.out.print(finalArray[t] + " ");
		}
		System.out.println();

	}
}