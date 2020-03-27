package StepDefinations;
/**
 * Class for Post scenario (Action after test complete)
 * 
 * @author Ashutosh Pradhan
 */

import Base.DriverScript;
/**
 * Class for PostScenario 
 * 
 * @author Ashutosh Pradhan
 */
import cucumber.api.java.After;

public class PostScenario extends DriverScript {

	public PostScenario() {
		super();
	}

	@After
	public void postCondition() {
		DriverScript.tearDown();
	}

}
