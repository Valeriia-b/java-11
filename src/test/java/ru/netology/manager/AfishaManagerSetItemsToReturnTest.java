package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerSetItemsToReturnTest {

    @Mock
    AfishaRepository repository;
    @InjectMocks
    AfishaManager manager;
    private Film film1 = new Film(1, "Гарри Поттер и филосовский камень", "фэнтези", "http:\\image.jpg");
    private Film film2 = new Film(2, "Гарри Поттер и тайная комната", "фэнтези", "http:\\image.jpg");
    private Film film3 = new Film(3, "Гарри Поттер и узник Азкабана", "фэнтези", "http:\\image.jpg");
    private Film film4 = new Film(4, "Гарри Поттер и кубок огня", "фэнтези", "http:\\image.jpg");
    private Film film5 = new Film(5, "Гарри Поттер и принц-полукровка", "фэнтези", "http:\\image.jpg");
    private Film film6 = new Film(6, "Гарри Поттер и дары смерти 1", "фэнтези", "http:\\image.jpg");
    private Film film7 = new Film(7, "Гарри Поттер и дары сметри 2", "фэнтези", "http:\\image.jpg");
    private Film film8 = new Film(8, "Фантастические твари и где они обитают", "фэнтези", "http:\\image.jpg");
    private Film film9 = new Film(9, "Фантастические твари преступление Гри-де-Вальда", "фэнтези", "http:\\image.jpg");
    private Film film10 = new Film(10, "Фантастические твари и где они обитают 3", "фэнтези", "http:\\image.jpg");
    private Film film11 = new Film(11, "Фантастические твари и где они обитают 4", "фэнтези", "http:\\image.jpg");

    @BeforeEach
    void setUp() {
        manager = new AfishaManager(repository, 5);
    }

    @Test
    void shouldReturnIfAddMoreSetDefault() {
        doReturn(new Film[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11}).when(repository).findAll();
        Film[] expected = new Film[]{film11, film10, film9, film8, film7};

        assertArrayEquals(expected, manager.getFilms());
        verify(repository).findAll();
    }

    @Test
    void shouldReturnIfAddLessDefault() {
        doReturn(new Film[]{film1, film2, film3, film4}).when(repository).findAll();
        Film[] expected = new Film[]{film4, film3, film2, film1};

        assertArrayEquals(expected, manager.getFilms());
    }

    @Test
    void shouldReturnIfAddDefault() {
        doReturn(new Film[]{film1, film2, film3, film4, film5}).when(repository).findAll();

        Film[] expected = new Film[]{film5, film4, film3, film2, film1};
        assertArrayEquals(expected, manager.getFilms());
        verify(repository).findAll();
    }

    @Test
    void ifAddLessNullAndFilmsLenghtDefault() {
        manager = new AfishaManager(repository, -1);
        doReturn(new Film[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10}).when(repository).findAll();
        Film[] expected = new Film[]{film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        assertArrayEquals(expected, manager.getFilms());
        verify(repository).findAll();
    }

    @Test
    void ifAddNullAndFilmsLenghtLessDefault() {
        manager = new AfishaManager(repository, 0);
        doReturn(new Film[]{film1, film2, film3, film4, film5}).when(repository).findAll();
        Film[] expected = new Film[]{film5, film4, film3, film2, film1};
        assertArrayEquals(expected, manager.getFilms());
        verify(repository).findAll();
    }

    @Test
    void ifAddLessNullAndFilmsLenghtMoreDefault() {
        manager = new AfishaManager(repository, -1);
        doReturn(new Film[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11}).when(repository).findAll();
        Film[] expected = new Film[]{film11, film10, film9, film8, film7, film6, film5, film4, film3, film2};
        assertArrayEquals(expected, manager.getFilms());
        verify(repository).findAll();
    }
}
