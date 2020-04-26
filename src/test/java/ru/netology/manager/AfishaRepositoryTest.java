package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

@ExtendWith(MockitoExtension.class)
public class AfishaRepositoryTest {

    @Mock //подставляем заглушку вместо реальной реализации
    private AfishaRepository repository;
    @InjectMocks //подставляем заглушку в конструктор
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
    void shouldfindAll() {
        manager = new AfishaManager();
        filmsAddToManager(manager);
    }

    @Test
    void shouldAdd() {
        manager = new AfishaManager();
        filmsAddToManager(manager);

        manager.add();
    }
}
