package mohammed.dieb.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("byMohammedDieb")
public interface Solve extends RemoteService {
	String solveResult(double a,double b,double c)throws IllegalArgumentException;
}
