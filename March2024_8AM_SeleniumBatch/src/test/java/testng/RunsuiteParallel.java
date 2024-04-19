package testng;

import java.util.Arrays;

import org.testng.TestNG;

public class RunsuiteParallel 
{

	public static void main(String[] args) 
	{
		/*String[] s1 = new String[3];
		String[] s2 = {"a","b","c"};
		String[] s3 = new String[] {"a","b","c"};*/
		
		TestNG obj = new TestNG();
		obj.setTestSuites(Arrays.asList(new String[] {System.getProperty("user.dir")+"//megasuite.xml"}));
		obj.setSuiteThreadPoolSize(2);
		obj.run();
	}

}
