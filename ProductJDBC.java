package com.java.regex.javaReGex;
import java.util.*;

public class ProductJDBC {

	public static void main(String[] args) {
		ProductDAO pdDAO=new ProductDAO();
		HashMap<Product,Integer> pdInfo = pdDAO.getProductInfo();
		Set s=pdInfo.keySet();
		Iterator itr=s.iterator();
			
		// Displaying all products information
		System.out.println("☆☆ Product Details ☆☆");
		while(itr.hasNext()) {
			Product product=(Product)itr.next();
			System.out.printf("%2d %-20s %d%n",product.getPid(),product.getPname(),product.getPprice());
			
		}
		System.out.println();
		//Searching for a specific product
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Product name");
		String name=sc.nextLine();
		
		int price=pdDAO.bill(name);
		if(price==0)
			System.out.println("Product not available..Thank you..");
		else
			System.out.println("Amount is Rs "+price+"\n"+"Thank you.. for the shopping..");
		
	    sc.close();
		
	}

}
