package designPatternsSingleton;

/**
 * Stack overflow! :)
 * @author mrincodi
 *
 */
public class CrazyClass {

	CrazyClass c;
	
	CrazyClass () {
		c = new CrazyClass ();
	}
	public static void main(String[] args) {
		CrazyClass c = new CrazyClass();
	}

}
