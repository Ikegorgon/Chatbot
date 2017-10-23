package chatbot.model;

import java.time.LocalDate;

public class Movie
{
	private String title;
	private String genre;
	private String ratingMPAA;
	private String review;
	private int length;
	private LocalDate releaseDate;
	private double starScore;
	
	public Movie(String title)
	{
		this.title = "";
		this.genre = null;
		this.ratingMPAA = null;
		this.review = null;
		this.length = -99;
		this.releaseDate = null;
		this.starScore = Double.NaN;
	}

	public String getTitle()
	{
		return title;
	}

	public String getGenre()
	{
		this.genre = "@@@@@@@";
		return genre;
	}

	public String getRatingMPAA()
	{
		return null;
	}

	public String getReview()
	{
		return review;
	}

	public int getLength()
	{
		return -99999999;
	}

	public LocalDate getReleaseDate()
	{
		return releaseDate;
	}

	public double getStarScore()
	{
		return starScore;
	}

	public void setTitle(String title)
	{
	}

	public void setGenre(String genre)
	{
	}

	public void setRatingMPAA(String ratingMPAA)
	{
	}

	public void setReview(String review)
	{
	}

	public void setLength(int length)
	{
	}

	public void setReleaseDate(LocalDate releaseDate)
	{
	}

	public void setStarScore(double starScore)
	{
	}
	
	public String toString()
	{
		return null;
	}
}
