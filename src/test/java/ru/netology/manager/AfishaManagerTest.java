package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfishaManagerTest {

    private AfishaManager manager;
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
    void filmsAddToManager() {
       manager = new AfishaManager();
        //Зaписываем в массив Film[]
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        manager.filmAdd(seventh);
        manager.filmAdd(eighth);
        manager.filmAdd(ninth);
        manager.filmAdd(tenth);
        manager.filmAdd(eleventh);
    }

    @Test
    void shouldfilmAddToAfisha() {

//        //Массива фильмов в прямом порядке и его проверка
//        Film[] expected = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
//        Film[] actual = manager.getFilms();
//
//        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDisplayfiveFilmsInAfisha() {

//        manager.setLengthOfAfisha(5);
//        //Выводим последние 5 фильмов
//        Film[] expectedLastFive = new Film[]{eleventh, tenth, ninth, eighth, seventh};
//        Film[] actualLastFive = manager.showAfisha();
//
//        assertArrayEquals(expectedLastFive, actualLastFive);
    }

    @Test
    void shouldDisplayThreeFilmsInAfisha() {

//        manager.setLengthOfAfisha(3);
//        //Выводим последние 3 фильмов
//        Film[] expectedLastThree = new Film[]{eleventh, tenth, ninth};
//        Film[] actualLastThree = manager.showAfisha();
//
//        assertArrayEquals(expectedLastThree, actualLastThree);
    }

    @Test
    void shouldDisplayByDefaultAfisha() {

        //Выводим фильмы в обратном порядке (по умолчанию 10)
//        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
//        Film[] actual = manager.showAfisha();
//
//        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDisplayZeroFilmsInAfisha() {
        manager = new AfishaManager(0);
        //Проверка при нулевом значении массива
        Film[] expectedZero = new Film[]{};
        Film[] actualZero = manager.showAfisha();

        assertArrayEquals(expectedZero, actualZero);
    }

    @Test
    void shouldDisplayAfisha() {

        manager = new AfishaManager(12);
        //Проверка вывода при значении массива больше значения по умолчанию
        Film[] expectedDefault = new Film[]{};
        Film[] actualDefault = manager.showAfisha();

        assertArrayEquals(expectedDefault, actualDefault);
    }
}
