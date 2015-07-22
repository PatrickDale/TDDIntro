package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    List<String> books;
    PrintStream printStream;
    DateTimeFormatter dateTimeFormatter;
    DateTime time;

    @Before
    public void setup() {
        this.books = new ArrayList<>();
        this.printStream = mock(PrintStream.class);
        this.dateTimeFormatter = mock(DateTimeFormatter.class);
        this.time = new DateTime();
    }


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        String title = "Book Title";
        this.books.add(title);
        Library library = new Library(this.books, this.printStream, null);

        library.listBooks();

        verify(this.printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        Library library = new Library(this.books, this.printStream, null);

        library.listBooks();

        verifyZeroInteractions(this.printStream);
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {

        this.books.add("Book Title1");
        this.books.add("Book Title2");
        Library library = new Library(this.books, this.printStream, null);

        library.listBooks();

        verify(this.printStream).println("Book Title1");
        verify(this.printStream).println("Book Title2");
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {

        Library library = new Library(this.books, this.printStream, this.dateTimeFormatter);

        library.welcome(this.time);
        
        verify(this.printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {

        when(this.dateTimeFormatter.print(this.time)).thenReturn("");

        Library library = new Library(this.books, this.printStream, this.dateTimeFormatter);
        library.welcome(this.time);

        verify(this.printStream).println(contains("The current time is "));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        when(this.dateTimeFormatter.print(this.time)).thenReturn("12:38 PM");

        Library library = new Library(this.books, this.printStream, this.dateTimeFormatter);
        library.welcome(this.time);

        verify(this.printStream).println(contains("The current time is 12:38 PM"));
    }
}