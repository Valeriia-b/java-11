package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {

    AfishaRepository repository = new AfishaRepository();
    Film film1 = new Film(1, "Гарри Поттер и филосовский камень", "фэнтези", "http:\\image.jpg");
    Film film2 = new Film(2, "Гарри Поттер и тайная комната", "фэнтези", "http:\\image.jpg");
    Film film3 = new Film(3, "Гарри Поттер и узник Азкабана", "фэнтези", "http:\\image.jpg");
    Film film4 = new Film(4, "Гарри Поттер и кубок огня", "фэнтези", "http:\\image.jpg");
    Film film5 = new Film(5, "Гарри Поттер и принц-полукровка", "фэнтези", "http:\\image.jpg");
    Film film6 = new Film(6, "Гарри Поттер и дары смерти 1", "фэнтези", "http:\\image.jpg");
    Film film7 = new Film(7, "Гарри Поттер и дары сметри 2", "фэнтези", "http:\\image.jpg");
    Film film8 = new Film(8, "Фантастические твари и где они обитают", "фэнтези", "http:\\image.jpg");
    Film film9 = new Film(9, "Фантастические твари преступление Гри-де-Вальда", "фэнтези", "http:\\image.jpg");
    Film film10 = new Film(10, "Фантастические твари и где они обитают 3", "фэнтези", "http:\\image.jpg");
    Film film11 = new Film(11, "Фантастические твари и где они обитают 4", "фэнтези", "http:\\image.jpg");


    @Test
    void shouldSave() {
        Film[] expected = new Film[]{film1};
        repository.save(film1);
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldReturn() {
        Film[] expected = new Film[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11};
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.save(film4);
        repository.save(film5);
        repository.save(film6);
        repository.save(film7);
        repository.save(film8);
        repository.save(film9);
        repository.save(film10);
        repository.save(film11);
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldReturnEmptyArray() {
        assertArrayEquals(new Film[0], repository.findAll());
    }

    @Test
    void shouldFindByIdIfExist() {
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        assertEquals(film2, repository.findById(2));
    }

    @Test
    void shouldFindByIdIfNotExist() {
        assertNull(repository.findById(32));
    }

    @Test
    void shouldRemoveAll() {
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.removeAll();
        Film[] expected = new Film[0];
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldRemoveById() {
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.removeById(2);
        Film[] expected = new Film[]{film1, film3};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldNotRemoveByIdIfNotExist() {
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.removeById(5);
        Film[] expected = new Film[]{film1, film2, film3};
        assertArrayEquals(expected, repository.findAll());
    }
}