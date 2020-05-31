package ru.netology.manager;

import ru.netology.domain.Film;

public class AfishaManager {
    private Film[] films = new Film[0];
    private int defaultItemsToReturn = 10;
    private int itemsToReturn;

    public AfishaManager() {
    }

        public AfishaManager(int itemsToReturn) {
        this.itemsToReturn = itemsToReturn;
    }

    public void add(Film film) {
        Film[] tmp = new Film[films.length + 1];
        System.arraycopy(films, 0, tmp, 0, films.length);
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    public Film[] getFilms() {
        int arrayLength = films.length;

        if (itemsToReturn <= 0) {
            if (defaultItemsToReturn < films.length) {
                arrayLength = defaultItemsToReturn;
            }
        } else {
            if (itemsToReturn < films.length) {
                arrayLength = itemsToReturn;
            }
        }

        Film[] result = new Film[arrayLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
