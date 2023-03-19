package LListbusiness;

import java.util.Objects;

/**
 *
 * @author Conor Garvey
 * 
 */

public class Song {

	private String title;
	private String artist;

	// 1. A default constructor that sets the artist to “Joe Bloggs” and title to
	// “Mmmbop”.
	public Song() {
		title = "Mmmbop";
		artist = "Joe Bloggs";
	}

	// 2. A constructor that takes in two parameters – the artist and the title.
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}

	// 3. Getter and setter methods for the artist and title.
	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	// 4. An equals() method and a hashCode() method – these should base their
	// calculation on the artist and title fields.

	// 5. A toString() method that returns the artist and title information in a
	// well-formatted manner
	@Override
	public String toString() {
		return "Song {" + "Title=" + title + ", Artist=" + artist + '}';
	}

		@Override
		public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Song)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Song other = (Song) obj;
		if (!Objects.equals(this.title, other.title)) {
			return false;
		}
		if (!Objects.equals(this.artist, other.artist)) {
			return false;
		}
		return true;
	}
	@Override
	public int hashCode() {
		int hash = 8;
		hash = 90 * hash + Objects.hashCode(this.title);
		hash = 90 * hash + Objects.hashCode(this.artist);
		return hash;
	}

	
}
