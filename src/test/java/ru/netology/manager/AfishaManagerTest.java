package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//@ExtendWith(Mockito)
class AfishaManagerTest {

    AfishaManager manager;
    // Создаём фильмы
    static Film first = new Film(1, "Бладшот", "боевик");
    static Film second = new Film(2, "Вперёд", "мультфильм");
    static Film third = new Film(3, "Отель-Белград", "комедия");
    static Film fourth = new Film(4, "Маяк", "ужасы");
    static Film fifth = new Film(5, "Полицейская история", "боевик");
    static Film sixth = new Film(6, "Вперёд", "мультфильм");
    static Film seventh = new Film(7, "Джуманджи: Новый уровень", "боевик, приключение");
    static Film eighth = new Film(8, "Приди ко мне", "ужасы");
    static Film ninth = new Film(9, "Пингвинёнок Пороро", "мультфильм");
    static Film tenth = new Film(10, "Котёл", "драма");
    static Film eleventh = new Film(11, "1+1", "драма, комедия");

    static void filmsAddToManager(AfishaManager manager) {
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
        manager = new AfishaManager();
        filmsAddToManager(manager);
        //Массива фильмов в прямом порядке и его проверка
        Film[] expected = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        Film[] actual = manager.getFilm();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDisplayfiveFilmsInAfisha() {
        manager = new AfishaManager(5);
        filmsAddToManager(manager);

        //Выводим последние 5 фильмов
        Film[] expectedLastFive = new Film[]{eleventh, tenth, ninth, eighth, seventh};
        Film[] actualLastFive = manager.showAfisha();

        assertArrayEquals(expectedLastFive, actualLastFive);
    }

    @Test
    void shouldDisplayThreeFilmsInAfisha() {
        manager = new AfishaManager(3);
        filmsAddToManager(manager);

        //Выводим последние 3 фильмов
        Film[] expectedLastThree = new Film[]{eleventh, tenth, ninth};
        Film[] actualLastThree = manager.showAfisha();

        assertArrayEquals(expectedLastThree, actualLastThree);
    }

    @Test
    void shouldDisplayByDefaultAfisha() {
        manager = new AfishaManager();
        filmsAddToManager(manager);

        //Выводим фильмы в обратном порядке (по умолчанию 10)
        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Film[] actual = manager.showAfisha();

        assertArrayEquals(expected, actual);
    }
}