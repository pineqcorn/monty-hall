package main;
import java.util.Random;
import java.util.Scanner;


//import java.util.Array;
class Main {
    public static void main(String[] args) {
      System.out.println("How many monty hall problems? ");
      Scanner scan = new Scanner(System.in);
      int switches = 0;
      int stays = 0;
      int total = scan.nextInt();
      long start = System.currentTimeMillis();
      long end = start;
      
      scan.close();
      
      for (int i = 1; i < total; i++) {
    	loading(20, total, i);
        String result = montyHall();
        if (result.equals("switch")) {
          switches++;
        } else {stays++;}
      }

      end = System.currentTimeMillis();
      System.out.print(total + " Monty Hall Problems in " + 
(end - start) +"ms\nSwitches: " + switches + "\nStays: " + stays);
    }

  public static String montyHall() {
    Random rand = new Random();

    //creates doors
    String[] doors = new String[3];
    int prize = rand.nextInt(3);
    for (int door = 0; door < doors.length; door++) {
      if (door != prize) {
        doors[door] = "goat";
      } else {doors[door] = "prize";}
    }

    int choice = rand.nextInt(3);
    for (int door = 0; door < doors.length; door++) {
      if (door != choice && doors[door] == "goat") {
        //reveal this door
        doors[door] = "revealed goat";
      }
    }

    if (doors[choice] == "prize") {
      return "stay";
    } else {
      return "switch";
    }
  }
  
  public static void clearScreen() {  
	   System.out.print("\033[H\033[2J");  
	  // System.out.print("\r\b");
	   System.out.flush();  
	} 
 
  private static String repeat(String thing, int num) {
		String output = "";
		for (int i = 0; i < num; i++) {
			output += thing;
		}
		return output;
	}
  
  private static void loading(int loadLength, int maxValue, int currentValue) {
	  final double CURRENT_VALUE_PERCENTAGE = ((int) (1000.0 * currentValue / maxValue)) / 10.0;
	  final double PREV_VALE_PERCENTAGE = ((int) (1000.0 * (currentValue - 1) / maxValue)) / 10.0;
	  final int LOAD_PROPORTION = (int) Math.ceil((1.0 * loadLength * currentValue) / maxValue);
	  
	  if (CURRENT_VALUE_PERCENTAGE == PREV_VALE_PERCENTAGE) {
		  return;
	  }
	  
	  System.out.print("[" + repeat("=", LOAD_PROPORTION) + repeat(" ", loadLength - LOAD_PROPORTION) + "] " + CURRENT_VALUE_PERCENTAGE + "%");
	  System.out.print("\r");

	  try {
		Thread.sleep(1);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
  

}