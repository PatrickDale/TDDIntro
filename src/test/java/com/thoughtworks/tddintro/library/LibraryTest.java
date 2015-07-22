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

    @Before
    public void setup() {
        this.books = new ArrayList<>();
        this.printStream = mock(PrintStream.class);
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
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTime time = new DateTime();
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        verify(printStream).println(contains("The current time is "));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        // implement me
        // then move common test variables into a setup method
    }
}