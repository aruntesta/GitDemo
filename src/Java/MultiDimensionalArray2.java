package Java;

import java.util.Arrays;

public class MultiDimensionalArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int abc[][]= {{4,2,7},{1,5,8},{3,6,9}};
int min = abc[0][0];
Arrays.sort(abc);

		for (int i=0; i<=3; i++) {
			for (int j=0; j<3; j++) {
				if (abc[i][j]<min) {
				min=abc[i][j];
				}
			} 
		}
	}

}
