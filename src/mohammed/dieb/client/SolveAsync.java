package mohammed.dieb.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface SolveAsync {

	void solveResult(double a, double b, double c, AsyncCallback<String> callback);

}
