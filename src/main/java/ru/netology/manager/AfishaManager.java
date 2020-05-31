package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

@NoArgsConstructor
public class AfishaManager {

    private AfishaRepository repository;
    private int defaultItemsToReturn = 10;
    private int itemsToReturn;


    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository, int itemsToReturn) {
        this.repository = repository;
        this.itemsToReturn = itemsToReturn;
    }

    public void save(Film film) {
        repository.save(film);
    }

        public Film[] getFilms () {
            Film[] filmsFromRepo = repository.findAll();
            int arrayLength = filmsFromRepo.length;

            if (itemsToReturn <= 0) {
                if (defaultItemsToReturn < filmsFromRepo.length) {
                    arrayLength = defaultItemsToReturn;
                }
            } else {
                if (itemsToReturn < filmsFromRepo.length) {
                    arrayLength = itemsToReturn;
                }
            }

            Film[] result = new Film[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                int index = filmsFromRepo.length - i - 1;
                result[i] = filmsFromRepo[index];
            }
            return result;
        }
    }
