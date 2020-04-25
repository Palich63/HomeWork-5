package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfishaManagerTest {

    AfishaManager manager;
    // Создаём фильмы
    Film first = new Film(1, "Бладшот", "боевик");
    Film second = new Film(2, "Вперёд", "мультфильм");
    Film third = new Film(3, "Отель-Белград", "комедия");
    Film fourth = new Film(4, "Маяк", "ужасы");
    Film fifth = new Film(5, "Полицейская история", "боевик");
    Film sixth = new Film(6, "Вперёд", "мультфильм");
    Film seventh = new Film(7, "Джуманджи: Новый уровень", "боевик, приключение");
    Film eighth = new Film(8, "Приди ко мне", "ужасы");
    Film ninth = new Film(9, "Пингвинёнок Пороро", "мультфильм");
    Film tenth = new Film(10, "Котёл", "драма");
    Film eleventh = new Film(11, "1+1", "драма, комедия");

    @BeforeEach
    public void shouldSetup() {
        manager = new AfishaManager();
        //Зaписываем в массив Film[]
        manager.FilmAdd(first);
        manager.FilmAdd(second);
        manager.FilmAdd(third);
        manager.FilmAdd(fourth);
        manager.FilmAdd(fifth);
        manager.FilmAdd(sixth);
        manager.FilmAdd(seventh);
        manager.FilmAdd(eighth);
        manager.FilmAdd(ninth);
        manager.FilmAdd(tenth);
        manager.FilmAdd(eleventh);
    }

    @Test
    void shouldfilmAddToAfisha() {
        //Массива фильмов в прямом порядке и его проверка
        Film[] expected = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        Film[] actual = manager.getFilm();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDisplayByDefaultAfisha() {
        //Выводим фильмы в обратном порядке (по умолчанию 10)
        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Film[] actual = manager.showAfisha();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDisplayfiveFilmsInAfisha() {
        //Выводим последние 5 фильмов
        manager = new AfishaManager(manager.getFilm(), 5);
        Film[] expectedLastFive = new Film[]{eleventh, tenth, ninth, eighth, seventh};
        Film[] actualLastFive = manager.showAfisha();

        assertArrayEquals(expectedLastFive, actualLastFive);
    }

    @Test
    void shouldDisplayThreeFilmsInAfisha() {
        //Выводим последние 3 фильмов
        manager = new AfishaManager(manager.getFilm(), 3);
        Film[] expectedLastThree = new Film[]{eleventh, tenth, ninth};
        Film[] actualLastThree = manager.showAfisha();

        assertArrayEquals(expectedLastThree, actualLastThree);
    }
}