package mohammed.dieb.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.core.client.GWT;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SolvingSecondOrderedEquations implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final SolveAsync solveService = GWT.create(Solve.class);

	/**
	 * This is the entry point method.
	 */

	public void onModuleLoad() {
		
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rootPanel.add(horizontalPanel);
		
		Button btnNewButton = new Button("Solve it");
		horizontalPanel.add(btnNewButton);
		btnNewButton.setSize("100px", "33px");
		
		final Label r = new Label("   ");
				horizontalPanel.add(r);
				
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {


				String numA =((InputElement)(Element)DOM.getElementById("a")).getValue();
				String numB =((InputElement)(Element)DOM.getElementById("b")).getValue();
				String numC =((InputElement)(Element)DOM.getElementById("c")).getValue();
				double a=Double.parseDouble(numA);
				double b=Double.parseDouble(numB);
				double c=Double.parseDouble(numC);
				
				solveService.solveResult(a, b, c, new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result1) {
						// TODO Auto-generated method stub
						/* See the difference in use these 2 ways to add result*/
						r.setText("  "+result1);
						DOM.getElementById("result").setInnerHTML(result1);
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						DOM.getElementById("result").setInnerHTML(SERVER_ERROR);
					}
				} 
						
						);	
			}});
		

	}
	

}