
import org.junit.Assert;
import org.junit.Test;

public class PRNParserTest {
	
	@Test
	public void CheckLineFormat_LineToSmall() // Kazar
	{
		ParseStatus expected = ParseStatus.Incomplete;
		PRNParser test = new PRNParser();
		ParseStatus actual = test.ParseLine("aaa");
		Assert.assertEquals(expected,actual);
	}
	
	@Test
	public void CheckLineFormat_LineToLong() // aroh
	{
		ParseStatus expected = ParseStatus.Error;
		PRNParser test = new PRNParser();
		ParseStatus actual = test.ParseLine("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		Assert.assertEquals(expected,actual);
	}
	
	@Test
	public void CheckLineFormat_InvaildAuthorName()
	{
		ParseStatus expected = ParseStatus.Error;
		PRNParser test = new PRNParser();
		String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1234567890aaaaaaaaaa1234567890123";
		ParseStatus actual = test.ParseLine(str);
		Assert.assertEquals(expected,actual);
	}
	
	@Test
	public void CheckLineFormat_InvaildIsbn()
	{
		ParseStatus expected = ParseStatus.Error;
		PRNParser test = new PRNParser();
		String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,Aaaaaaaaaaaaaaaaaa123456a890123";
		ParseStatus actual = test.ParseLine(str);
		Assert.assertEquals(expected,actual);
	}
	
	@Test
	public void CheckLineFormat_VaildLine()
	{
		ParseStatus expected = ParseStatus.Done;
		PRNParser test = new PRNParser();
		String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,Aaaaaaaaaaaaaaaaaa1234567890123";
		ParseStatus actual = test.ParseLine(str);
		Assert.assertEquals(expected,actual);
	}
}
