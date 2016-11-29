package Model.ItemPackage;

public class Video extends Item
{
    /**
         * 
         */
        private static final long serialVersionUID = 1L;
        private String genre;
        private int releaseYear;
        private String medium;
    
    
    public Video() 
    {
	super();
    }
    
    public Video(String title, int priceGroup, String genre, int releaseYear, String medium, int id, int inStock) 
    {
	super(title, priceGroup, id, inStock);
	this.genre = genre;
	this.releaseYear = releaseYear;
	this.medium = medium;
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
    
    public String getMedium() 
    {
	return medium;
    }
    
    public void setMedium(String medium) 
    {
	this.medium = medium;
    }
    
    @Override
    public String toString() 
    {
    	return "<html>Title: " + getTitle()  + "<br>Genre: " + getGenre() + "<br>Releaseyear: " 
    			+ getReleaseYear() + "<br>Medium: " + getMedium() + "<br>Pricegroup: " + getPriceGroup() + "<br>Nr of copies: " + getInStock() + "<br>Item id: " + getId() + "<br><br></html>";
    		
    }

}
