package Java;

public class MyClass {
	private int value;

	// Default constructor
	public MyClass() {
		value = 0;
	}

	// Constructor with one parameter
	public MyClass(int value) {
		this.value = value;
	}

	// Constructor with two parameters
	public MyClass(int value1, int value2) {
		this.value = value1 + value2;
	}

	// Getter method
	public int getValue() {
		return value;
	}

	// Main method to test the constructors
	public static void main(String[] args) {
		// Creating objects using different constructors
		MyClass obj1 = new MyClass();
		MyClass obj2 = new MyClass(5);
		MyClass obj3 = new MyClass(10, 20);

		// Printing the values
		System.out.println("Value of obj1: " + obj1.getValue()); // Output: 0
		System.out.println("Value of obj2: " + obj2.getValue()); // Output: 5
		System.out.println("Value of obj3: " + obj3.getValue()); // Output: 30
	}

}
