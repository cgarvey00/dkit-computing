package LListapp;

import java.util.Scanner;

import LListbusiness.Song;
import LListutils.LinkedList;

/**
 *
 * 
 * @author Conor Garvey
 * 
 * 
 */

public class SongList {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Song song = new Song();
		LinkedList SongList = createSong(song);
		System.out.println("-------------------------------");
		printSongList(SongList);
		System.out.println("-------------------------------");
		Song s[] = SongList.toArray();
		printSongArray(s);
		System.out.println("Last Song");
		System.out.println(SongList.tail());
//		SongList.remove3(2);
		printSongList(SongList);
		Song m1 = new Song();
		m1.setArtist("Metallica");
		m1.setTitle("Enter Sandman");
		System.out.println(SongList.indexOf(m1));

		System.out.println(SongList.remove(m1));
		System.out.println("---------------------------");
		printSongList(SongList);
//		searchAndChange(SongList);
//		System.out.println("-------------------------------");
//		printSongList(SongList);
//		System.out.println("-------------------------------");
//		isEqual(SongList, song);

//		if (SongList.isEmpty()) {
//			System.out.println("SongList Empty");
//		} else {
//			System.out.println("SongList is not Empty");
//			System.out.println("Final Count: " + SongList.size());
//		}

	}

	private static LinkedList createSong(Song song) {
		Scanner scan = new Scanner(System.in);
		String originalSong = "";
		LinkedList SongList = new LinkedList();
		while (!originalSong.equals("exit")) {
			System.out.println("Do you wish to create a default song? yes, no or exit");
			originalSong = scan.nextLine();
			if (originalSong.equals("yes")) {
				SongList.add(song);

			} else if (originalSong.equals("no")) {
				String title, artist;
				System.out.println("Enter the song title");
				title = scan.nextLine();
				System.out.println("Enter the song artist");
				artist = scan.nextLine();
				Song songs = new Song(title, artist);
				SongList.add(songs);

			}
		}
		return SongList;
	}

	private static void printSongList(LinkedList list) {
		for (int i = 0; i < list.size(); i++) {
			Song tracklist = list.get(i);
			System.out.println("Song " + tracklist + " at position " + i);
		}
	}

	private static void printSongArray(Song[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("Song " + " at position " + array[i]);
		}
	}

	private static void searchAndChange(LinkedList SongList) {
		Scanner scan = new Scanner(System.in);
		String artist, title;
		System.out.println("Enter the song title");
		title = scan.nextLine();
		System.out.println("Enter the song artist");
		artist = scan.nextLine();
		Song songs = new Song(title, artist);
		System.out.println("Position Found at " + SongList.indexOf(songs));
		String fri = "Friday";
		String rebecca = "Rebecca Black";
		Song friday = new Song(fri, rebecca);
//		for (int i = 3; i < SongList.size(); i = i + 3) {
//			SongList.set(i, friday);
//		}
		scan.close();
	}

	private static void isEqual(LinkedList SongList, Song song) {
		boolean isEqual = false;
		int count = 0;
		for (int i = 0; i < SongList.size(); i++) {
			if (SongList.get(i).equals(song)) {
				count++;
				isEqual = true;
			} else {
				isEqual = false;
			}
		}
		if (isEqual) {
			System.out.println("Final Count:" + count);
		} else {
			System.out.println("None Found");
		}

	}

}
