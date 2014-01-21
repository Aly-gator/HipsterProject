package hipster.model;

public class Hipster
{

	private String name;
	private String hipsterType;
	private String hipsterPhrase;
	private String [] hipsterBooks;
	
	public Hipster()
	{
		hipsterBooks = new String[5];
		name = "Aly";
		hipsterType = "Aly Hipster";
		hipsterPhrase = "cozy";
		
		fillTheBooks();
	}
	
	public Hipster(String name, String hipsterType, String hipsterPhrase, String [] hipsterBooks)
	{
		this.name= name;
		this.hipsterBooks = hipsterBooks;
		this.hipsterPhrase = hipsterPhrase;
		this.hipsterType = hipsterType;
		
	}
	
	public String getHipsterType()
	{
		return hipsterType;
	}

	public void setHipsterType(String hipsterType)
	{
		this.hipsterType = hipsterType;
	}

	public String getHipsterPhrase()
	{
		return hipsterPhrase;
	}

	public void setHipsterPhrase(String hipsterPhrase)
	{
		this.hipsterPhrase = hipsterPhrase;
	}

	public String[] getHipsterBooks()
	{
		return hipsterBooks;
	}

	public void setHipsterBooks(String[] hipsterBooks)
	{
		this.hipsterBooks = hipsterBooks;
	}

	public void setName(String name)
	{
		this.name = name;
	}	
		
	/**
	 * getter method to get the name.
	 * @return The name of the Hipster.
	 */
	
	public String getName()
	{
		return name;
	}
	
	

	private void fillTheBooks()
	{
		hipsterBooks[0] = "Are you my mother?";
		hipsterBooks[1] = "Cat in the Hat";
		hipsterBooks[2] = "Goodnight moon";
		hipsterBooks[3] = "Magic treehouse";
		hipsterBooks[4] = "Just in time";
		
		//*using this section we can determine which lines to do.
		
	}
	
		
		
	
}
