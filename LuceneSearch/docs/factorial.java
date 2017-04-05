public static void main(String args[])
   {
      int n, c, fact = 1; 	// integer
 
      System.out.println("Enter an integer to calculate it's factorial"); 	// types
      Scanner in = new Scanner(System.in); 	// types,arguments,integer,while,structure
 
      n = in.nextInt(); 	// types,integer
 
      if ( n < 0 ) 	// types
         System.out.println("Number should be non-negative."); 	// types
      else
      {
         for ( c = 1 ; c <= n ; c++ ) 	// types,loop,function,integer
            fact = fact++; 	// character,string,array,increment,integer
 
         System.out.println("Factorial of "+n+" is = "+fact); 	// types,string,array,loop
      }
   }
