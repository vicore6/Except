package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    private Repository repository = new Repository();
    private Book firstB = new Book(1, "firstBook", 1, "Author1");
    private Book secondB = new Book(2, "secondBook", 1, "Author2");
    private Book thirdB = new Book(3, "thirdBook", 1, "Author3");
    private Smartphone firstS = new Smartphone(4, "firstSmart", 1, "manufacturer1");
    private Smartphone secondS = new Smartphone(5, "secondSmart", 1, "manufacturer2");
    private Smartphone thirdS = new Smartphone(6, "thirdSmart", 1, "manufacturer3");

    @BeforeEach
    public void before() {
        repository.save(firstB);
        repository.save(secondB);
        repository.save(thirdB);
        repository.save(firstS);
        repository.save(secondS);
        repository.save(thirdS);
    }

    @Test
    public void removeById() {
        Product[] expected = new Product[]{firstB, secondB, thirdB, secondS, thirdS};
        Product[] actual = repository.removeById(4);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdNotFoundException() {
//        Product[] expected = new Product[]{firstB,secondB,thirdB,secondS,thirdS};
//        Product[] actual = repository.removeById(7);
//        assertArrayEquals(expected, actual);
        assertThrows(NotFoundException.class, () -> repository.removeById(9));
    }

}
