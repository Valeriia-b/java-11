package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerDefaultTest {
    AfishaManager manager;
    Film film1 = new Film (1, "Гарри Поттер и филосовский камень", "фэнтези", "http:\\image.jpg");
    Film film2 = new Film (2, "Гарри Поттер и тайная комната", "фэнтези", "http:\\image.jpg");
    Film film3 = new Film (3, "Гарри Поттер и узник Азкабана", "фэнтези", "http:\\image.jpg");
    Film film4 = new Film (4, "Гарри Поттер и кубок огня", "фэнтези", "http:\\image.jpg");
    Film film5 = new Film (5, "Гарри Поттер и принц-полукровка", "фэнтези", "http:\\image.jpg");
    Film film6 = new Film (6, "Гарри Поттер и дары смерти 1", "фэнтези", "http:\\image.jpg");
    Film film7 = new Film (7, "Гарри Поттер и дары сметри 2", "фэнтези", "http:\\image.jpg");
    Film film8 = new Film (8, "Фантастические твари и где они обитают", "фэнтези", "http:\\image.jpg");
    Film film9 = new Film (9, "Фантастические твари преступление Гри-де-Вальда", "фэнтези", "http:\\image.jpg");
    Film film10 = new Film (10, "Фантастические твари и где они обитают 3", "фэнтези", "http:\\image.jpg");
    Film film11 = new Film (11, "Фантастические твари и где они обитают 4", "фэнтези", "http:\\image.jpg");

    @BeforeEach
    void setUp(){
        manager = new AfishaManager ();
    }

    @Test
    void shouldReturnIfAddMoreDefault (){
        Film [] expected = new Film [] {film11, film10, film9, film8, film7, film6, film5,film4,film3,film2};
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);
        manager.add(film11);
        assertArrayEquals(expected, manager.getFilms());
    }

    @Test
    void shouldReturnIfAddLessDefault (){
        Film [] expected = new Film [] {film6, film5,film4,film3,film2, film1};
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        assertArrayEquals(expected, manager.getFilms());
    }

    @Test
    void shouldReturnIfAddDefault (){
        Film [] expected = new Film [] {film10, film9, film8, film7, film6, film5,film4,film3,film2,film1};
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);
        assertArrayEquals(expected, manager.getFilms());
    }

    @Test
    void shouldReturnEmptyArray (){
        assertArrayEquals(new Film[0], manager.getFilms());
    }
}
