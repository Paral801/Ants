/**
 *COSC326 Etude01: Ants
 *@authors Alfred Pardoe, Shonit Naidu
 *@ids 7150195, 4126740
 */

import java.util.*;

public class Ants{
    public static ArrayList<State> objects = new ArrayList<State>();
    public static HashMap<String, String> antGrid = new HashMap<String, String>();

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String first;
	
	while(sc.hasNextLine()){
	    first = sc.nextLine();
	    String[] nesw = new String[4];
	    String[] change = new String[4];
	    String state;
	    int steps;

	    if(first.matches("\\d+")){
		steps = Integer.parseInt(first);
		go(steps);
		objects.clear();
		antGrid.clear();
		System.out.println();
	    }else if(!(first.isEmpty()) && first.charAt(0) != '#'){
	        state = first.substring(0, 1);
 	        nesw[0] = first.substring(2, 3);
		nesw[1] = first.substring(3, 4);
		nesw[2] = first.substring(4, 5);
		nesw[3] = first.substring(5, 6);
		change[0] = first.substring(7, 8);
		change[1] = first.substring(8, 9);
		change[2] = first.substring(9, 10);
		change[3] = first.substring(10, 11);
		State s = new State(state, nesw, change);
		objects.add(s);	
	    }else{
		if(sc.hasNextLine()){
		    String trash = first;
		}
	    }
	    
	}

	
    }//end main

    public static void go(int steps){
	int printSteps = steps;
	String currDir = "N";
	String nextDir = "";
	String currState = objects.get(0).getState();
        String spot = "0,0";
	antGrid.put(spot, currState);
	
	//creates initial 0,0 with states
	while(steps > 0){
	    if(currDir.equals("N")){
		//check if current location has been visited
		if(antGrid.containsKey(spot)){
		    
		    currState = antGrid.get(spot);//if so: set current state
		    //find state object of current
		    for(int a = 0; a < objects.size(); a++){
			if(currState.equals(objects.get(a).getState())){
			    //move direction is equal to N
			    nextDir = objects.get(a).arriveNorth();
			    antGrid.put(spot, objects.get(a).stateNorth());
			}
		    }
		    
		    spot = move(spot, nextDir);
		    currDir = nextDir;

		}else{		    
		    antGrid.put(spot, objects.get(0).getState());
		    currState = antGrid.get(spot);
		    
		    for(int a = 0; a < objects.size(); a++){
			if(currState.equals(objects.get(a).getState())){
			    //move direction is equal to N
			    nextDir = objects.get(a).arriveNorth();
			    antGrid.put(spot, objects.get(a).stateNorth());
			}
		    }
		    
		    spot = move(spot, nextDir);
		    currDir = nextDir;
		}

		//IF YOU COME IN FROM AN EAST DIRECTION:
	    }else if(currDir.equals("E")){
		if(antGrid.containsKey(spot)){
		   
		    currState = antGrid.get(spot);//if so: set current state
		    //find state object of current
		    for(int a = 0; a < objects.size(); a++){
			if(currState.equals(objects.get(a).getState())){
			    //move direction is equal to N
			    nextDir = objects.get(a).arriveEast();
			    antGrid.put(spot, objects.get(a).stateEast());
			}
		    }
		    
		    spot = move(spot, nextDir);
		    currDir = nextDir;

		}else{	
		    antGrid.put(spot, objects.get(0).getState());
		    currState = antGrid.get(spot);
		    
		    for(int a = 0; a < objects.size(); a++){
			if(currState.equals(objects.get(a).getState())){
			    //move direction is equal to N
			    nextDir = objects.get(a).arriveEast();
			    antGrid.put(spot, objects.get(a).stateEast());
			}
		    }
		    
		    spot = move(spot, nextDir);
		    currDir = nextDir;
		}

		//ARRIVNG FROM THE SOUTHERN DIRECTION:
	    }else if(currDir.equals("S")){
		if(antGrid.containsKey(spot)){
		    
		    currState = antGrid.get(spot);//if so: set current state
		    //find state object of current
		    for(int a = 0; a < objects.size(); a++){
			if(currState.equals(objects.get(a).getState())){
			    //move direction is equal to N
			    nextDir = objects.get(a).arriveSouth();
			    antGrid.put(spot, objects.get(a).stateSouth());
			}
		    }
		    
		    spot = move(spot, nextDir);
		    currDir = nextDir;

		}else{		    
		    antGrid.put(spot, objects.get(0).getState());
		    currState = antGrid.get(spot);
		    
		    for(int a = 0; a < objects.size(); a++){
			if(currState.equals(objects.get(a).getState())){
			    //move direction is equal to N
			    nextDir = objects.get(a).arriveSouth();
			    antGrid.put(spot, objects.get(a).stateSouth());
			}
		    }
		    
		    spot = move(spot, nextDir);
		    currDir = nextDir;
		}
		
		//ARRIVING FROM THE WESTERN DIRECTION:
	    }else if(currDir.equals("W")){
		if(antGrid.containsKey(spot)){
		    
		    currState = antGrid.get(spot);//if so: set current state
		    //find state object of current
		    for(int a = 0; a < objects.size(); a++){
			if(currState.equals(objects.get(a).getState())){
			    //move direction is equal to N
			    nextDir = objects.get(a).arriveWest();
			    antGrid.put(spot, objects.get(a).stateWest());
			}
		    }
		    
		    spot = move(spot, nextDir);
		    currDir = nextDir;

		}else{		    
		    antGrid.put(spot, objects.get(0).getState());
		    currState = antGrid.get(spot);
		    
		    for(int a = 0; a < objects.size(); a++){
			if(currState.equals(objects.get(a).getState())){
			    //move direction is equal to N
			    nextDir = objects.get(a).arriveWest();
			    antGrid.put(spot, objects.get(a).stateWest());
			}
		    }
		    
		    spot = move(spot, nextDir);
		    currDir = nextDir;
		}
	    }
	
	    steps--;
	}
	for(State ob : objects){
	    System.out.print(ob.state + " ");
	    System.out.print(ob.nesw[0] + ob.nesw[1] + ob.nesw[2] + ob.nesw[3]);
	    System.out.print(" ");
	    System.out.print(ob.change[0] + ob.change[1] + ob.change[2] + ob.change[3]);
	    System.out.println();

	}
        
	System.out.println(printSteps);
        String[] temp = new String[2];
	temp = spot.split(",");
        int x = Integer.parseInt(temp[0]);
	int y = Integer.parseInt(temp[1]);
	System.out.println("# " + x + " " + y);
    }

    public static String move(String spot, String nextDir){
        String[] temp = new String[2];
	temp = spot.split(",");
        int x = Integer.parseInt(temp[0]);
	int y = Integer.parseInt(temp[1]);

	if(nextDir.equals("N")){
	    y = y + 1;
	}else if(nextDir.equals("E")){
	    x = x + 1;
	}else if(nextDir.equals("S")){
	    y = y - 1;
	}else if(nextDir.equals("W")){
	    x = x - 1;
	}
	//create next position in grid with initial state
        String pos = x + "," + y;
	return pos;
    }
}//end class
