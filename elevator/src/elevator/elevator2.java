package elevator;
import java.util.*;
import java.io.*;
import java.lang.Object.*;
public class elevator2 extends Object implements Cloneable,Serializable{

		public static float [] in = new float [20];
		public static float [] off = new float [20];
		public static float floor = 7;
		public static float N = 0;
		public static float a = 0;
		public static float b = 0;
		public static float state = 0;
		public static float action = 0;
		public static float stay = 0;
	//	public static float count = 0;
		public static float [] count = new float [10];
		// count[1] = 1/7;
		//public static float count[2] = 1/7;
		//public static float count[3] = 1/7;
		//public static float count4 = 1/7;
		//public static float count5 = 1/7;
		//public static float count6 = 1/7;
		//public static float count7 = 1/7;
 		public static void main(String[] args) {
			
			while(true){
				for(int i=1;i<=7;i++){
		    		count[i]=1/7;
		    	}
				System.out.println();
				System.out.println("Elevator learning automaton");
				System.out.println("Variable Structure Automata");
	         	System.out.println("start?(1.yes/2.no)");
				Scanner in = new Scanner(System.in);
		     	state = in.nextFloat();
		//		System.out.println("input N(how many states for each action):");
		   
		//		N = in.nextFloat();
		//		System.out.println();
		//		state = N;
				elevator2 ele = new elevator2();
				ele.createrequest();
				ele.createoff();
			//	for(int i=1;i<=1000;i++){
					for(int j=1;j<=20000;j++){
					//	System.out.println("hello");
						ele.request();
						ele.getoff();
						while(a==b){
							ele.getoff();
						//	System.out.println("hello");
						}
					//	System.out.println("hello");
		 //   	System.out.println("requeset floor:"+a+"   get off floor:"+b);
						ele.simulate();
		        
		//    	System.out.println("b"+b);
				//	}
				}
		//	System.out.println(count1);
	    //	System.out.println(count2);
	    //	System.out.println(count3);
	    //	System.out.println(count4);
	    //	System.out.println(count5);
	    //	System.out.println(count6);
	    //	System.out.println(count7);
	    	count[0]= count[1]+count[2]+count[3]+count[4]+count[5]+count[6]+count[7];
	   // 	System.out.println(count);
	    //	count1 = count1/count;
	    //	count2 = count2/count;
	    //	count3 = count3/count;
	    //	count4 = count4/count;
	    //	count5 = count5/count;
	    //	count6 = count6/count;
	    //	count7 = count7/count;
	    //	System.out.println("total:"+count[0]);
	    	System.out.println("probability of stay at floor 1:"+count[1]);
		   	System.out.println("probability of stay at floor 2:"+count[2]);
		   	System.out.println("probability of stay at floor 3:"+count[3]);
		   	System.out.println("probability of stay at floor 4:"+count[4]);
		   	System.out.println("probability of stay at floor 5:"+count[5]);
		   	System.out.println("probability of stay at floor 6:"+count[6]);
		   	System.out.println("probability of stay at floor 7:"+count[7]);
				}
			
						
		}
 		
	    public void createrequest(){
	    	float total = 0;
	    	System.out.println("Request Matrix:");
	    	for(int i=1;i<=floor;i++){
	    		float x = (float) Math.random();
	    		in[i] = x;
	    		
	    		if(i==4){
	    			in[i]=in[i]+4.0f;
	    		}
	   // 		System.out.println(in[i]);
	    		total = total + in[i];
	    	}
	        for(int i=1;i<=floor;i++){
	        	in[i] = in[i]/total;        	
	        	System.out.println("floor:"+i+"   "+"probability:"+in[i]);
	        }
	        System.out.println();
	    }
			
		public void createoff(){
		    float total = 0;
		    System.out.println("Get Off Matrix:");
		    for(int i=1;i<=floor;i++){
	    		float x = (float) Math.random();
	    		off[i] = x;
	    		total = total + off[i];
	    	}
	        for(int i=1;i<=floor;i++){
	        	off[i] = off[i]/total;        	
	        	System.out.println("floor:"+i+"   "+"probability:"+off[i]);
	        }
	        System.out.println(); 
		}
		
	    public void request(){
	    	float x = (float) Math.random();
	  //  	System.out.println("request pr:");
	  //  	System.out.println(x);
	    	if(x<=in[1]){
	    		a = 1;
	    	}
	    	else if(x>in[1] && x<=(in[2]+in[1])){
	    		a = 2;
	    	}
	    	else if(x>(in[1]+in[2]) && x<=(in[1]+in[2]+in[3])){
	    		a = 3;
	    	}
	    	else if(x>(in[1]+in[2]+in[3]) && x<=(in[1]+in[2]+in[3]+in[4])){
	    		a = 4;
	    	}
	    	else if(x>(in[1]+in[2]+in[3]+in[4]) && x<=(in[1]+in[2]+in[3]+in[4]+in[5])){
	    		a = 5;
	    	}
	    	else if(x>(in[1]+in[2]+in[3]+in[4]+in[5]) && x<=(in[1]+in[2]+in[3]+in[4]+in[5]+in[6]))
	    	{
	    		a = 6;
	    	}
	    	else if(x>(in[1]+in[2]+in[3]+in[4]+in[5]+in[6]) && x<(in[1]+in[2]+in[3]+in[4]+in[5]+in[6]+in[7]))
	    	{
	    		a = 7;
	    	}
	    //	System.out.println("a"+a);
	    }
		
	    public void getoff(){
	    	float x = (float) Math.random();
	  //  	System.out.println("get off pr:");
	  //  	System.out.println(x);
	    	if(x<=off[1]){
	    		b = 1;
	    	}
	    	else if(x>off[1] && x<=(off[2]+off[1])){
	    		b = 2;
	    	}
	    	else if(x>(off[1]+off[2]) && x<=(off[1]+off[2]+off[3])){
	    		b = 3;
	    	}
	    	else if(x>(off[1]+off[2]+off[3]) && x<=(off[1]+off[2]+off[3]+off[4])){
	    		b = 4;
	    	}
	    	else if(x>(off[1]+off[2]+off[3]+off[4]) && x<=(off[1]+off[2]+off[3]+off[4]+off[5])){
	    		b = 5;
	    	}
	    	else if(x>(off[1]+off[2]+off[3]+off[4]+off[5]) && x<=(off[1]+off[2]+off[3]+off[4]+off[5]+off[6]))
	    	{
	    		b = 6;
	    	}
	    	else if(x>(off[1]+off[2]+off[3]+off[4]+off[5]+off[6]) && x<(off[1]+off[2]+off[3]+off[4]+off[5]+off[6]+off[7]))
	    	{
	    		b = 7;
	    	}
	    //	System.out.println("b"+b);
	   // 	System.out.println();
	    }
		
	    
	    public int environment(){
	    	float x = (float) Math.random();
	    	if(a>b){
	    		if(stay<=b){
	    			return 0;
	    		}
	    		else if(stay>=((4*a-b)/3)){
	    			return 0;
	    		}
	    		else if(stay>b && stay<a){
	    			if(x<=(((a-stay)/(a-b)))){
	    				return 0;
	    			}
	    			else
	    			{
	    				return 1;
	    			}
	    		}
	    		else if(stay>a && stay<((4*a-b)/3)){
	    			if(x<=((3*(a-stay)/(a-b)))){
	    				return 0;
	    			}
	    			else 
	    			{
	    				return 1;
	    			}
	    		}
	    		else if(stay==a)
	    		{
	    			return 1;
	    		}
	    	}
	    	
	    	else if(a<b){
	    		if(stay>=b){
	    			return 0;
	    		}
	    		else if(stay<=((4*a-b)/3)){
	    			return 0;
	    		}
	    		else if(stay>a && stay<b){
	    			if(x<=(((stay-a)/(b-a)))){
	    				return 0;
	    			}
	    			else{
	    				return 1;
	    			}
	    		}
	    		else if(stay<a && stay>((4*a-b)/3)){
	    			if(x<=((3*(stay-a)/(b-a)))){
	    				return 0;
	    			}
	    			else{
	    				return 1;
	    			}
	    		}
	    		else if(stay==a){
	    			return 1;
	    		}
	    	}
	    	return 0;
	    	
	    }
	    
	    public void simulate(){
	    	float x = (float) Math.random();
	    	
	    	if(x<=count[1]){
	    		stay=1;
	    	}
	    	else if(x>count[1] && x<=(count[1]+count[2])){
	    		stay=2;
	    	}
	    	else if(x>(count[1]+count[2]) && x<=(count[1]+count[2]+count[3])){
	    		stay=3; 
	    	}
	    	else if(x>(count[1]+count[2]+count[3]) && x<=(count[1]+count[2]+count[3]+count[4])){
	    		stay=4;
	    	}
	    	else if(x>(count[1]+count[2]+count[3]+count[4]) && x<=(count[1]+count[2]+count[3]+count[4]+count[5])){
	    		stay=5;
	    	}
	    	else if(x>(count[1]+count[2]+count[3]+count[4]+count[5]) && x<=(count[1]+count[2]+count[3]+count[4]+count[5]+count[6])){
	    		stay=6;
	    	}
	    	else {
	    		stay=7;
	    	}
	    	int c = 0;
	    	c = environment();
	    	if(c==0){
	    		penalty(stay);
	    	}
	    	else if(c==1){
	    		reward(stay);
	    	}
	    	
	    }
	    
	    public void penalty(float a1){
	    	float x1 = 0.05f;
	    	int x = (int)a1;
	    	count[x] = (1-x1)*count[x];
	    	for(int i=1;i<=7;i++){
	    		if(i!=x){
	    			count[i] = x1/6+(1-x1)*count[i];
	    		}
	    	}
	    	
	    	
	    	
	    }
	    
	    public void reward(float a2){
	    	float x2 = 0.2f;
	    	int x = (int)a2;
	    	count[x] = count[x]+x2*(1-count[x]);
	    	for(int i=1;i<=7;i++){
	    		if(i!=x){
	    			count[i] = (1-x2)*count[i];
	    		}
	    	}
	    	
	    }


}
