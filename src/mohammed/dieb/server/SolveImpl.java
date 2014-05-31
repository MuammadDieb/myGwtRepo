package mohammed.dieb.server;

import mohammed.dieb.client.Solve;



import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class SolveImpl extends RemoteServiceServlet implements Solve {

	double d;
	String r="";
	public  String solveResult(double a,double b,double c) {
		 d= Math.pow(b,2) - 4*a*c;
		
		 if(d<0){r="Impossible";}
	        else if(d==0){r="Doubeld Solution : &nbsp;<b> x1 &nbsp;=&nbsp; x2 &nbsp;=&nbsp; "+((-1)*b)/(2*a)+"</b>";}
	        	else{r="&nbsp;&nbsp;Two Solution :&nbsp;<b>x1 = "+((-1*b-Math.sqrt(d))/(2*a))+" &nbsp;  | &nbsp; x2= "+((-1*b+Math.sqrt(d))/(2*a))+"</b>";}
	        
	        return r;
	}
	

}
