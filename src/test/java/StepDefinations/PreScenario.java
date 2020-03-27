package StepDefinations;
/**
 * Class for Pre scenario (Action before test Start)
 * 
 * @author Ashutosh Pradhan
 */

import Base.DriverScript;
/**
 * Class for PreScenario 
 * 
 * @author Ashutosh Pradhan
 */
import cucumber.api.java.Before;

public class PreScenario extends DriverScript {

	public PreScenario() {
		super();
	}

	@Before
	public void preCondtion() {
		init();
	}

}
