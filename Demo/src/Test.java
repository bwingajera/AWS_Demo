import java.util.ArrayList;
import java.util.List;

public  class Test implements MyInterface ,B {
	public static void main(String [] args){
		int x = 11;
		int y = x>10?1:x<10?-1:0;
		Test test=new Test();
		// Method reference using the object of the class
		MyInterface ref = test::intva;  
		// Calling the method of functional interface  
		ref.display();  
	}
	public  void intva() {
		System.out.println("");;
	}
	
	@Override
	public void newMethod() {
		// TODO Auto-generated method stub
		B.super.newMethod();
	}


	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}
