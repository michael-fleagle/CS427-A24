// Authors: Hunter Pohl, Jacob Fisher, Michael Fleagle
// CS 427 A24
// Date: November 14, 2022

// import necessary libraries
import java.util.*;
import java.lang.Math;



// Main Class
public class Main
{
    public static ArrayList<Integer> denom() {
	    Scanner input = new Scanner(System.in);
        System.out.print("Enter the denomiations as a list seperated by spaces (ex: 10 25 1 5): ");
        String denomiations = input.nextLine();
		
		String[] denomStrList = denomiations.split(" ");
		
        ArrayList<Integer> denomIntList = new ArrayList<Integer>();
        
        for (int i = 0; i < denomStrList.length; i++) {
            denomIntList.add(Integer.valueOf(denomStrList[i]));
        }
		
		Collections.sort(denomIntList, Collections.reverseOrder());
		return denomIntList;
	}
	
	public static int change() {
	    Scanner input = new Scanner(System.in);
		System.out.print("Enter the amount of change needed (ex: 58): ");
        String changeStr = input.nextLine();
		int changeInt = Integer.valueOf(changeStr);
		return changeInt;
	}
    
    public static int coinMod(int d, int c){
        int coinAmount = 0;
        coinAmount = Math.floorDiv(c, d);
        //System.out.println("d: " + d + " c: " + c);
        return coinAmount;
    }
    
    public static int remainder(int d, int c){
        int changeLeft = 0;
        changeLeft = c % d;
        //System.out.println("d: " + d + " c: " + c);
        return changeLeft;
    }
    
    
    static class IntegerCompare implements Comparator<Integer>{
    // Overriding compare() method of Comparator
                // for descending order of ints
        public int compare(Integer i1, Integer i2) {
            if (i1 < i2)
                return 1;
            else if (i1 > i2)
                return -1;
            return 0;
        }
    }
    
   // Main/driver method
	public static void main(String[] args) {
		
        
		ArrayList<Integer> denomIntList = denom();
		System.out.println("The possible coins to hand back (coin denomination): " + denomIntList);
		
		int changeInt = change();
		System.out.println("Change back needed: " + changeInt);
		
		
		System.out.println();
		
		// if the amount of change needed is less than the smallest coin - then it's not possible
		if (changeInt < denomIntList.get(denomIntList.size() - 1)) {
		    System.out.println("Not possible");
		    return;
		}
		
		
		
		// Creating empty priority queue with Comparator
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(denomIntList.size(), new IntegerCompare());
        
        for (int i = 0; i < denomIntList.size(); i++) {
            pQueue.add(denomIntList.get(i));
        }
        
        


		
		int[] amountList = new int[denomIntList.size()];
		int amountLeft = changeInt;
		Integer val = null;
		int amountEle = 0;
        while( (val = pQueue.peek()) != null) {
            int x = coinMod(pQueue.peek(), amountLeft);
    		//System.out.println("x = " + x);
    		
    		int y = remainder(pQueue.peek(), amountLeft);
    		//System.out.println("y = " + y);
    		
    		amountList[amountEle++] = x;
    		amountLeft = y;
            pQueue.poll();
        }


        System.out.println("Amount of each coin to give:");
        

	    HashMap<Integer, Integer> changeBack = new HashMap<Integer, Integer>();
	    for (int i = 0; i < denomIntList.size(); i++)
        {
            changeBack.put(denomIntList.get(i), amountList[i]);
        }
	    

        System.out.println(changeBack);
        System.out.println();
	    System.out.println("Change back needed still: " + amountLeft);
	    
	}
}