package Model.ItemPackage;

public class Game extends Item
{
    private String genre;
    private int releaseYear;
    private String platform;


public Game()
{
    super();
}

public Game(String title, int priceGroup, String genre, int releaseYear, String platform, int id, int inStock) 
{
    super(title, priceGroup, id, inStock);
    this.genre = genre;
    this.releaseYear = releaseYear;
    this.platform = platform;
}

public String getGenre() 
{
    return genre;
}

public void setGenre(String genre) 
{
    this.genre = genre;
}

public int getReleaseYear() 
{
    return releaseYear;
}

public void setReleaseYear(int releaseYear) 
{
    this.releaseYear = releaseYear;
}

public String getPlatform() 
{
    return platform;
}

public void setPlatform(String platform) 
{
    this.platform = platform;
}

@Override
public String toString() 
{
	return "<html>Title: " + getTitle()  + "<br>Genre: " + getGenre() + "<br>Releaseyear: " 
			+ getReleaseYear() + "<br>Platform: " + getPlatform() + "<br>Pricegroup: " + getPriceGroup() + "<br>Nr of copies: " + getInStock() + "<br>Item id: " + getId() + "<br><br></html>";
}


}
