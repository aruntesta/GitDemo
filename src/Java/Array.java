package Java;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array ar = new Array();
		ar.array2();
		int a[] = new int[3];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		for (int i = 0; i <= a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public void array2() {
		int b[] = { 4, 5, 6 };
		for (int j = 0; j <= b.length; j++) {
			System.out.println(b[j]);
		}
	}

}
