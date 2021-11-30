public class PRNParser
{	
	private Book last_book;
	
	public PRNParser()
	{
		last_book = null;
	}
	
	public PRNParser(String line)
	{
		ParseLine(line);
	}
	
	public ParseStatus ParseLine(String line)
	{
		if(line.length() < 83)
			return ParseStatus.Incomplete;
		if(line.length() > 83)
			return ParseStatus.Error;
		Book tmp_book = new Book(line.substring(0,40),line.substring(40,70),line.substring(70));
		// Check Author
		String author = tmp_book.getAuthor();
		boolean has_comma = false;
		for(int i =0;i<30;i++)
		{
			if(author.charAt(i) >= '0' && author.charAt(i) <= '9')
				return ParseStatus.Error;
			if(author.charAt(i) == '/' || author.charAt(i) == ',')
				if(!(author.charAt(i+1) >= 'A' &&  author.charAt(i+1) <= 'Z'))
					return ParseStatus.Error;
			if(author.charAt(i) == ',')
				has_comma = true;
		}
		if(has_comma == false)
			return ParseStatus.Error;
		
		//if(!(tmp_book.getAuthor().matches("(([A-Z][a-z]*\s?)*/?)*,(([A-Z][a-z]*\\s?)*/?)*")))
		//{
			//System.out.println("Im Here");
			//System.out.println(tmp_book.getAuthor());
			//tmp_book = null;
			//return ParseStatus.Error;
		//}
		
		String isbn = tmp_book.getIsbn();
		for(int i =0 ; i<13; i++)
			if(!(isbn.charAt(i) >= '0' && isbn.charAt(i) <= '9'))
				return ParseStatus.Error;
		last_book = tmp_book;
		tmp_book = null;
		return ParseStatus.Done;
	}
	
	Book getLastRead() { return last_book; }
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		PRNParser parser = new PRNParser();
	}
}
