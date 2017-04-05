public static void main(String args[])
   {
      int n, c, fact = 1; 	// while,structure
 
      System.out.println("Enter an integer to calculate it's factorial");
      Scanner in = new Scanner(System.in); 	// variables,list
 
      n = in.nextInt(); 	// variables
 
      if ( n < 0 )
         System.out.println("Number should be non-negative.");
      else
      {
         for ( c = 1 ; c <= n ; c++ ) 	// double,arguments
            fact = fact*c;
 
         System.out.println("Factorial of "+n+" is = "+fact); 	// string,array,double,loop,parameter,while
      }
   }
