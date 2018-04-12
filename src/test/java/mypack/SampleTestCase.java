package mypack;
import junit.framework.TestCase;

public class SampleTestCase extends TestCase{
	private int value1;
	private int value2;
	public SampleTestCase(String testName) {
	super(testName);
	}
	protected void setUp() throws Exception {
	super.setUp();
	value1 = 3;
	value2 = 5;
	System.out.println("::::::::setUp():::::::::::");
	}
	protected void tearDown() throws Exception {
	super.tearDown();
	value1 = 0;
	value2 = 0;
	System.out.println("::::::::tearDown():::::::::::");
	}
	public void testAdd() {
	int total = 8;
	int sum = Calc.sum(value1, value2);
	assertEquals(sum, total);
	}
	public void testFailedAdd() {
	int total = 9;
	int sum = Calc.sum(value1, value2);
	assertNotSame(sum, total);
	}
	public void testSub() {
	int total = 0;
	int sub = Calc.sub(4, 4);
	assertEquals(sub, total);
	}
}
