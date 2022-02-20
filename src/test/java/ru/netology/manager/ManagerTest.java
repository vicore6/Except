package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class ManagerTest {
//    @Mock

    private Repository repository1 = new Repository();
    //    @InjectMocks
    private Manager manager = new Manager();
    private Book firstB = new Book(1, "firstBook", 1, "Author1");
    private Book secondB = new Book(2, "secondBook", 1, "Author2");
    private Book thirdB = new Book(3, "thirdBook", 1, "Author3");

    private Smartphone firstS = new Smartphone(4, "firstSmart", 1, "manufacturer1");
    private Smartphone secondS = new Smartphone(5, "secondSmart", 1, "manufacturer2");
    private Smartphone thirdS = new Smartphone(6, "thirdSmart", 1, "manufacturer3");

    @BeforeEach
    public void before() {
        manager.save(firstB);
        manager.save(secondB);
        manager.save(thirdB);
        manager.save(firstS);
        manager.save(secondS);
        manager.save(thirdS);
    }

    @ParameterizedTest
    @CsvSource({"firstBook", "Author1,"})
    void matchesBoookrr(String a) {
        Product[] actual = manager.searchBy(a);
        Book[] expented = new Book[]{firstB};
        assertArrayEquals(expented, actual);
    }


    @Test
    public void matchesBoook() {
        Product[] actual = manager.searchBy("firstBook");
        Product[] expented = new Product[]{firstB};
        assertArrayEquals(expented, actual);
    }

    @Test
    public void matchesBook2() {
        Product[] actual = manager.searchBy("Author3");
        Product[] expented = new Product[]{thirdB};
        assertArrayEquals(expented, actual);
    }

    @Test
    public void matchesBook3() {
        Product[] actual = manager.searchBy("Author5");
        Product[] expented = new Product[]{};
        assertArrayEquals(expented, actual);
    }

    @Test
    public void matchesSmartphone1() {
        Product[] actual = manager.searchBy("manufacturer3");
        Product[] expented = new Product[]{thirdS};
        assertArrayEquals(expented, actual);
    }

    @Test
    public void matchesSmartphone2() {
        Product[] actual = manager.searchBy("secondSmart");
        Product[] expented = new Product[]{secondS};
        assertArrayEquals(expented, actual);
    }

    @Test
    public void matchesSmartphone3() {
        Product[] actual = manager.searchBy("manufacturer4");
        Product[] expented = new Product[]{};
        assertArrayEquals(expented, actual);
    }

    @Test
    public void matchesBoookAndSmartphone() {
        Product[] actual1 = manager.searchBy("firstBook");
        Product[] actual2 = manager.searchBy("manufacturer3");
        Product[] actual = new Product[2];
        actual[0] = actual1[0];
        actual[1] = actual2[0];
        Product[] expented = new Product[]{firstB, thirdS};
        assertArrayEquals(expented, actual);
    }
}
