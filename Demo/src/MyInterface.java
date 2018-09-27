

public interface MyInterface {
	 void display();  
	 default void newMethod(){  
	        System.out.println("Newly added default method");  
	    } 
}
