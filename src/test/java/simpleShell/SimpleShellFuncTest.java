package simpleShell;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epam.simpleShell.Response;
import com.epam.simpleShell.action.ActionEnum;
import com.epam.simpleShell.invoker.Invoker;
import com.epam.simpleShell.invoker.impl.InvokerImpl;


public class SimpleShellFuncTest {
	private AnnotationConfigApplicationContext ctx;
	private Invoker invoker;
	@Before
	public void doBefore()
	{
		ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.epam.simpleShell");
		ctx.refresh();
		invoker = (InvokerImpl) ctx.getBean("invoker");
	}

	@Test
	public void testInvalidInput()
	{
		Response response = invoker.executeAction(null, Arrays.asList());
		Assert.assertEquals(response.isContainsError(), true);
		Assert.assertEquals(response.getErrorMessage(), "Invalid input");
	}
	
	@Test
	public void testProperInput()
	{
		Response response = invoker.executeAction(ActionEnum.DIR, Arrays.asList());
		Assert.assertEquals(response.isContainsError(), false);
	}

	@Test
	public void testExtraParamInDirInput()
	{
		Response response = invoker.executeAction(ActionEnum.DIR, Arrays.asList("invalidArgument"));
		Assert.assertEquals(response.isContainsError(), true);
		Assert.assertEquals(response.getErrorMessage(), "Invalid argument number");
	}	
	
	@After
	public void doAfter()
	{
		ctx.close();
	}
}
