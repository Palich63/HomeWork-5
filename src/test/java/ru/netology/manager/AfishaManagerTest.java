package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfishaManagerTest {

    private AfishaManager manager;
    // Создаём фильмы
    private static Film first = new Film(1, "Бладшот", "боевик");
    private static Film second = new Film(2, "Вперёд", "мультфильм");
    private static Film third = new Film(3, "Отель-Белград", "комедия");
    private static Film fourth = new Film(4, "Маяк", "ужасы");
    private static Film fifth = new Film(5, "Полицейская история", "боевик");
    private static Film sixth = new Film(6, "Вперёд", "мультфильм");
    private static Film seventh = new Film(7, "Джуманджи: Новый уровень", "боевик, приключение");
    private static Film eighth = new Film(8, "Приди ко мне", "ужасы");
    private static Film ninth = new Film(9, "Пингвинёнок Пороро", "мультфильм");
    private static Film tenth = new Film(10, "Котёл", "драма");
    private static Film eleventh = new Film(11, "1+1", "драма, комедия");

    static void filmsAddToManager(AfishaManager manager) {
        //Зaписываем в массив Film[]
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
    }

    @Test
    void shouldDisplayThreeFilmsInAfisha() {
        manager = new AfishaManager(3);
        filmsAddToManager(manager);

        //Выводим последние 3 фильмов
        Film[] expectedLastThree = new Film[]{seventh, sixth, fifth};
        Film[] actualLastThree = manager.showAfisha();

        assertArrayEquals(expectedLastThree, actualLastThree);
    }

    @Test
    void shouldDisplayfiveFilmsInAfisha() {
        manager = new AfishaManager(5);
        filmsAddToManager(manager);

        //Выводим последние 5 фильмов
        Film[] expectedLastFive = new Film[]{seventh, sixth, fifth, fourth, third};
        Film[] actualLastFive = manager.showAfisha();

        assertArrayEquals(expectedLastFive, actualLastFive);
    }

    @Test
    void shouldLessDisplayFilm() {
        manager = new AfishaManager();
        filmsAddToManager(manager);

        // Если в массиве меньше 10 фильмов выводим столько сколько есть.
        Film[] expectedSeven = new Film[]{seventh, sixth, fifth, fourth, third, second, first};
        Film[] actualSeven = manager.showAfisha();

        assertArrayEquals(expectedSeven, actualSeven);
    }

    @Test
    void shouldDisplayByDefaultAfisha() {
        manager = new AfishaManager();
        filmsAddToManager(manager);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        //Выводим фильмы в обратном порядке (по умолчанию 10)
        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Film[] actual = manager.showAfisha();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldfilmAddToAfisha() {
        manager = new AfishaManager();
        filmsAddToManager(manager);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        //Массива фильмов в прямом порядке и его проверка
        Film[] expected = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        Film[] actual = manager.show();

        assertArrayEquals(expected, actual);
    }
}