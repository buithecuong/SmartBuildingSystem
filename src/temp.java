import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/temp")
public class temp extends HttpServlet{
	
	public int doMethod(HttpServletRequest request, HttpServletResponse response)
	{
		
		int randomtemp=0;
		Random random = new Random();


		int desiredtemp=Integer.parseInt(request.getParameter("desiredtemp"));
		 
		System.out.println(desiredtemp);
		for(int i =0; i<31556952; i++){
		     randomtemp = random.nextInt(50);
		     
		  
//		     PrintStream out;
//			try {
//				
//				out = new PrintStream(new FileOutputStream("outputtest.txt"));
//				System.setOut(out);
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		    
		     
		     try {
				Thread.sleep(5000);
				 
			      	
			     
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		     
//		     try (PrintWriter out = new PrintWriter("D:/filename.txt")) {
//		    	    out.println(randomtemp);
//		    	    out.close();
//		    	} catch (FileNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//		     
		     
		     
		     
		     File file = new File("D:/filename.txt");
		     FileWriter fr;
		     String strarray[]=new String[1000];
			try {
				fr = new FileWriter(file, true);
				 BufferedWriter br = new BufferedWriter(fr);
			     PrintWriter pr = new PrintWriter(br);
			     pr.println(randomtemp);
			     
			     br.close();
			     pr.close();
			    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			
			
			
			
			// scanning values from file
		    Scanner sc;
			try {
				sc = new Scanner(file);
				System.out.println("=====Historical data======");
				while (sc.hasNextLine()) 
				System.out.println(sc.nextLine()); 
		       
			System.out.println("=========================");	
//				strarray[i]=sc.nextLine();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  
		 
		     
		         
		    
		     System.out.println("Current reading from sensor " + randomtemp);
		     
		    
		     
		     
		     
		     if(randomtemp==desiredtemp){
		    	 System.out.println("Desired Temperature");
		    
		     }
		     else
		     {
		    	 randomtemp=desiredtemp;
		    	 System.out.println("Updated temp to : " + randomtemp);
		    	 
		     }
		     
		}
		
		return randomtemp;
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		doMethod(request, response);

	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		doMethod(request, response);
	}
	
	
}
