package elevator;
import java.util.*;
import java.io.*;
import java.lang.Object.*;
public class elevator extends Object implements Cloneable,Serializable{

		public static float [] in = new float [20];
		public static float [] off = new float [20];
		public static float floor = 7;
		public static float N = 0;
		public static float a = 0;
		public static float b = 0;
		public static float state = 0;
		public static float action = 0;
		public static float stay = 0;
		public static float count = 0;
		public static float count1 = 0;
		public static float count2 = 0;
		public static float count3 = 0;
		public static float count4 = 0;
		public static float count5 = 0;
		public static float count6 = 0;
		public static float count7 = 0;
 		public static void main(String[] args) {
			
			while(true){
				System.out.println();
			System.out.println("Elevator learning automaton");
			System.out.println("Fixed Structure Automata");
		//	System.out.println("input floor:");
			Scanner in = new Scanner(System.in);
		//	floor = in.nextFloat();
		    System.out.println("input N(how many states for each action):");
		   
		    N = in.nextFloat();
		    System.out.println();
		    state = N;
		    elevator ele = new elevator();
		    ele.createrequest();
		    ele.createoff();
		   for(int i=1;i<=1000;i++){
		    for(int j=1;j<=20000;j++){
		    	ele.request();
		    	ele.getoff();
		    	while(a==b){
		    		ele.getoff();
		    	}
		 //   	System.out.println("requeset floor:"+a+"   get off floor:"+b);
		    	ele.simulate();
		        if(j>19000){
		        	if(state<=N){
		        		count1++;
		        	}
		        	else if(state>N && state<=2*N){
		        		count2++;
		        	}
		        	else if(state>2*N && state<=3*N){
		        		count3++;
		        	}
		        	else if(state>3*N && state<=4*N){
		        		count4++;
		        	}
		        	else if(state>4*N && state<=5*N){
		        		count5++;
		        	}
		        	else if(state>5*N && state<=6*N){
		        		count6++;
		        	}
		        	else if(state>6*N && state<=7*N){
		        		count7++;
		        	}
		        }
		    }
		//    	System.out.println("b"+b);
		   }
		//	System.out.println(count1);
	    //	System.out.println(count2);
	    //	System.out.println(count3);
	    //	System.out.println(count4);
	    //	System.out.println(count5);
	    //	System.out.println(count6);
	    //	System.out.println(count7);
	    	count= count1+count2+count3+count4+count5+count6+count7;
	   // 	System.out.println(count);
	    	count1 = count1/count;
	    	count2 = count2/count;
	    	count3 = count3/count;
	    	count4 = count4/count;
	    	count5 = count5/count;
	    	count6 = count6/count;
	    	count7 = count7/count;
	    	System.out.println("probability of stay at floor 1:"+count1);
		   	System.out.println("probability of stay at floor 2:"+count2);
		   	System.out.println("probability of stay at floor 3:"+count3);
		   	System.out.println("probability of stay at floor 4:"+count4);
		   	System.out.println("probability of stay at floor 5:"+count5);
		   	System.out.println("probability of stay at floor 6:"+count6);
		   	System.out.println("probability of stay at floor 7:"+count7);
	
			}			
		}
 		
	    public void createrequest(){
	    	float total = 0;
	    	System.out.println("Request Matrix:");
	    	for(int i=1;i<=floor;i++){
	    		float x = (float) Math.random();
	    		in[i] = x;
	    		
	    		if(i==1){
	    			in[i]=in[i]+2.0f;
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
	  //  	System.out.println("a"+a);
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
	   // 	System.out.println("b"+b);
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
	    	return 1;
	    	
	    }
	    
	    public void simulate(){
	    	int c = 0;
	    	c = environment();
	    	if(c==0){
	    		state = penalty(floor,N,state);
	    	}
	    	else if(c==1){
	    		state = reward(floor,N,state);
	    	}
	    	if(state<=N){
	    		stay=1;
	    	}
	    	else if(state<=2*N && state>N){
	    		stay=2;
	    	}
	    	else if(state<=3*N && state>2*N){
	    		stay=3;
	    	//	count3++;
	    	}
	    	else if(state<=4*N && state>3*N){
	    		stay=4;
	    	//	count4++;
	    	}
	    	else if(state<=5*N && state>4*N){
	    		stay=5;
	    	//	count5++;
	    	}
	    	else if(state<=6*N && state>5*N){
	    		stay=6;
	    	//	count5++;
	    	}
	    	else if(state<=7*N && state>6*N){
	    		stay=7;
	    	//	count5++;
	    	}
	    	
	    }
	    
	    public float penalty(float m,float n,float s){
	    	if(s!=n && s!=2*n && s!=3*n && s!=4*n && s!=5*n && s!=6*n && s!=7*n){
	    		return s+1;
	    	}
	    	else if(s==n){
	    		return 2*n;
	    	}
	    	else if(s==2*n){
	    		return 3*n;
	    	}
	    	else if(s==3*n){
	    		return 4*n;
	    	}
	    	else if(s==4*n){
	    		return 5*n;
	    	}
	    	else if(s==5*n){
	    		return 6*n;
	    	}
	    	else if(s==6*n){
	    		return 7*n;
	    	}
	    	else {
	    		return n;
	    	}
	    //	return 1;
	    }
	    
	    public float reward(float m,float n,float s){
	    	if(s!=1 && s!=(n+1) && s!=(2*n+1) && s!=(3*n+1) && s!=(4*n+1) && s!=(5*n+1) && s!=(6*n+1)){
	    		return s-1;
	    	}
	    	else if(s==1){
	    		return 1;
	    	}
	    	else if(s==(n+1)){
	    		return (n+1);
	    	}
	    	else if(s==(2*n+1)){
	    		return (2*n+1);
	    	}
	    	else if(s==(3*n+1)){
	    		return (3*n+1);
	    	}
	    	else if(s==(4*n+1)){
	    		return (4*n+1);
	    	}
	    	else if(s==(5*n+1)){
	    		return (5*n+1);
	    	}
	    	else{
	    		return (6*n+1);
	    	}
	    	//return 1;
	    	
	    }


}
