import java.util.*;
import java.lang.Math;

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
    
    
	public static void main(String[] args) {
		
		ArrayList<Integer> denomIntList = denom();
		System.out.println("The possible coins to hand back (coin denomination): " + denomIntList);
		
		int changeInt = change();
		System.out.println("Change back needed: " + changeInt);
		int amountLeft = changeInt;
		
		System.out.println();
		
		// if the amount of change needed is less than the smallest coin - then it's not possible
		if (changeInt < denomIntList.get(denomIntList.size() - 1)) {
		    System.out.println("Not possible");
		    return;
		}
		
		int[] amountList = new int[denomIntList.size()];
		

		for (int i = 0; i < amountList.length; i++) {
		    int x = coinMod(denomIntList.get(i), amountLeft);
    		//System.out.println("x = " + x);
    		
    		int y = remainder(denomIntList.get(i), amountLeft);
    		//System.out.println("y = " + y);
    		
    		amountList[i] = x;
    		amountLeft = y;
		}
        
        System.out.println("Amount of each coin to give:");
        
        for (int i = 0; i < denomIntList.size(); i++)
        {
            System.out.print(denomIntList.get(i) + "\t");
        }
        
        System.out.println();
        
		for (int i = 0; i < amountList.length; i++)
        {
            System.out.print(amountList[i] + "\t");
        }
	    System.out.println();
	    System.out.println("Change back needed still: " + amountLeft);
	    
	}
}