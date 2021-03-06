package by.practice.mod06e.book;

import java.util.ArrayList;

public class Library {
	private ArrayList<Book> books;

	public Library() {
		books = new ArrayList<Book>();
	}

	public Library(ArrayList<Book> books) {
		this.books = books;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public void add(Book book) {
		books.add(book);
	}

	// Initially implemented using binary search, but later realized,
	// that book may be added to the library in any order.
	public Book findById(int id) {
		for (Book book : books) {
			if (book.getId() == id) {
				return book;
			}
		}

		throw new RuntimeException("No such book in the Library, id=" + id);
	}

	public ArrayList<Book> findByAuthor(String query) {
		ArrayList<Book> res = new ArrayList<Book>();

		for (Book book : books) {
			String author = book.getAuthor();

			if (author.contains(query)) {
				res.add(book);
			}
		}
		
		return res;
	}

	public ArrayList<Book> findByYearPublished(int query) {
		ArrayList<Book> res = new ArrayList<Book>();

		for (Book book : books) {
			if (book.getYearPublished() == query) {
				res.add(book);
			}
		}

		return res;
	}

	public ArrayList<Book> findByYearPublishedBefore(int query) {
		ArrayList<Book> res = new ArrayList<Book>();

		for (Book book : books) {
			if (book.getYearPublished() < query) {
				res.add(book);
			}
		}

		return res;
	}

	public ArrayList<Book> findByYearPublishedAfter(int query) {
		ArrayList<Book> res = new ArrayList<Book>();

		for (Book book : books) {
			if (book.getYearPublished() > query) {
				res.add(book);
			}
		}

		return res;
	}

	@Override
	public String toString() {
		return "Library [books=" + books + "]";
	}

}
