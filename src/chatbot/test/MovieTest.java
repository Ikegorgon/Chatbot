package chatbot.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chat.model.Movie;

public class MovieTest
{
	private Movie testedMovie;
	
	@Before
	public void setUp() throws Exception
	{
		testedMovie = new Movie("");
	}

	@After
	public void tearDown() throws Exception
	{
		testedMovie = null;
	}

	@Test
	public void testMovie()
	{
		assertNotNull("Movies need a default genre", testedMovie.getGenre());
		assertNotNull("Movies need a default title", testedMovie.getTitle());
		assertTrue("Movies have a default length greater than 0", testedMovie.getLength() > 0);
	}

	@Test
	public void testGetTitle()
	{
		assertTrue("", testedMovie.getTitle().length() > 3);
	}

	@Test
	public void testGetGenre()
	{
		assertTrue("Valid Genre names are longer than 4 characters.", testedMovie.getGenre().length() > 4);
	}

	@Test
	public void testGetRatingMPAA()
	{
		String [] validRatings = {"G","PG","PG-13","R"};
	
		boolean isValid = false;
		for(String rating : validRatings)
		{
			if (testedMovie.getRatingMPAA().equals(rating))
			{
				isValid = true;
			}
		}
		
		assertTrue("Rating must be valid", isValid);
	}

	@Test
	public void testGetReview()
	{
		assertNotNull("Movie must have a review", testedMovie.getReview());
		assertTrue("Default review must be at least four words", testedMovie.getReview().split(" ").length > 3);
	}

	@Test
	public void testGetLength()
	{
		assertTrue("Movies are at least ten minutes", testedMovie.getLength() > 10);
	}

	@Test
	public void testGetReleaseDate()
	{
		assertNotNull("Movies have a release date", testedMovie.getReleaseDate());
	}

	@Test
	public void testGetStarScore()
	{
		assertFalse("Cannot use Nan as a value" , Double.isNaN(testedMovie.getStarScore()));
		assertTrue("No more than 10 stars", testedMovie.getStarScore() < 10.0);
	}

	@Test
	public void testSetTitle()
	{
		String title = "temp";
		testedMovie.setTitle(title);
		assertTrue("Title should be changed", testedMovie.getTitle().equals(title));
	}

	@Test
	public void testSetGenre()
	{
		String genre = "some genre";
		testedMovie.setGenre(genre);
		assertTrue("Genre should be changed", testedMovie.getGenre().equals(genre));
	}

	@Test
	public void testSetRatingMPAA()
	{
		String rating = "G";
		testedMovie.setRatingMPAA(rating);
		assertTrue("Rating should be changed", testedMovie.getRatingMPAA().equals(rating));
	}

	@Test
	public void testSetReview()
	{
		String review = "temp";
		testedMovie.setReview(review);
		assertTrue("Review should be changed", testedMovie.getReview().equals(review));
	}

	@Test
	public void testSetLength()
	{
		int length = 100;
		testedMovie.setLength(length);
		assertTrue("Length should change", testedMovie.getLength() == length);
		
	}

	@Test
	public void testSetReleaseDate()
	{
		LocalDate current = LocalDate.now();
		testedMovie.setReleaseDate(current);
		assertTrue("Release date should be set", testedMovie.getReleaseDate().equals(current));
	}

	@Test
	public void testSetStarScore()
	{
		double starScore = 6.500;
		testedMovie.setStarScore(starScore);
		assertTrue("Star score not properly linked.", testedMovie.getStarScore() - starScore < 0.001);
	}
	
	@Test
	public void testToString()
	{
		assertFalse("Not implemented properly", testedMovie.toString().contains("@"));
	}
}
